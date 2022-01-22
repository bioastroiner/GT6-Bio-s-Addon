package io.github.bioastroiner.gt6bio.items;

import gregapi.item.multiitem.tools.ToolStats;
import net.minecraft.block.Block;

public class GT_Tool_Sampler_LV extends ToolStats {
    /**
     * aBlock.getHarvestTool(aMetaData) can return the following Values for example.
     * "chisel", "axe", "pickaxe", "sword", "shovel", "hoe", "grafter", "saw", "wrench", "monkeywrench", "crowbar",
     * "file", "hammer", "plow", "plunger", "scoop", "screwdriver", "sense", "scythe", "softhammer", "cutter",
     * "plasmatorch", "solderingtool"
     *
     * @param aBlock
     * @param aMetaData
     * @return If this is a minable Block. Tool Quality checks (like Diamond Tier or something) are separate from
     * this check.
     */
    @Override
    public boolean isMinableBlock(Block aBlock, byte aMetaData) {
        return false;
    }
}
