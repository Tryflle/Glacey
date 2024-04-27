package xyz.glacey.client.mixin.event;

import xyz.glacey.client.Main;
import xyz.glacey.client.event.ChatSentEvent;
import net.minecraft.entity.player.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

    @Inject(method = "sendChatMessage", at = @At("HEAD"), cancellable = true)
    private void onSendChatMessage(String message, CallbackInfo ci) {
        ChatSentEvent cse = new ChatSentEvent(message);
        Main.Companion.getEventBus().post(cse);
        if (cse.getCancelled()) {
            ci.cancel();
        }
    }
}
