package domain

import dsl.domain.Language
import dsl.domain.Languages
import dsl.domain.Person
import dsl.domain.Skill
import dsl.domain.SkillType
import dsl.domain.Skills
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec

class PersonTest : BehaviorSpec({
    val name = "사용자"
    val company = "회사명"
    val skills = Skills(listOf(Skill("테스트 작성능력", SkillType.SOFT)))
    val languages = Languages(listOf(Language("korean", 1)))

    given("사용자 명이 비어있다") {
        val blankName = " "
        `when`("해당 정보로 사용자를 생성하면") {
            then("에러가 던져진다") {
                shouldThrow<IllegalArgumentException> { Person(blankName, null, skills, languages) }
            }
        }
    }

    given("회사명이 공백이다") {
        val blankCompany = " "
        `when`("해당 정보로 사용자를 생성하면") {
            then("에러가 던져진다") {
                shouldThrow<IllegalArgumentException> { Person(name, blankCompany, skills, languages) }
            }
        }
    }

    given("회사명이 주어지지 않았다") {
        `when`("해당 정보로 사용자를 생성하면") {
            then("에러가 던져지지 않는다") {
                shouldNotThrow<Throwable> { Person(name, null, skills, languages) }
            }
        }
    }

    given("정상적인 정보가 주어졌다") {
        `when`("해당 정보로 사용자를 생성하면") {
            then("에러가 던져지지 않는다") {
                shouldNotThrow<Throwable> { Person(name, company, skills, languages) }
            }
        }
    }
})
