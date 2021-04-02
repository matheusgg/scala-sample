package tuples

object Main extends App {

  /**
   * Tuple - Is a value that contains a fixed number of elements
   */
  val ingredient = ("Sugar", 25)
  println(ingredient)

  val person = ("Scala", 28, 1.90)
  println(person._1)
  println(person._2)
  println(person._3)

  /**
   * Pattern matching on tuples
   */
  val (name, quantity) = ingredient // Decomposing a tuple
  println(name)
  println(quantity)

  val planets = List(
    ("Mercury", 57.9),
    ("Venus", 108.2),
    ("Earth", 149.6),
    ("Mars", 227.9),
    ("Jupter", 778.3),
  )
  planets.foreach {
    case ("Earth", distance) => println(s"Earth: $distance")
    case _ =>
  }

  val pairs = List((1, 2), (3, 4), (5, 6), (7, 8), (9, 0))
  for ((a, b) <- pairs) {
    println(s"$a, $b")
  }
}