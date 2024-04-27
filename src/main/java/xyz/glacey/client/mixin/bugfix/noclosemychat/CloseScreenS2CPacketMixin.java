package xyz.glacey.client.mixin.bugfix.noclosemychat;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.CloseScreenS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CloseScreenS2CPacket.class)
public class CloseScreenS2CPacketMixin {

    @Inject(method = "apply(Lnet/minecraft/network/listener/ClientPlayPacketListener;)V", at = @At("HEAD"), cancellable = true)
    private void onApply(ClientPlayPacketListener clientPlayPacketListener, CallbackInfo ci) {
        if (MinecraftClient.getInstance().currentScreen instanceof ChatScreen) ci.cancel();
    }
}