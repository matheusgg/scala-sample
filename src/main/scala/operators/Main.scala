package operators

object Main extends App {
  /**
   * Operators
   */
  println(10.+(1)) // In Scala, operators are methods
  println(10 + 1)

  case class Item(x: Int) {

    // Any method with a single parameter can be used as an infix operator
    def +(item: Item): Item = Item(this.x + item.x)
  }

  val item1 = Item(10)
  val item2 = Item(10)

  println(item1 + item2)
  println(item1.+(item2))

}
