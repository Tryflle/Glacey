package xyz.glacey.client.mixin.event;

import net.minecraft.client.gui.screen.Screen;
import xyz.glacey.client.Main;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.glacey.client.event.*;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        Main.Companion.getEventBus().post(new TickEvent());
    }

    @Inject(method = "handleKeyInput", at = @At("HEAD"), cancellable = true)
    private void onKey(CallbackInfo ci) {
        KeyboardEvent keyboardEvent = new KeyboardEvent(Keyboard.getEventKey(), Keyboard.getEventKeyState());
        Main.Companion.getEventBus().post(keyboardEvent);
        if (keyboardEvent.getCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method = "doAttack", at = @At("HEAD"), cancellable = true)
    private void onAttack(CallbackInfo ci) {
        ClickEvent clickEvent = new ClickEvent(0);
        Main.Companion.getEventBus().post(clickEvent);
        if (clickEvent.getCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method = "doUse", at = @At("HEAD"), cancellable = true)
    private void onUse(CallbackInfo ci) {
        ClickEvent clickEvent = new ClickEvent(1);
        Main.Companion.getEventBus().post(clickEvent);
        if (clickEvent.getCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method = "doPick", at = @At("HEAD"), cancellable = true)
    private void onPick(CallbackInfo ci) {
        ClickEvent clickEvent = new ClickEvent(2);
        Main.Companion.getEventBus().post(clickEvent);
        if (clickEvent.getCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method = "stop", at = @At("HEAD"))
    private void onCloseGame(CallbackInfo ci) {
        Main.Companion.getEventBus().post(new CloseGameEvent());
    }

    @Inject(method = "setScreen", at = @At("HEAD"))
    private void onSetScreen(Screen screen, CallbackInfo ci) {
        Main.Companion.getEventBus().post(new GuiOpenEvent(screen));
    }

    @Inject(method = "onResolutionChanged", at = @At("HEAD"))
    private void onResolutionChanged(int width, int height, CallbackInfo ci) {
        Main.Companion.getEventBus().post(new ScreenResizeEvent(width, height));
    }
}
