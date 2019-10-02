package TestFolder

import org.scalatest._
import physics.Archer
import physics.Tank

class NewCharacterTests extends FunSuite{
  test("Test Archer") {
    val archer: Archer = new Archer

    assert(archer.attackPower == 30)

    archer.gainXP(100)
    assert(archer.level == 2)
    assert(archer.attackPower == 35)

  }
  test("Test Tank") {
    val tank: Tank = new Tank

    assert(tank.attackPower == 20)

    tank.gainXP(100)
    assert(tank.level == 2)
    assert(tank.attackPower == 25)
  }


}
