package silly.chemthunder.solarium.mixin;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import silly.chemthunder.solarium.index.SolariumStatusEffects;

@Mixin(StatusEffectUtil.class)
public abstract class StatusEffectUtilMixin {
    @Inject(method = "getDurationText", at = @At("HEAD"), cancellable = true)
    private static void solar$newText(StatusEffectInstance effect, float multiplier, float tickRate, CallbackInfoReturnable<Text> cir) {
        if (effect.getEffectType().equals(SolariumStatusEffects.EUPHORIA)) {
            cir.setReturnValue(Text.translatable("text.effect.euphoria_duration"));
        }
    }
}
