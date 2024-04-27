package xyz.glacey.client.event

import net.minecraft.client.gui.screen.Screen

class TickEvent : EventType()

class CloseGameEvent : EventType()

class Render3DEvent(val partialTicks: Float) : EventType()

class ChatSentEvent(val message: String) : EventType()

class ClickEvent(val button: Int) : EventType()

class RenderHandEvent(val partialTicks: Float) : EventType()

class GuiOpenEvent(val screen: Screen?) : EventType()

class KeyboardEvent(val key: Int, val actionPress: Boolean) : EventType()

class ScreenResizeEvent(val width: Int, val height: Int) : EventType()

open class PacketEvent(val packet: Any): EventType() {
    class Send(packet: Any) : PacketEvent(packet)
    class Receive(packet: Any) : PacketEvent(packet)
}

open class Render2DEvent(val partialTicks: Float) : EventType() {
    class Pre(partialTicks: Float) : Render2DEvent(partialTicks)
    class Post(partialTicks: Float) : Render2DEvent(partialTicks)
}
