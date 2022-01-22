package io.github.bioastroiner.gt6bio.items.behavior;

import gregapi.code.ArrayListNoNulls;
import gregapi.data.CS;
import gregapi.data.LH;
import gregapi.item.multiitem.MultiItem;
import gregapi.item.multiitem.behaviors.IBehavior;
import gregapi.util.UT;
import gregapi.util.WD;
import gregtech.tileentity.placeables.MultiTileEntityRock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.ArrayList;

public class Behavior_Drone_Sampler extends IBehavior.AbstractBehaviorDefault {
    @Override
    public boolean onItemUse(MultiItem aItem, ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY,
                             int aZ, byte aSide, float hitX, float hitY, float hitZ) {
        if(aPlayer instanceof EntityPlayerMP){
            ArrayList<String> tList = new ArrayListNoNulls<String>();
            TileEntity tTileEntity = WD.te(aWorld,aX,aY,aZ,true);

            if(tTileEntity instanceof MultiTileEntityRock){

            }
        }

        UT.Sounds.play(CS.SFX.IC_SCANNER, 20, 1.0F, aX, aY, aZ);
        return aPlayer instanceof EntityPlayerMP;
    }

    static {
        LH.add("gt.behaviour.drone", "Launches a Survey-Drone, Collecting General Data on Minerals around you.");
    }
}
