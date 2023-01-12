package nz.laspruca.daybreaks

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class DayBreaks : JavaPlugin() {
    var taskId: Int = 0

    override fun onEnable() {
        PlayerMoveEvent.plugin = this
        DamagePlayers.plugin = this

        server.pluginManager.registerEvents(PlayerMoveEvent, this)
        server.pluginManager.registerEvents(DamagePlayers, this)
        taskId = server.scheduler.scheduleSyncRepeatingTask(this, {
            for (player in Bukkit.getOnlinePlayers()) {
                if (player.hasMetadata(metadataKey)) {
                    val metadata = player.getMetadata(metadataKey)
                    if (metadata.isNotEmpty()) {
                        val isInSun = metadata[0].asBoolean()
//                    logger.info("${player.name} $isInSun")
                        if (isInSun) {
                            server.pluginManager.callEvent(PlayerInSunEvent(player))
                        }
                    }
                }
            }
        }, 0, 20)
    }

    override fun onDisable() {
        server.scheduler.cancelTask(taskId)
    }
}