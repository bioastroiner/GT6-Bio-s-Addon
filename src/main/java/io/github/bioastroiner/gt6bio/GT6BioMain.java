package io.github.bioastroiner.gt6bio;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import gregapi.api.Abstract_Mod;
import gregapi.api.Abstract_Proxy;
import io.github.bioastroiner.gt6bio.items.ModItems;


@Mod(modid=GT6BioMain.MOD_ID, name=GT6BioMain.MOD_NAME, version=GT6BioMain.VERSION, dependencies="required-after:gregapi_post; after:gregtech")
public class GT6BioMain extends Abstract_Mod {

    public static final String MOD_ID = "gt6bio";
    public static final String MOD_NAME = "Gregtech 6 Bio's Addon";
    public static final String VERSION = "${version}";
    @Mod.Instance
    public static GT6BioMain instance;

    @SidedProxy(modId = MOD_ID, clientSide = "io.github.bioastroiner.gt6bio.GT6Bio_Client", serverSide = "io.github.bioastroiner.gt6bio.GT6Bio_Server")
    public static Abstract_Proxy PROXY;

    public GT6BioMain(){
        instance=this;
    }

    @Override
    public String getModID() {
        return MOD_ID;
    }

    @Override
    public String getModName() {
        return MOD_NAME;
    }

    @Override
    public String getModNameForLog() {
        return "Gt6_Bio_addon";
    }

    @Override
    public Abstract_Proxy getProxy() {
        return PROXY;
    }

    @Override
    public void onModPreInit2(cpw.mods.fml.common.event.FMLPreInitializationEvent aEvent) {
        ModItems.init();
    }

    @Override
    public void onModInit2(cpw.mods.fml.common.event.FMLInitializationEvent aEvent) {

    }

    @Override
    public void onModPostInit2(cpw.mods.fml.common.event.FMLPostInitializationEvent aEvent) {

    }

    @Override
    public void onModServerStarting2(cpw.mods.fml.common.event.FMLServerStartingEvent aEvent) {

    }

    @Override
    public void onModServerStarted2(cpw.mods.fml.common.event.FMLServerStartedEvent aEvent) {

    }

    @Override
    public void onModServerStopping2(cpw.mods.fml.common.event.FMLServerStoppingEvent aEvent) {

    }

    @Override
    public void onModServerStopped2(cpw.mods.fml.common.event.FMLServerStoppedEvent aEvent) {

    }
}
