package xyz.glacey.client.mixin.event;

import xyz.glacey.client.Main;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.glacey.client.event.Render3DEvent;
import xyz.glacey.client.event.RenderHandEvent;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Inject(method = "renderHand", at = @At("HEAD"))
    private void onRenderHand(float a, int b, CallbackInfo ci) {
        Main.Companion.getEventBus().post(new RenderHandEvent(a));
    }

    @Inject(method = "renderWorld(IFJ)V", at = @At("HEAD"))
    private void onRenderWorld(int a, float b, long c, CallbackInfo ci) {
        Main.Companion.getEventBus().post(new Render3DEvent(b));
    }
}