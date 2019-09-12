package physics

import model.Player

import scala.beans.BooleanBeanProperty

class Character {
  var attackPower: Int = 60
  var defense: Int = 50
  var magicAttack: Int = 40
  var magicDefense: Int = 30
  var maxHP: Int = 100
  var currentHP: Int = this.maxHP
  var maxMP: Int = 100
  var currentMP: Int = this.maxMP
  var dead: Boolean = false

  def takeDamage(damage: Int): Unit = {
    currentHP = currentHP - damage
    if (currentHP <= 0) {
      false
    }
  }

  def physicalAttack(): Unit = {
    var damage: Int = 0
    if (attackPower > this.defense){
      damage = attackPower - this.defense
      takeDamage(damage)
    }
  }

  def mageAttack(): Unit = {
    var damage2: Int = 0
    if (magicAttack > this.magicDefense){
      damage2 = magicAttack - this.defense

      takeDamage(damage2)
    }
    if (magicAttack < this.magicDefense){
      damage2 = 0
      takeDamage(damage2)
    }
  }

}
