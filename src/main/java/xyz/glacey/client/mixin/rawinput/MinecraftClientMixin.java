package xyz.glacey.client.mixin.rawinput;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.MouseInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.glacey.client.config.GlaceyConfig;
import xyz.glacey.client.feature.impl.rawinput.RawInputMouseInput;

@Mixin(value = MinecraftClient.class)
public class MinecraftClientMixin {

    @Shadow
    public MouseInput mouse;

    @Inject(method = "initializeGame", at = @At("TAIL"))
    public void initializeGame(CallbackInfo ci) {
        if (GlaceyConfig.Companion.getI().getRawInput()) mouse = new RawInputMouseInput();
    }
}