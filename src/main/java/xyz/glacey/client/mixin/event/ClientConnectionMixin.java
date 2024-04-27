package xyz.glacey.client.mixin.event;

import xyz.glacey.client.Main;
import xyz.glacey.client.event.PacketEvent;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {

    @Inject(method = "send(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    private void onSendPacket(Packet packet, CallbackInfo ci) {
        PacketEvent packetEvent = new PacketEvent.Send(packet);
        Main.Companion.getEventBus().post(packetEvent);
        if (packetEvent.getCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method = "channelRead0(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    private void onReceivePacket(ChannelHandlerContext channelHandlerContext, Packet packet, CallbackInfo ci) {
        PacketEvent packetEvent = new PacketEvent.Receive(packet);
        Main.Companion.getEventBus().post(packetEvent);
        if (packetEvent.getCancelled()) {
            ci.cancel();
        }
    }
}
