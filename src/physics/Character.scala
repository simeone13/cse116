package physics

import model.Player

import scala.beans.BooleanBeanProperty

class Character {
  var attackPower: Int = 20
  var defense: Int = 10
  var magicAttack: Int = 20
  var magicDefense: Int = 10
  var maxHP: Int = 100
  var currentHP: Int = this.maxHP
  var maxMP: Int = 100
  var currentMP: Int = this.maxMP

  var dead: Boolean = false

  var level: Int = 1
  var xpToLevel: Int = 100
  var currentXp: Int = 0

  def takeDamage(damage: Int): Unit = { //shows how a character would take damage
    currentHP = currentHP - damage
    if (currentHP <= 0) { // if hp is <= 0 then character is dead
      this.dead = true
    }
  }

  def physicalAttack(character1: Character, character2: Character): Unit = {
    var damage: Int = 0

    if (character1.attackPower > character2.defense) {  //attack > def then take appropriate damage
      damage = character1.attackPower - character2.defense
      character2.takeDamage(damage)

    } else if (character1.attackPower < character2.defense) { // attack < def then deal 5 damage --> may change
      damage = 5
      character2.takeDamage(damage)

    } else if (character1.attackPower == character2.defense) { // if characters = attack and def then take the attack power of the attacker and divide it by 2 and thats the damage
      damage = character1.attackPower / 2
      character2.takeDamage(damage)
    }
  }

  def mageAttack(character1: Character, character2: Character): Unit = {
    var damage: Int = 0
    val magicCost: Int = character1.magicAttack / 2 //how much it costs to use a magic atk

    if (character1.currentMP < magicCost ) { //if MP < cost then you wont be able to use it resulting in 0 damage
      damage = 0
      character1.takeDamage(damage)
    } else {
      if (character1.magicAttack > character2.magicDefense) { // if mag atk > mag def then deals damage and uses the appropriate MP and reduces it
        damage = character1.magicAttack - character2.defense
        character1.currentMP -= magicCost
        character2.takeDamage(damage)
      }
    }
  }

  def gainXP(XP: Int): Unit = {
    var experience: Int = XP
    this.currentXp += experience // currentxp gets added to the experience u gained
    while(this.currentXp >= xpToLevel) { // if the currentxp is >= the xp needed to level then you will level up, and keep leveling up
      this.level += 1
      statUp(this)
      this.xpToLevel += this.level * 100 //takes current level * by 50 and then that is the xp needed to level up
    }
  }

  def statUp(character: Character): Unit = { //when you level up your stats will increase by 5
    this.attackPower += 5
    this.defense += 5
    this.magicAttack += 5
    this.magicDefense += 5
    this.maxHP += 5
    this.maxMP += 5
  }

  def fight(char1: Character, char2: Character): Unit = {
    while (char1.currentHP > 0 || char2.currentHP > 0) { //both are alive
      char2.currentHP -= char1.attackPower / char2.defense //whatever the number is of char1 atk pow / by char2 def is the amt of damage char2 takes. currenthp is subtracted from the atk / def
      char1.currentHP -= char2.attackPower / char1.defense  //whatever the number is of char2 atk pow / by char1 def is the amt of damage char1 takes
      if (char1.currentHP <= 0) {
        char1.dead = true  // does that mean hes alive or dead
        char2.gainXP(char1.level * 20) //takes the level of the character killed and * by 20 and thats the xp gained
      } else if (char2.currentHP <= 0) { //same thing just with the other character
        char2.dead = true
        char1.gainXP(char2.level * 20)
      }
    }
  }

}
