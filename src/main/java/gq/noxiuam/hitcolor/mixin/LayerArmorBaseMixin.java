package gq.noxiuam.hitcolor.mixin;

import cc.polyfrost.oneconfig.events.EventManager;
import gq.noxiuam.hitcolor.HitColor;
import gq.noxiuam.hitcolor.event.RenderGlintEvent;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LayerArmorBase.class)
public class LayerArmorBaseMixin<T extends ModelBase> {


    /** Entity living base value received by setBrightness */
    private EntityLivingBase entitylivingbaseIn;

    /**
     * Sets {@link #entitylivingbaseIn} so the modified args can use them.
     */
    @Inject(method = "doRenderLayer", at = @At("HEAD"))
    private void setMethodVariables(EntityLivingBase entitylivingbaseIn, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale, CallbackInfo ci) {
        this.entitylivingbaseIn = entitylivingbaseIn;
    }


    /**
     * Affects Armor option.
     */
    @Inject(method = "shouldCombineTextures", at = @At(value = "RETURN"), cancellable = true)
    public void injectShouldCombineTextures(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(HitColor.INSTANCE.config.enabled && HitColor.INSTANCE.config.getAffectArmorToUse(HitColor.INSTANCE.config.getEntityType(this.entitylivingbaseIn)));
    }

    @Inject(method = "renderGlint", at = @At(value = "HEAD"), cancellable = true)
    public void injectRenderGlint(EntityLivingBase entitylivingbaseIn, T modelbaseIn, float p_177183_3_, float p_177183_4_, float partialTicks, float p_177183_6_, float p_177183_7_, float p_177183_8_, float scale, CallbackInfo ci) {
        RenderGlintEvent event = new RenderGlintEvent(entitylivingbaseIn);
        EventManager.INSTANCE.post(event);
        if (event.isCancelled) {
            ci.cancel();
        }
    }

}
