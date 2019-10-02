package physics.objects

import physics.BaseCharacter

class Party {

  var chars: List[BaseCharacter] = List() //list of characters in party

  def defeatedParty(deadParty: Party): Unit = {
    var xp: Int = 0

    for (dead <- deadParty.chars) {
      xp += dead.level * 20 //goes through each DEAD party member and calculates the amount of XP to give and stores it
    }

    for (character <- chars) { //goes through the Winner party and gives them XP depending if they are dead or alive
      if (character.dead == false) {//if a character is not dead they will get XP
        character.currentXp += (xp / chars.size) //gives XP based on the number of alive characters
      } else {
        character.currentXp = 0
      }
    }
  }

}
