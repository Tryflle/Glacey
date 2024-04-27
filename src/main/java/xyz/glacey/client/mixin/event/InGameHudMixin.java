package xyz.glacey.client.mixin.event;

import xyz.glacey.client.Main;
import xyz.glacey.client.event.Render2DEvent;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Inject(method = "render", at = @At("HEAD"))
    private void onRenderPre(float pt, CallbackInfo ci) {
        Main.Companion.getEventBus().post(new Render2DEvent.Pre(pt));
    }

    @Inject(method = "render", at = @At("TAIL"))
    private void onRenderPost(float pt, CallbackInfo ci) {
        Main.Companion.getEventBus().post(new Render2DEvent.Post(pt));
    }
}
