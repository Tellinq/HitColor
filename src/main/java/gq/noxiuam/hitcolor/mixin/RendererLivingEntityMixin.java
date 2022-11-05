package gq.noxiuam.hitcolor.mixin;

import cc.polyfrost.oneconfig.config.core.OneColor;
import gq.noxiuam.hitcolor.HitColor;
import gq.noxiuam.hitcolor.config.HitColorConfig;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.nio.FloatBuffer;

@Mixin(RendererLivingEntity.class)
public abstract class RendererLivingEntityMixin {
    private EntityLivingBase entitylivingbaseIn;
    private float partialTicks;

    @Inject(method = "setBrightness", at = @At("HEAD"))
    private void setMethodVariables(EntityLivingBase entitylivingbaseIn, float partialTicks, boolean combineTextures, CallbackInfoReturnable<Boolean> cir) {
        this.entitylivingbaseIn = entitylivingbaseIn;
        this.partialTicks = partialTicks;
    }

    @ModifyArg(method = "setBrightness", at = @At(value = "INVOKE", target = "Ljava/nio/FloatBuffer;put(F)Ljava/nio/FloatBuffer;", ordinal = 0))
    private float getRedTint(float red) {
        HitColorConfig config = HitColor.INSTANCE.config;
        HitColorConfig.HitColorConfiguration e = config.getEntityType(this.entitylivingbaseIn);
        OneColor hitColorToUse = config.getColorToUse(e);
        return this.getTheColor(red, hitColorToUse.getRed(), e);
    }

    @ModifyArg(method = "setBrightness", at = @At(value = "INVOKE", target = "Ljava/nio/FloatBuffer;put(F)Ljava/nio/FloatBuffer;", ordinal = 1))
    private float getGreenTint(float green) {
        HitColorConfig config = HitColor.INSTANCE.config;
        HitColorConfig.HitColorConfiguration entityType = config.getEntityType(this.entitylivingbaseIn);
        OneColor hitColorToUse = config.getColorToUse(entityType);
        return this.getTheColor(green, hitColorToUse.getGreen(), entityType);
    }

    @ModifyArg(method = "setBrightness", at = @At(value = "INVOKE", target = "Ljava/nio/FloatBuffer;put(F)Ljava/nio/FloatBuffer;", ordinal = 2))
    private float getBlueTint(float blue) {
        HitColorConfig config = HitColor.INSTANCE.config;
        HitColorConfig.HitColorConfiguration entityType = config.getEntityType(this.entitylivingbaseIn);
        OneColor hitColorToUse = config.getColorToUse(entityType);
        return this.getTheColor(blue, hitColorToUse.getBlue(), entityType);
    }

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

    private float getTheColor(float color, int specified, HitColorConfig.HitColorConfiguration entityType) {
        HitColorConfig config = HitColor.INSTANCE.config;
        if (config.enabled) {
            boolean affectedByBrightnessToUse = config.getBrightnessToUse(entityType);
            float brightness = affectedByBrightnessToUse ? this.entitylivingbaseIn.getBrightness(this.partialTicks) : 1.0F;
            return (specified / 255F) * brightness;
        }
        return color;
    }

}
