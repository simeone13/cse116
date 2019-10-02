package TestFolder

import org.scalatest._
import physics.BaseCharacter
import physics.objects.Party

class PartyTest extends FunSuite {
  test ("Test Party XP") {
    val p1: BaseCharacter = new BaseCharacter //Party1
    val p2: BaseCharacter = new BaseCharacter
    val p3: BaseCharacter = new BaseCharacter
    val p4: BaseCharacter = new BaseCharacter
    p2.dead = true
    val p5: BaseCharacter = new BaseCharacter //Party 2
    val p6: BaseCharacter = new BaseCharacter
    val p7: BaseCharacter = new BaseCharacter
    val p8: BaseCharacter = new BaseCharacter

    val chars1: List[BaseCharacter] = List(p1, p2, p3, p4) //List of chars1
    val chars2: List[BaseCharacter] = List(p5, p6, p7, p8) //List of chars2

    val PartyW: Party = new Party() //creates a new party (winner)
    val PartyL: Party = new Party() //creates a new party (winner)
    PartyW.chars = chars1 //makes the party state variable equal to chars1
    PartyL.chars = chars2 //makes the party state variable equal to chars2

    PartyW.defeatedParty(PartyL) // PartyW kills PartyL

    for (chars <- chars1) {
      assert(chars.currentXp == 20) //loops through PartyW characters to check if they gained the XP
      println(chars.currentXp)
    }

  }
}
