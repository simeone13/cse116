package TestFolder

import org.scalatest._
import physics.BaseCharacter

class AttackTests extends FunSuite{
  test("AttackP") {
    val characterA: BaseCharacter = new BaseCharacter
    val characterB: BaseCharacter = new BaseCharacter

    characterA.physicalAttack(characterA, characterB)
    assert(characterB.currentHP == 90) //attack > def

    characterB.statUp(characterB) // leveled up character to make atk of characterA and def of characterB the same
    characterB.statUp(characterB)
    characterA.physicalAttack(characterA, characterB)
    assert(characterB.currentHP == 80) // attack and defense are =

    characterB.statUp(characterB)
    characterA.physicalAttack(characterA, characterB)
    assert(characterB.currentHP == 75) // attack < def
  }

  test("AttackM") {
    val characterA: BaseCharacter = new BaseCharacter
    val characterB: BaseCharacter = new BaseCharacter

    characterA.mageAttack(characterA, characterB)
    assert(characterA.currentMP == 90) // magic atk cost 10

    characterA.currentMP = 0 // set = 0 to see if deals damage
    characterA.mageAttack(characterA, characterB) // attack after initial with no MP
    assert(characterB.currentHP == 90) //characterB HP not changed
  }
}
