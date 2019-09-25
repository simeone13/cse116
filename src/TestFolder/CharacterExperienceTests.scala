package TestFolder

import org.scalatest._
import physics.Character

class CharacterExperienceTests extends FunSuite {
  test("Tests XP") {
    val characterA: Character = new Character
    val characterB: Character = new Character
    val characterC: Character = new Character

    characterA.gainXP(50) // character gains XP
    assert(characterA.currentXp == 50) // checks if gained XP is store in currentXP

    characterA.gainXP(50) // extra 50XP to level up
    assert(characterA.level == 2) //checks if character levels up with required XP
    assert(characterA.attackPower == 25) // checks if any stat is increased after lvl up

    characterB.gainXP(300) //gives char enough XP to level up twice
    assert(characterB.level == 3) // checks if char did level up twice

    characterC.gainXP(10000) //made strong to test xp gained from defeating another character
    characterC.fight(characterC, characterA) //makes C fight A (C wins)
    assert(characterC.currentXp == 10040) //checks if XP is updated


  }

}
