package TestFolder

import org.scalatest._
import physics.Character
import physics.objects.Party

class PartyTest extends FunSuite {
  test ("Test Party XP") {
    val p1: Character = new Character //Party1
    val p2: Character = new Character
    val p3: Character = new Character
    val p4: Character = new Character

    val p5: Character = new Character //Party 2
    val p6: Character = new Character
    val p7: Character = new Character
    val p8: Character = new Character

    val chars1: List[Character] = List(p1, p2, p3, p4) //List of chars1
    val chars2: List[Character] = List(p5, p6, p7, p8) //List of chars2

    val PartyW: Party = new Party() //creates a new party (winner)
    val PartyL: Party = new Party() //creates a new party (winner)
    PartyW.chars = chars1 //makes the party state variable equal to chars1
    PartyL.chars = chars2 //makes the party state variable equal to chars2

    PartyW.defeatedParty(PartyL) // PartyW kills PartyL

    for (chars <- chars1) {
      assert(chars.currentXp == 20) //loops through PartyW characters to check if they gained the XP
    }

  }
}
