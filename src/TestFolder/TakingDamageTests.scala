package TestFolder

import org.scalatest._
import physics.BaseCharacter

class TakingDamageTests extends FunSuite {
  test("Tests Function") {
    val character1: BaseCharacter = new BaseCharacter
    val character2: BaseCharacter = new BaseCharacter
    val character3: BaseCharacter = new BaseCharacter
    assert(aliveTest() == false)
    assert(nonLethal() == 80)
    assert(lethal() == true)

    def aliveTest(): Boolean = { //checks if the character after taking 5 damage is alive
      character1.takeDamage(5)
      character1.dead
    }

    def nonLethal(): Int = { //taking 20 damage so should = 80 which it does
      character2.takeDamage(20)
      character2.currentHP
    }

    def lethal(): Boolean = { // taking 100 damage so character should be dead which he is
      character3.takeDamage(100)
      character3.dead
    }

  }

}
