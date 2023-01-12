package nz.laspruca.daybreaks

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.metadata.FixedMetadataValue
import org.bukkit.event.player.PlayerMoveEvent as PME

const val metadataKey = "Are you in the sun?"

object PlayerMoveEvent : Listener {
    lateinit var plugin: DayBreaks

    private fun processPlayer(player: Player) {
        player.setMetadata(
            metadataKey,
            FixedMetadataValue(plugin, player.location.y >= player.world.getHighestBlockAt(player.location).y)
        )

        println("Has metadata ${player.hasMetadata(metadataKey)}")
    }

    @EventHandler
    fun handlePlayerMoves(e: PME) {
        processPlayer(e.player)
    }

    @EventHandler
    fun handlePlayerJoin(e: PlayerJoinEvent) {
        processPlayer(e.player)
    }
}