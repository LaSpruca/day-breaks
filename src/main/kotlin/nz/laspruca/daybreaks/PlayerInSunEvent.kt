package nz.laspruca.daybreaks

import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class PlayerInSunEvent(player: Player) : Event() {
    private val _player: Player
    val player: Player
         get() = _player

    init {
        this._player = player
    }

    override fun getHandlers(): HandlerList {
        return handlerList
    }

    companion object {
        private var handlerList = HandlerList()

        @JvmStatic
        fun getHandlerList(): HandlerList {
            return handlerList
        }
    }
}