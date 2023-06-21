package blackjack.domain

import blackjack.BlackjackGame
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class BlackjackGameTest : BehaviorSpec({

    given("유저가 주어졌다") {
        val users = Users(listOf(User("홍길동")))
        `when`("해당 유저로 게임을 시작하면") {
            then("유저에게 초기덱이 주어진다") {
                val game = BlackjackGame(users)
                game.users.first().deck.size shouldBe BlackjackGame.INITIAL_DECK_SIZE
            }
        }
    }

    given("게임이 하나 주어졌다") {
        val users = Users(listOf(User("홍길동")))
        val game = BlackjackGame(users)

        `when`("해당 게임에서 유저가 히트를 하지 않으면") {
            System.setIn("N".byteInputStream())
            game.dealCards()
            then("카드가 추가되지 않는다") {
                users.first().deck.size shouldBe BlackjackGame.INITIAL_DECK_SIZE
            }
        }

        `when`("해당 게임에서 유저가 한번 히트를 하면") {
            System.setIn("Y\nN".byteInputStream())
            game.dealCards()
            then("카드가 한장 추가된다") {
                users.first().deck.size shouldBe BlackjackGame.INITIAL_DECK_SIZE + 1
            }
        }
    }
})
