package xyz.glacey.client.mixin.feature.clearchat;

import net.minecraft.client.gui.hud.ChatHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import xyz.glacey.client.config.GlaceyConfig;

@Mixin(ChatHud.class)
public class ChatHudMixin {

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/ChatHud;fill(IIIII)V", ordinal = 0))
    private void preventChatBackground(int x1, int y1, int x2, int y2, int color) {
        if (!GlaceyConfig.Companion.getI().getClearChat()) {
            ChatHud.fill(x1, y1, x2, y2, color);
        }
    }
}