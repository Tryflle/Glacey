package xyz.glacey.client.testlistener

import net.minecraft.client.MinecraftClient
import org.lwjgl.input.Keyboard
import xyz.glacey.client.event.KeyboardEvent
import xyz.glacey.client.event.Subscribe
import xyz.glacey.client.gui.ClickGui

class KeyListener {

    private lateinit var clickgui: ClickGui

    @Subscribe
    fun onKey(e: KeyboardEvent) {
        if (e.key == Keyboard.KEY_RSHIFT) {
            if (!this::clickgui.isInitialized) clickgui = ClickGui()
            MinecraftClient.getInstance().setScreen(clickgui)
        }
    }
}