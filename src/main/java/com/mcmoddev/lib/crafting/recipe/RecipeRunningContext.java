package com.mcmoddev.lib.crafting.recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.base.ICraftingObject;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;
import com.mcmoddev.lib.crafting.processor.ICraftingProcessor;

public class RecipeRunningContext {
    private final int totalTicks;
    private int currentTick = -1;
    private final Map<String, ICraftingProcessor> processors = new HashMap<>();
    private final List<ICraftingProcessor> allProcessors;
    private final List<ICraftingInventory> temporaryInventories;

    public RecipeRunningContext(final int totalTicks, final List<ICraftingProcessor> processors, final List<ICraftingInventory> temporaryInventories) {
        this.totalTicks = totalTicks;
        this.allProcessors = processors;
        this.temporaryInventories = temporaryInventories;
    }

    public int getTotalTicks() {
        return this.totalTicks;
    }

    public int getCurrentTick() {
        return this.currentTick;
    }

    public boolean isFinished() {
        return this.processors.isEmpty() && (this.currentTick >= this.totalTicks);
    }

    public List<ICraftingInventory> getTemporaryInventories() {
        return new ArrayList<>(this.temporaryInventories);
    }

    public Set<String> getTemporaryInventoryKeys() {
        return this.temporaryInventories.stream()
            .map(ICraftingObject::getKey)
            .collect(Collectors.toSet());
    }

    @Nullable
    public ICraftingInventory findTemporaryInventory(String key) {
        return this.temporaryInventories.stream()
            .filter(i -> i.getKey().equals(key))
            .findFirst()
            .orElse(null);
    }

    public void tick() {
        if (this.processors.size() == 0) {
            // start a new tick
            this.allProcessors.forEach(p -> this.processors.putIfAbsent(p.getKey(), p));
            this.currentTick++;
        }

        // TODO: maybe replace this with some kind of levels sorting for speed and such
        // that would also fix some missing ticks in some cases
        for(String key : new ArrayList<>(this.processors.keySet())) {
            ICraftingProcessor processor = this.processors.get(key);

            // test dependents
            boolean dependentsOk = true;
            for(String dependentKey : processor.getDependencies()) {
                if (this.processors.containsKey(dependentKey)) {
                    // dependent not processed yet... ignoring
                    dependentsOk = false;
                    break;
                }
            }
            if (!dependentsOk) {
                continue;
            }

            if (processor.process(this)) {
                this.processors.remove(key);
            }
        }
    }
}
