package blackjack.domain

class Players(val list: List<Player>) {
    fun drawAllPlayer(cardDeck: CardDeck) {
        list.forEach { it.draw(cardDeck) }
    }

    fun forEach(action: (Player) -> Unit) = list.forEach(action)
    fun <T> map(mapper: (Player) -> T) = list.map(mapper)
}