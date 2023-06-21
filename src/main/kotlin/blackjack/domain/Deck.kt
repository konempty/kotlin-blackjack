package blackjack.domain

import java.util.LinkedList

data class Deck(private val cardList: LinkedList<Card>) {
    val size: Int
        get() = cardList.size

    init {
        require(cardList.size > 0) { EMPTY_DECK_ERROR_MESSAGE }
    }

    fun getCard(): Card = checkNotNull(cardList.poll()) { EMPTY_DECK_ERROR_MESSAGE }

    fun addCard(card: Card) {
        cardList.add(card)
    }

    operator fun get(index: Int): Card {
        return cardList[index]
    }

    override fun toString(): String {
        return cardList.joinToString(", ")
    }

    companion object {
        private const val EMPTY_DECK_ERROR_MESSAGE = "덱이 비어있습니다"

        private val DEFAULT_DECK: Deck by lazy {
            val list = LinkedList<Card>()
            for (suit in Suit.values()) {
                list.addSuitCards(suit)
            }
            Deck(list)
        }

        private fun MutableList<Card>.addSuitCards(suit: Suit) {
            for (number in CardNumber.NUMBER_RANGE) {
                add(Card(suit, CardNumber.of(number)))
            }
        }

        fun getShuffledDeck() = Deck(LinkedList(DEFAULT_DECK.cardList.shuffled()))
    }
}