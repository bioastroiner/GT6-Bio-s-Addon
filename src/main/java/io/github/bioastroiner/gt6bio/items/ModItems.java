package io.github.bioastroiner.gt6bio.items;

import static io.github.bioastroiner.gt6bio.GT6BioMain.MOD_ID;

public class ModItems {
    public static void init(){
        // Initialize GT based Items
        initMetaItems();
    }

    static void initMetaItems(){
        // You may think that you don't want to add all the PrefixItems for all the Materials, since you only need certain ones yourself and don't want a clutter like the one GregTech itself causes.
        // No Problem, you can add single Items too, if you just need those.
        // Assets go into "/assets/insert_your_modid_here/textures/items/example.multiitem.resources/..."
        // The Textures themselves are just the IDs you insert down there. So "0.png" for the Tiny Pile of Examplium Dust.
        new gregapi.item.multiitem.MultiItemRandom(MOD_ID, "gt6bio.multiitem.random") {@Override public void addItems() {
            // Did you know that you can use a variable from outside this Block by just making it "final"? I didn't, but now I know more and use tExamplium, even though it wouldn't be accessible otherwise.
            // And yes you can use all the 32766 possible Meta-IDs of this Item.
            addItem(0,"Drone Based Surveyor", "Drone-based surveys of mineral deposits", null);

            // Here would be a right place to add Crafting Recipes or Machine Recipes using your new Items.

            // Crafting the Dusts together.
//            gregapi.util.CR.shapeless(gregapi.data.OP.dust.mat(tExamplium, 1), gregapi.util.CR.DEF, new Object[] {gregapi.data.OP.dustTiny.dat(tExamplium), gregapi.data.OP.dustTiny.dat(tExamplium), gregapi.data.OP.dustTiny.dat(tExamplium), gregapi.data.OP.dustTiny.dat(tExamplium), gregapi.data.OP.dustTiny.dat(tExamplium), gregapi.data.OP.dustTiny.dat(tExamplium), gregapi.data.OP.dustTiny.dat(tExamplium), gregapi.data.OP.dustTiny.dat(tExamplium), gregapi.data.OP.dustTiny.dat(tExamplium)});
//            gregapi.util.CR.shapeless(gregapi.data.OP.dust.mat(tExamplium, 1), gregapi.util.CR.DEF, new Object[] {gregapi.data.OP.dustSmall.dat(tExamplium), gregapi.data.OP.dustSmall.dat(tExamplium), gregapi.data.OP.dustSmall.dat(tExamplium), gregapi.data.OP.dustSmall.dat(tExamplium)});
//
//            // Smelting the Dusts into Ingots/Nuggets
//            gregapi.data.RM.add_smelting(gregapi.util.ST.make(this, 1, 0), gregapi.util.ST.make(this, 1, 3), 0.1F, false, false, true);
//            gregapi.data.RM.add_smelting(gregapi.util.ST.make(this, 1, 1), gregapi.util.ST.make(this, 1, 4), 0.1F, false, false, true);
//            gregapi.data.RM.add_smelting(gregapi.util.ST.make(this, 1, 2), gregapi.util.ST.make(this, 1, 5), 0.1F, false, false, true);
        }};
    }
}
