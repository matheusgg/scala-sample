package bynameparameters

object Main extends App {
  /**
   * By-Name parameters
   */
  // By-Name parameters are not evaluated if they are not used
  def execute(condition: => Boolean)(body: => Unit): Unit = if (condition) {
    println("True!")
    body
  }

  execute(1 < 2) {
    println("execute - 1 < 2") // Body will be evaluated
  }

  execute(1 > 2) {
    println("execute - 1 > 2") // Body will not be evaluated
  }

  // Parameter body will be evaluated on every call
  def execute2(condition: Boolean)(body: Unit): Unit = if (condition) {
    println("True!")
    body
  }

  println("===================")

  execute2(1 < 2) {
    println("execute2 - 1 < 2") // Body will be evaluated
  }

  execute2(1 > 2) {
    println("execute2 - 1 > 2") // Body will be evaluated
  }

}
