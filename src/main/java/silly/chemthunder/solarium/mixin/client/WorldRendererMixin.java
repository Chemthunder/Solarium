package silly.chemthunder.solarium.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.resource.SynchronousResourceReloader;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silly.chemthunder.solarium.index.SolariumStatusEffects;

@Mixin(WorldRenderer.class)
public abstract class WorldRendererMixin implements SynchronousResourceReloader, AutoCloseable {

    @Inject(method = "renderSky", at = @At("TAIL"))
    private void renderSkyNew(Matrix4f matrix4f, Matrix4f projectionMatrix, float tickDelta, Camera camera, boolean thickFog, Runnable fogCallback, CallbackInfo ci) {
        LivingEntity living = MinecraftClient.getInstance().player;

        assert living != null;
        if (living.hasStatusEffect(SolariumStatusEffects.EUPHORIA)) {
            RenderSystem.colorMask(true, false, true, true);
        }
    }
}
