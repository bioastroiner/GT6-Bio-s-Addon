package io.github.bioastroiner.gt6bio.data;

import gregapi.code.IItemContainer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public enum ILB implements IItemContainer {

    ;

    @Override
    public Item item() {
        return null;
    }

    @Override
    public Block block() {
        return null;
    }

    @Override
    public boolean equal(Object aStack) {
        return false;
    }

    @Override
    public boolean equal(Object aStack, boolean aWildcard, boolean aIgnoreNBT) {
        return false;
    }

    @Override
    public ItemStack get(long aAmount, Object... aReplacements) {
        return null;
    }

    @Override
    public ItemStack wild(long aAmount, Object... aReplacements) {
        return null;
    }

    @Override
    public ItemStack getUndamaged(long aAmount, Object... aReplacements) {
        return null;
    }

    @Override
    public ItemStack getAlmostBroken(long aAmount, Object... aReplacements) {
        return null;
    }

    @Override
    public ItemStack getWithMeta(long aAmount, long aMetaValue, Object... aReplacements) {
        return null;
    }

    @Override
    public ItemStack getWithDamage(long aAmount, long aMetaValue, Object... aReplacements) {
        return null;
    }

    @Override
    public ItemStack getWithNBT(long aAmount, NBTTagCompound aNBT, Object... aReplacements) {
        return null;
    }

    @Override
    public ItemStack getWithName(long aAmount, String aDisplayName, Object... aReplacements) {
        return null;
    }

    @Override
    public ItemStack getWithNameAndNBT(long aAmount, String aDisplayName, NBTTagCompound aNBT,
                                       Object... aReplacements) {
        return null;
    }

    @Override
    public ItemStack getWithCharge(long aAmount, long aEnergy, Object... aReplacements) {
        return null;
    }

    @Override
    public IItemContainer set(Item aItem) {
        return null;
    }

    @Override
    public IItemContainer set(ItemStack aStack) {
        return null;
    }

    @Override
    public IItemContainer registerOre(Object... aOreNames) {
        return null;
    }

    @Override
    public IItemContainer registerWildcardAsOre(Object... aOreNames) {
        return null;
    }

    @Override
    public boolean hasBeenSet() {
        return false;
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public Item getItem() {
        return null;
    }

    @Override
    public Block getBlock() {
        return null;
    }

    @Override
    public ItemStack getWildcard(long aAmount, Object... aReplacements) {
        return null;
    }
}
