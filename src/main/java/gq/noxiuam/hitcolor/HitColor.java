package gq.noxiuam.hitcolor;

import cc.polyfrost.oneconfig.events.EventManager;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import gq.noxiuam.hitcolor.config.HitColorConfig;
import gq.noxiuam.hitcolor.event.RenderGlintEvent;
import net.minecraft.entity.EntityLivingBase;

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
        EventManager.INSTANCE.register(this);
    }

    @Subscribe
    public void onRenderGlint(RenderGlintEvent event) {
        EntityLivingBase entity = (EntityLivingBase) event.entity;
        if (this.config.enabled && this.config.getRemoveGlintToUse(this.config.getEntityType(entity))) {
            if (entity.hurtTime > 0 || entity.deathTime > 0) {
                event.isCancelled = true;
            }
        }
    }
}
