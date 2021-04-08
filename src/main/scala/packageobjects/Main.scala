package packageobjects

case class Fruit(name: String, color: String)

object Apple extends Fruit("Apple", "green")

object Plum extends Fruit("Plum", "blue")

object Banana extends Fruit("Banana", "yellow")

// Package objects are members of the package, they are stored in a source file named package.scala
package object fruits {
  val planted = List(Apple, Plum, Banana)

  def showFruit(fruit: Fruit): Unit = println(s"${fruit.name}s are ${fruit.color}")
}

object Main extends App {
  /**
   * Package objects
   */

  import packageobjects.fruits._

  for (fruit <- planted) {
    showFruit(fruit)
  }

}
