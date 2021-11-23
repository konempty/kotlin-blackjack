package blackJack.domain.result

import blackJack.domain.player.Dealer
import blackJack.domain.player.Players

@JvmInline
value class PlayerResults(private val playerResults: List<PlayerResult>) {
    fun toList(): List<PlayerResult> = playerResults.toList()

    companion object {
        fun of(gamePlayers: Players, dealer: Dealer) =
            PlayerResults(
                gamePlayers.map {
                    PlayerResult.winOrLose(it, dealer)
                }
            )
    }
}