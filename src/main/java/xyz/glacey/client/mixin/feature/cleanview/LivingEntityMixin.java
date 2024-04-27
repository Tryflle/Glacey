package xyz.glacey.client.mixin.feature.cleanview;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.glacey.client.config.GlaceyConfig;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @SuppressWarnings({"ConstantConditions"})
    @Inject(method = "tickStatusEffects", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;addParticle(Lnet/minecraft/client/particle/ParticleType;DDDDDD[I)V"), cancellable = true)
    private void tickStatusEffects(CallbackInfo ci) {
        if (GlaceyConfig.Companion.getI().getCleanView() && (Object) this == MinecraftClient.getInstance().player) {
            ci.cancel();
        }
    }
}