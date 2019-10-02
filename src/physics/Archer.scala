package physics

import scala.collection.mutable.ListBuffer

class Archer{

  var attackPower: Int = 30
  var specialAttack: Int = 0
  var superAttack: Int = 0
  var defense: Int = 10
  var magicAttack: Int = 0
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

  def mageAttack(character: Character): Unit = {}

  def gainXP(XP: Int): Unit = {
    var experience: Int = XP
    this.currentXp += experience // currentxp gets added to the experience u gained
    while (this.currentXp >= xpToLevel) { // if the currentxp is >= the xp needed to level then you will level up
      this.level += 1
      statUp()
      this.xpToLevel = this.level * 100 + this.xpToLevel //takes current level * by 100 and then that is the xp needed to level up
    }
  }

  def statUp(): Unit = { //when you level up your stats will increase by 5
    this.attackPower += 5
    this.defense += 5
    this.maxHP += 5
    this.magicDefense += 5
    if (this.level == 5) { //if you're lvl 5 then your ranged attack will start to increase
      this.specialAttack += 5
    }
    if (this.level == 10) { //if you're lvl 10 then your super attack will start to increase
      this.superAttack += 5
    }
  }

  def learnedMoves(): Unit = {
    if (this.level == 5) { //when you reach level 5 you unlock a new move that will do more damage
      this.specialAttack += 45
    }
    if (this.level == 10) { //when you reach level 10 you unlock another new move which will also do more damage than the previous
      this.superAttack += 50
    }
  }

  def heal(archer: BaseCharacter): Unit = { //h
    archer.currentHP += 10
  }

  def physicalAttack(character: BaseCharacter): Unit = {
    var damage: Int = 0

    if (this.attackPower > character.defense) { //attack > def then take appropriate damage
      damage = this.attackPower - character.defense
      character.takeDamage(damage)

    } else if (this.attackPower < character.defense) { // attack < def then deal 5 damage --> may change
      damage = 5
      character.takeDamage(damage)

    } else if (this.attackPower == character.defense) { // if characters = attack and def then take the attack power of the attacker and divide it by 2 and thats the damage
      damage = this.attackPower / 2
      character.takeDamage(damage)
    }
  }

  def superAttack(character: BaseCharacter): Unit = {
    var damage: Int = 0

    if (this.superAttack > character.defense) { //attack > def then take appropriate damage
      damage = this.superAttack - character.defense
      character.takeDamage(damage)

    } else if (this.superAttack < character.defense) { // attack < def then deal 5 damage --> may change
      damage = 5
      character.takeDamage(damage)

    } else if (this.superAttack == character.defense) { // if characters attack = def then take the superattack amt of the attacker and divide it by 2 and thats the damage
      damage = this.superAttack / 2
      character.takeDamage(damage)
    }
  }

  def specialAttack(character: BaseCharacter): Unit = {
      var damage: Int = 0

      if (this.specialAttack > character.defense) {  //attack > def then take appropriate damage
        damage = this.specialAttack - character.defense
        character.takeDamage(damage)

      } else if (this.specialAttack < character.defense) { // attack < def then deal 5 damage --> may change
        damage = 5
        character.takeDamage(damage)

      } else if (this.specialAttack == character.defense) { // if characters attack =  def then take the special attack of the attacker and divide it by 2 and thats the damage
        damage = this.specialAttack / 2
        character.takeDamage(damage)
      }
  }

  def fight(char: BaseCharacter): Unit = {
    if (this.currentHP > 0 || char.currentHP > 0) { //both are alive
      char.currentHP -= this.attackPower / char.defense //whatever the number is of char1 atk pow / by char2 def is the amt of damage char2 takes. currenthp is subtracted from the atk / def
      this.currentHP -= char.attackPower / this.defense  //whatever the number is of char2 atk pow / by char1 def is the amt of damage char1 takes
      if (this.currentHP <= 0) {
        this.dead = true  // does that mean hes alive or dead
        char.gainXP(this.level * 20) //takes the level of the character killed and * by 20 and thats the xp gained
      } else if (char.currentHP <= 0) { //same thing just with the other character
        char.dead = true
        this.gainXP(char.level * 20)
      }
    }
  }

  def battleOptions(): List[String] = {
    val optionsList: ListBuffer[String] = ListBuffer()
    optionsList(0) = "physicalAttack"
    optionsList(1) = "heal"
    if(this.level == 5) {
      optionsList(2) = "specialAttack"
    }
    if(this.level == 10) {
      optionsList(3) = "superAttack"
    }
    var result: List[String] = List()
    result = optionsList.toList
    result
  }

  def takeAction(move: String, target: BaseCharacter): Unit = {
    if (move == "physicalAttack") {
      physicalAttack(target)
    }
    else if (move == "heal") {
      heal(target)
    }
    else if (this.level == 5) {

    }
  }

}
