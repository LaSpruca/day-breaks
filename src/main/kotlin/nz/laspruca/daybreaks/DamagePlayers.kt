package nz.laspruca.daybreaks

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import org.bukkit.*
import org.bukkit.block.BlockFace
import org.bukkit.block.PistonMoveReaction
import org.bukkit.entity.*
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.Listener
import org.bukkit.event.entity.CreatureSpawnEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityDamageEvent.DamageCause
import org.bukkit.event.player.PlayerTeleportEvent
import org.bukkit.metadata.MetadataValue
import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionAttachment
import org.bukkit.permissions.PermissionAttachmentInfo
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.plugin.Plugin
import org.bukkit.util.BoundingBox
import org.bukkit.util.Vector
import java.util.*
import kotlin.math.log

object DamagePlayers : Listener {
    lateinit var plugin: DayBreaks

    @EventHandler
    fun bonk(e: PlayerInSunEvent) {
        val player = e.player

        player.damage(4.0,)
    }

    @EventHandler
    fun handleViahs(e: PlayerDeathEvent) {
        val player = e.player

        if (player.lastDamageCause?.cause == DamageCause.CUSTOM && player.lastDamageCause?.damage == 4.0) {
            val deathMessage = Component.text().content("${player.name} withered away in the sunlight.").build()
            e.deathMessage(deathMessage)
        }
    }
}