package me.ohvalsgod.overwatch.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder {

    private ItemStack[] inventory;

    public InventoryBuilder(int size) {
        inventory = new ItemStack[size];
    }

    public InventoryBuilder put(ItemStack itemStack, int slot) {
        if (slot < inventory.length) {
            inventory[slot] = itemStack;
        }
        return this;
    }

    public InventoryBuilder add(ItemStack itemStack) {
        if (availableAmount() < inventory.length) {
            int slot = inventory.length - availableAmount();
            inventory[slot] = itemStack;
        }
        return this;
    }

    public InventoryBuilder remove(int slot) {
        if (slot < inventory.length) {
            inventory[slot] = null;
        }
        return this;
    }

    private int availableAmount() {
        int i = 0;
        for (ItemStack itemStack : inventory) {
            if (itemStack == null || itemStack.getType() == Material.AIR) {
                i++;
            }
        }
        return i;
    }

    public ItemStack[] build() {
        return inventory;
    }

}
