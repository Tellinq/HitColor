package gq.noxiuam.hitcolor.mixin;

import cc.polyfrost.oneconfig.config.core.OneColor;
import gq.noxiuam.hitcolor.HitColor;
import gq.noxiuam.hitcolor.config.HitColorConfig;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RendererLivingEntity.class)
public abstract class RendererLivingEntityMixin {

    /** Entity living base value received by setBrightness */
    private EntityLivingBase entitylivingbaseIn;

    /** Partial ticks value received by setBrightness */
    private float partialTicks;

    /**
     * Sets {@link #entitylivingbaseIn} and {@link #partialTicks} so the modified args can use them.
     */
    @Inject(method = "setBrightness", at = @At("HEAD"))
    private void setMethodVariables(EntityLivingBase entitylivingbaseIn, float partialTicks, boolean combineTextures, CallbackInfoReturnable<Boolean> cir) {
        this.entitylivingbaseIn = entitylivingbaseIn;
        this.partialTicks = partialTicks;
    }

    /**
     * Modifies the red tint to use an entity specific or global value
     * @param red The red vanilla color value
     * @return The customized or vanilla value
     */
    @ModifyArg(method = "setBrightness", at = @At(value = "INVOKE", target = "Ljava/nio/FloatBuffer;put(F)Ljava/nio/FloatBuffer;", ordinal = 0))
    private float getRedTint(float red) {
        HitColorConfig config = HitColor.INSTANCE.config;
        HitColorConfig.HitColorConfiguration e = config.getEntityType(this.entitylivingbaseIn);
        OneColor hitColorToUse = config.getColorToUse(e);
        return this.getColor(red, hitColorToUse.getRed(), e);
    }

    /**
     * Modifies the red tint to use an entity specific or global value
     * @param green The green vanilla color value
     * @return The customized or vanilla value
     */
    @ModifyArg(method = "setBrightness", at = @At(value = "INVOKE", target = "Ljava/nio/FloatBuffer;put(F)Ljava/nio/FloatBuffer;", ordinal = 1))
    private float getGreenTint(float green) {
        HitColorConfig config = HitColor.INSTANCE.config;
        HitColorConfig.HitColorConfiguration entityType = config.getEntityType(this.entitylivingbaseIn);
        OneColor hitColorToUse = config.getColorToUse(entityType);
        return this.getColor(green, hitColorToUse.getGreen(), entityType);
    }

    /**
     * Modifies the red tint to use an entity specific or global value
     * @param blue The blue vanilla color value
     * @return The customized or vanilla value
     */
    @ModifyArg(method = "setBrightness", at = @At(value = "INVOKE", target = "Ljava/nio/FloatBuffer;put(F)Ljava/nio/FloatBuffer;", ordinal = 2))
    private float getBlueTint(float blue) {
        HitColorConfig config = HitColor.INSTANCE.config;
        HitColorConfig.HitColorConfiguration entityType = config.getEntityType(this.entitylivingbaseIn);
        OneColor hitColorToUse = config.getColorToUse(entityType);
        return this.getColor(blue, hitColorToUse.getBlue(), entityType);
    }

    /**
     * Modifies the alpha value to use an entity specific or global value
     * @param alpha The red vanilla color value
     * @return The customized or vanilla value.
     */
    @ModifyArg(method = "setBrightness", at = @At(value = "INVOKE", target = "Ljava/nio/FloatBuffer;put(F)Ljava/nio/FloatBuffer;", ordinal = 3))
    private float getAlphaTint(float alpha) {
        HitColorConfig config = HitColor.INSTANCE.config;
        HitColorConfig.HitColorConfiguration entityType = config.getEntityType(this.entitylivingbaseIn);
        if (config.enabled) {
            int animationTypeToUse = config.getAnimationTypeToUse(entityType);
            OneColor hitColorToUse = config.getColorToUse(entityType);
            alpha = hitColorToUse.getAlpha() / 255F;
            if (animationTypeToUse != 0) {
                float percent = 1.0F - (float)this.entitylivingbaseIn.hurtTime / 10.0F;
                if (animationTypeToUse == 1) {
                    percent = percent < 0.5F ? percent / 0.5F : (1.0F - percent) / 0.5F;
                } else if (animationTypeToUse == 2) {
                    percent = (1.0F - percent);
                }

                alpha = alpha * percent;
            }
            return alpha;
        }
        return alpha;
    }

    /**
     * @param color The vanilla value
     * @param configColor The config color
     * @param entityType The entity type
     * @return The customized color, or the vanilla value if the mod is not enabled
     */
    private float getColor(float color, int configColor, HitColorConfig.HitColorConfiguration entityType) {
        HitColorConfig config = HitColor.INSTANCE.config;
        if (config.enabled) {
            boolean affectedByBrightnessToUse = config.getBrightnessToUse(entityType);
            float brightness = affectedByBrightnessToUse ? this.entitylivingbaseIn.getBrightness(this.partialTicks) : 1.0F;
            return (configColor / 255F) * brightness;
        }
        return color;
    }

}
