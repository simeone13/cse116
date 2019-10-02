package physics

import scala.collection.mutable.ListBuffer

class Tank{

  var attackPower: Int = 20
  var slashAttack: Int = 0
  var critAttack: Int = 0
  var defense: Int = 60
  var magicAttack: Int = 0
  var magicDefense: Int = 60
  var maxHP: Int = 150
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
    if (this.level == 5) { //if you're lvl 5 then your slash attack will start to increase
      this.slashAttack += 5
    }
    if (this.level == 10) { //if you're lvl 10 then your crit attack will start to increase
      this.critAttack += 5
    }
  }

  def learnedMoves(): Unit = {
    if (this.level == 5) { //when you reach level 5 you unlock a new move that will do more damage
      this.slashAttack += 35
    }
    if (this.level == 10) { //when you reach level 10 you unlock another new move which will also do more damage than the previous
      this.critAttack += 55
    }
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

  def slashAttack(character: BaseCharacter): Unit = {
    var damage: Int = 0

    if (this.slashAttack > character.defense) { //attack > def then take appropriate damage
      damage = this.slashAttack - character.defense
      character.takeDamage(damage)

    } else if (this.slashAttack < character.defense) { // attack < def then deal 5 damage --> may change
      damage = 5
      character.takeDamage(damage)

    } else if (this.slashAttack == character.defense) { // if characters attack = def then take the superattack amt of the attacker and divide it by 2 and thats the damage
      damage = this.slashAttack / 2
      character.takeDamage(damage)
    }
  }

  def critAttack(character: BaseCharacter): Unit = {
    var damage: Int = 0

    if (this.critAttack > character.defense) { //attack > def then take appropriate damage
      damage = this.critAttack - character.defense
      character.takeDamage(damage)

    } else if (this.critAttack < character.defense) { // attack < def then deal 5 damage --> may change
      damage = 5
      character.takeDamage(damage)

    } else if (this.critAttack == character.defense) { // if characters attack =  def then take the special attack of the attacker and divide it by 2 and thats the damage
      damage = this.critAttack / 2
      character.takeDamage(damage)
    }
  }

  def fight(char: BaseCharacter): Unit = {
    if (this.currentHP > 0 || char.currentHP > 0) { //both are alive
      char.currentHP -= this.attackPower / char.defense //whatever the number is of char1 atk pow / by char2 def is the amt of damage char2 takes. currenthp is subtracted from the atk / def
      this.currentHP -= char.attackPower / this.defense //whatever the number is of char2 atk pow / by char1 def is the amt of damage char1 takes
      if (this.currentHP <= 0) {
        this.dead = true // does that mean hes alive or dead
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
    if (this.level == 5) {
      optionsList(2) = "specialAttack"
    }
    if (this.level == 10) {
      optionsList(3) = "superAttack"
    }
    var result: List[String] = List()
    result = optionsList.toList
    result

  }
}

