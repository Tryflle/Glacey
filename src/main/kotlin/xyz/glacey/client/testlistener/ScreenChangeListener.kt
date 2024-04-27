package xyz.glacey.client.testlistener

import xyz.glacey.client.event.*

object ScreenChangeListener {

    var width: Int = 1920
    var height: Int = 1080

    @Subscribe
    fun onScreenChange(e: ScreenResizeEvent) {
        width = e.width
        height = e.height
        println("Screen size changed to $width x $height.")
    }
}