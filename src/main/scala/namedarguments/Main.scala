package namedarguments

object Main extends App {

  /**
   * Named arguments
   */
  class Point(val x: Double = 0, val y: Double = 0)

  val point = new Point(x = 10, y = 20) // Named arguments
  println(point.x)
  println(point.y)

  val point2 = new Point(y = 30, x = 40) // Rearranged arguments
  println(point2.x)
  println(point2.y)
}
