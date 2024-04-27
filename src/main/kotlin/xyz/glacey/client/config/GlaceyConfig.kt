package xyz.glacey.client.config

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class GlaceyConfig(
    var firstLaunch: Boolean = true,
    var rawInput: Boolean = true,
    var cleanView: Boolean = true,
    var clearChat: Boolean = true,
    var theme: Int = 2
) {
    companion object {
        private val path: String = "${System.getProperty("user.home")}/glacey/config.json"
        private val file = File(path)
        val i = load()

        fun save(data: GlaceyConfig) {
            file.parentFile.mkdirs()
            file.writeText(Json.encodeToString(data))
        }

        fun load(): GlaceyConfig = if (file.exists())
            Json.decodeFromString<GlaceyConfig>(file.readText())
        else GlaceyConfig()
    }
}