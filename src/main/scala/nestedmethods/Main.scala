package nestedmethods

object Main extends App {
  /**
   * Nested methods - It's possible to nest method definitions
   */
  def greet(name: String): Unit = {
    def internalGreet(name: String): String = {
      s"Hello $name!"
    }

    println(internalGreet(name))
  }

  greet("Scala")

}
