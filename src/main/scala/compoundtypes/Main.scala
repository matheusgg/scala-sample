package compoundtypes

object Main extends App {
  /**
   * Compound types
   */
  trait Cloneable extends java.lang.Cloneable {
    override def clone(): Cloneable = {
      super.clone().asInstanceOf[Cloneable]
    }
  }

  trait Resetable {
    def reset(): Unit = {

    }
  }

  // We can compound a parameter type specifying many types using keyword "with"
  def cloneAndReset(obj: Cloneable with Resetable): Cloneable = {
    val cloned = obj.clone()
    obj.reset()
    cloned
  }

}
