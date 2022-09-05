package gq.noxiuam.hitcolor.mixin;

import gq.noxiuam.hitcolor.HitColor;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LayerArmorBase.class)
public class LayerArmorBaseMixin {

    /**
     * Affects Armor option.
     */
    @Inject(method = "shouldCombineTextures", at = @At(value = "RETURN"), cancellable = true)
    public void injectShouldCombineTextures(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(HitColor.INSTANCE.config.enabled && HitColor.INSTANCE.config.affectArmor);
    }

}
