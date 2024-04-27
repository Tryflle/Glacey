package xyz.glacey.client.feature.impl.gameplay

import net.minecraft.client.MinecraftClient
import net.minecraft.client.option.KeyBinding
import xyz.glacey.client.event.KeyboardEvent
import xyz.glacey.client.event.Subscribe
import xyz.glacey.client.event.TickEvent

class ToggleSprint {

    private var shouldSprint: Boolean = false

    @Subscribe
    fun onTick(e: TickEvent) {
        if (shouldSprint) {
            KeyBinding.setKeyPressed(MinecraftClient.getInstance()?.options?.sprintKey!!.code, true)
        }
    }

    @Subscribe
    fun keyEvent(e: KeyboardEvent) {
        if (e.key == MinecraftClient.getInstance()?.options?.sprintKey!!.code && e.actionPress) {
            shouldSprint = !shouldSprint
        }
    }
}