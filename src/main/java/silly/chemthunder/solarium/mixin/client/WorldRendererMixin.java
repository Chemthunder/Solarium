package silly.chemthunder.solarium.mixin.client;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.resource.SynchronousResourceReloader;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import silly.chemthunder.solarium.index.SolariumStatusEffects;

@Mixin(WorldRenderer.class)
public abstract class WorldRendererMixin implements SynchronousResourceReloader, AutoCloseable {

//    @WrapMethod(method = "renderSky")
//    private void siolly(Matrix4f matrix4f, Matrix4f projectionMatrix, float tickDelta, Camera camera, boolean thickFog, Runnable fogCallback, Operation<Void> original) {
//        if (player != null) {
//            if (player.hasStatusEffect(SolariumStatusEffects.EUPHORIA)) {
//                original.call(matrix4f, projectionMatrix, tickDelta, camera, thickFog, fogCallback);
//            } else {
//                original.call(matrix4f, projectionMatrix, tickDelta, camera, thickFog, fogCallback);
//            }
//        }
//    }

    @Inject(method = "renderSky", at = @At("HEAD"))
    private void silly(Matrix4f matrix4f, Matrix4f projectionMatrix, float tickDelta, Camera camera, boolean thickFog, Runnable fogCallback, CallbackInfo ci) {
        LivingEntity player = MinecraftClient.getInstance().player;
        assert player != null;
        if (player.hasStatusEffect(SolariumStatusEffects.EUPHORIA)) {
            RenderSystem.depthMask(false);
        }
    }

}
