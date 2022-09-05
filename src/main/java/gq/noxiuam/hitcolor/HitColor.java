package gq.noxiuam.hitcolor;

import gq.noxiuam.hitcolor.config.HitColorConfig;

@net.minecraftforge.fml.common.Mod(modid = HitColor.MODID, name = HitColor.NAME, version = HitColor.VERSION)
public class HitColor {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";

    @net.minecraftforge.fml.common.Mod.Instance(MODID)
    public static HitColor INSTANCE;
    public HitColorConfig config;

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void onFMLInitialization(net.minecraftforge.fml.common.event.FMLInitializationEvent event) {
        config = new HitColorConfig();
    }
}
