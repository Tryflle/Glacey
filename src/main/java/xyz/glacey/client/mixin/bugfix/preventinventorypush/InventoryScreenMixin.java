package xyz.glacey.client.mixin.bugfix.preventinventorypush;

import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(InventoryScreen.class)
public class InventoryScreenMixin {


    @Redirect(method = "applyStatusEffectOffset", at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/screen/ingame/InventoryScreen;x:I", ordinal = 0))
    private void removeXOffset(InventoryScreen instance, int value) {}
}