package xyz.glacey.client.gui

import net.minecraft.client.gui.screen.Screen
import xyz.glacey.client.config.GlaceyConfig
import xyz.glacey.client.testlistener.ScreenChangeListener

class ClickGui : Screen() {

    override fun render(mouseX: Int, mouseY: Int, delta: Float) {
        val width = 400
        val height = 200
        val x = (this.width - width) / 2
        val y = (this.height - height) / 2

        // fillGradient(x, y, width, height, getThemeColor1(), getThemeColor2())

        // fill(mouseX-10, mouseY+10, mouseX+10, mouseY-10, -1)

        fill(x+50, y+10, x+width-10, y+height-10, getThemeColor2())

    }

    override fun mouseClicked(mouseX: Int, mouseY: Int, button: Int) {
        super.mouseClicked(mouseX, mouseY, button)
        if (button == 0) {
            toggleTheme()
        }
    }

    private fun getThemeColor1(): Int {
        return if (GlaceyConfig.i.theme == 1) 2029982970
        else 2013438202
    }
    private fun getThemeColor2(): Int {
        return if (GlaceyConfig.i.theme == 1) 2024407295
        else 2014629375
    }

    private fun toggleTheme() {
        GlaceyConfig.i.theme = if (GlaceyConfig.i.theme == 1) 2 else 1
        GlaceyConfig.save(GlaceyConfig.i)
    }

    companion object {
        val screenWidth = ScreenChangeListener.width
        val screenHeight = ScreenChangeListener.height
    }
}