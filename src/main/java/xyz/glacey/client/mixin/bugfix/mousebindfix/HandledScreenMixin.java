package xyz.glacey.client.mixin.bugfix.mousebindfix;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HandledScreen.class)
public abstract class HandledScreenMixin {

    @Shadow
    protected abstract boolean handleHotbarKeyPressed(int keyCode);

    @Inject(method = "mouseClicked", at = @At("TAIL"))
    public void onMouseClick(int i, int j, int k, CallbackInfo ci) {
        handleHotbarKeyPressed(k - 100);
    }
}
