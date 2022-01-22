package io.github.bioastroiner.gt6bio.items.behavior;

import com.sun.javafx.geom.Vec3d;
import gregapi.code.ArrayListNoNulls;
import gregapi.data.CS;
import gregapi.data.LH;
import gregapi.data.MT;
import gregapi.data.TD;
import gregapi.item.multiitem.MultiItem;
import gregapi.item.multiitem.behaviors.IBehavior;
import gregapi.oredict.OreDictItemData;
import gregapi.util.OM;
import gregapi.util.UT;
import gregtech.tileentity.placeables.MultiTileEntityRock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static gregapi.data.CS.*;

public class Behavior_Drone_Sampler extends IBehavior.AbstractBehaviorDefault {
    public static final Behavior_Drone_Sampler INSTANCE = new Behavior_Drone_Sampler();

    @Override
    public boolean onItemUse(MultiItem aItem, ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY,
                             int aZ, byte aSide, float hitX, float hitY, float hitZ) {
        if(aPlayer instanceof EntityPlayerMP){
            ArrayList<String> tList = new ArrayListNoNulls<String>();
            Map<Vec3d,MultiTileEntityRock> rMap = new HashMap<>();
            Map<Vec3d,String> oMap = new HashMap<>(); //Ores
            Map<Vec3d,String> sMap = new HashMap<>(); //Stones
            Map<Vec3d,String> uMap = new HashMap<>(); //Uncommon ones (AD or Met)
            long tUsedEnergy = scan(aWorld, aX, aY, aZ, tList, rMap, oMap, sMap, uMap);
            if (tUsedEnergy <= 0) return F;
            if (aItem.useEnergy(TD.Energy.EU, aStack, tUsedEnergy, aPlayer, aPlayer.inventory, aWorld, aX, aY, aZ, T)) UT.Entities.sendchat(aPlayer,tList,false);
            return T;
        }
        UT.Sounds.play(CS.SFX.IC_SCANNER, 20, 1.0F, aX, aY, aZ);
        return aPlayer instanceof EntityPlayerMP;
    }

    private long scan(World aWorld, int aX, int aY, int aZ, ArrayList<String> tList, Map<Vec3d, MultiTileEntityRock> rMap, Map<Vec3d, String> oMap, Map<Vec3d, String> sMap, Map<Vec3d, String> uMap) {
        if (tList == null) return 0;
        long rEUAmount = 0;

        tList.add(LH.Chat.ORANGE + "Receiving Data...");
        search(aWorld, aX, aY, aZ, rMap);
        rMap.forEach((v3, rTile) -> {
            OreDictItemData tData = OM.anydata_(rTile.mRock);
            if(tData != null && tData.hasValidMaterialData()){
                if(tData.mMaterial.mMaterial == MT.Stone || tData.mMaterial.mMaterial == MT.Netherrack || tData.mMaterial.mMaterial == MT.Endstone){
                    return; // just skip this junks
                }
                if(tData.mMaterial.mMaterial == MT.MeteoricIron || tData.mMaterial.mMaterial == MT.Meteorite){
                    uMap.put(v3,"Meteorite");
                    return;
                }
                if (tData.mMaterial.mMaterial == MT.AncientDebris) {
                    uMap.put(v3,"AncientDebris");
                    return;
                }
                if (tData.mMaterial.mMaterial == MT.PetrifiedWood){
                    return; //implement later
                }
                if (tData.mMaterial.mMaterial.contains(TD.Properties.GLOWING)) {
                    return; //implement later
                }
                if (tData.mMaterial.mMaterial.contains(TD.Properties.STONE)) {
                    String rMat = tData.mMaterial.mMaterial.getLocal();
                    sMap.put(v3,rMat);
                    return;
                }
                String rMat = tData.mMaterial.mMaterial.getLocal(); // if you reach here, you are ore
                oMap.put(v3,rMat);
            }
        });

        tList.add(LH.Chat.ORANGE + "Data Collected!");
        tList.add(LH.Chat.GRAY + "======= Stones ======");
        if(!sMap.isEmpty())
        sMap.forEach((v3,mat)->{
            tList.add(LH.Chat.GRAY + mat + formatCoordinates(v3));
        });
        tList.add(LH.Chat.DGREEN + "======= Ores ======");
        if(!oMap.isEmpty())
        oMap.forEach((v3,mat)->{
            tList.add(LH.Chat.GRAY + mat + formatCoordinates(v3));
        });
        tList.add(LH.Chat.BLUE + "======= Anomalies ======");
        if(!uMap.isEmpty())
        uMap.forEach((v3,mat)->{
            tList.add(LH.Chat.GRAY + mat + formatCoordinates(v3));
        });
        rEUAmount = sMap.size() * V[2] + oMap.size() * V[3] + uMap.size() * V[4];
        return rEUAmount;
    }

    private void search(World aWorld, int aX, int aY, int aZ, Map<Vec3d, MultiTileEntityRock> rMap) {
        Chunk cChunk = aWorld.getChunkFromBlockCoords(aX,aZ);
        for(int x = cChunk.xPosition - 2;x <= cChunk.xPosition + 2;x++){
            for(int z = cChunk.zPosition - 2;z <= cChunk.zPosition + 2;z++){
                Chunk aChunk = aWorld.getChunkFromChunkCoords(x,z);
                aChunk.chunkTileEntityMap.values().stream().filter(MultiTileEntityRock.class::isInstance)
                        .forEach(aTile->{rMap.put(new Vec3d(aX,aY,aZ),(MultiTileEntityRock)aTile);});
            }
        }
    }

    private String formatCoordinates(Vec3d v3){
        return " : " + LH.Chat.CYAN + v3.x + LH.Chat.PURPLE + "|" + LH.Chat.RED + v3.y + LH.Chat.PURPLE + "|" + LH.Chat.GREEN + v3.z + " ";
    }

    static {
        LH.add("gt.behaviour.drone", "Launches a Survey-Drone, Collecting General Data on Minerals around you.");
    }


}
