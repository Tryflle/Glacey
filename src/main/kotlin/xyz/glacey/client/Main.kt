package xyz.glacey.client

import xyz.glacey.client.event.EventBus
import xyz.glacey.client.feature.impl.rawinput.environ
import net.fabricmc.api.ModInitializer
import xyz.glacey.client.config.GlaceyConfig
import xyz.glacey.client.feature.impl.gameplay.ToggleSprint
import xyz.glacey.client.feature.impl.rawinput.MouseListener
import xyz.glacey.client.testlistener.KeyListener
import xyz.glacey.client.testlistener.ScreenChangeListener

class Main : ModInitializer {

    override fun onInitialize() {
        println("[G] Initialized.")

        eventBus.subscribe(KeyListener())
        eventBus.subscribe(ToggleSprint())
        eventBus.subscribe(ScreenChangeListener)

        GlaceyConfig.load()

        if (GlaceyConfig.i.rawInput) environ.addControllerListener(MouseListener())

        if (GlaceyConfig.i.firstLaunch) {
            GlaceyConfig.i.firstLaunch = false
            GlaceyConfig.save(GlaceyConfig.i)
        }
    }

    companion object {
        val eventBus = EventBus()
    }
}