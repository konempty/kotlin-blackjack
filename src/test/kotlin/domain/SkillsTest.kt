package domain

import dsl.domain.Skill
import dsl.domain.SkillType
import dsl.domain.Skills
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec

class SkillsTest : BehaviorSpec({
    given("빈 능력 리스트가 있다") {
        val list = emptyList<Skill>()
        `when`("해당 리스트로 Skills를 생성하면") {
            then("에러가 던져진다") {
                shouldThrow<IllegalArgumentException> { Skills(list) }
            }
        }
    }

    given("정상적인 능력 리스트가 있다") {
        val list = listOf(Skill("테스트 작성능력", SkillType.SOFT))
        `when`("해당 리스트로 Skills를 생성하면") {
            then("에러가 던져지지 않는다") {
                shouldNotThrow<Throwable> { Skills(list) }
            }
        }
    }
})
