package TestFolder

import org.scalatest._
import physics.Character

class AttackTests extends FunSuite{
  test("AttackP") {
    val characterA: Character = new Character
    assert(physAtt() == 90)

    def physAtt(): Int = {
      characterA.physicalAttack()
      characterA.currentHP
    }
  }

  test("AttackM") {
    val characterB: Character = new Character
    assert(magAtt() == 110)

    def magAtt(): Int = {
      characterB.mageAttack()
      characterB.currentHP
    }
  }
}
