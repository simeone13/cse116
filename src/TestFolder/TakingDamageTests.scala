package TestFolder

import org.scalatest._
import physics.Character

class TakingDamageTests extends FunSuite {
  test("Tests Function") {
    val character1: Character = new Character
    val character2: Character = new Character
    val character3: Character = new Character
    assert(aliveTest() == false)
    assert(nonLethal() == 80)
    assert(lethal() == false)


    def aliveTest(): Boolean = {
      character1.takeDamage(5)
      character1.dead
    }

    def nonLethal(): Int = {
      character2.takeDamage(20)
      character2.currentHP
    }

    def lethal(): Boolean = {
      character3.takeDamage(10)
      character3.dead
    }

    def

  }

}
