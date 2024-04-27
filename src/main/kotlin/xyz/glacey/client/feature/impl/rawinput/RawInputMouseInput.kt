package xyz.glacey.client.feature.impl.rawinput

import net.minecraft.client.MouseInput

class RawInputMouseInput : MouseInput() {

    override fun updateMouse() {
        x = 0
        y = 0

        for (mouse in mouses) {
            mouse.poll()
            x += mouse.x.pollData.toInt()
            y -= mouse.y.pollData.toInt()
        }
    }
}