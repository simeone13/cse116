package physics

/**
  * Controls and computes the simulated physics for a game. Manages dynamic object movement, gravity, and
  * object collisions
  */
object PhysicsEngine {

  def updateWorld(world: World, dt: Double): Unit = {
    world.dynamicObjects.head.location.z = (4.0)
  }

}
