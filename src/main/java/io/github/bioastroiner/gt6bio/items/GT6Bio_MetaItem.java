package io.github.bioastroiner.gt6bio.items;

import gregapi.data.TC;
import gregapi.data.TD;
import gregapi.item.multiitem.MultiItemRandom;
import gregapi.item.multiitem.energy.EnergyStat;
import io.github.bioastroiner.gt6bio.GT6BioMain;
import io.github.bioastroiner.gt6bio.items.behavior.Behavior_Drone_Sampler;

import static gregapi.data.CS.V;

public class GT6Bio_MetaItem extends MultiItemRandom {
    public GT6Bio_MetaItem() {
        super(GT6BioMain.MOD_ID, "gt6bio.multiitem.random");
    }

    /**
     * Add your Items here, and not within the Constructor.
     * This gets called after all the PrefixItems and PrefixBlocks have been registered to the OreDict, what is
     * during the @Init-Phase of the regular API.
     */
    @Override
    public void addItems() {
        addItem(0, "Surface Rock Surveying Tool (SRF)", "or SRFT or DSD or DPD, you may call it a Prospector!", Behavior_Drone_Sampler.INSTANCE, EnergyStat.makeTool(TD.Energy.EU, V[2]*8000, V[2], 64, next()));
        addItem(1,"Survey Drone","",TC.stack(TC.MACHINA, 100));
    }
}
