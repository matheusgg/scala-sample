package forcomprehensions

object Main extends App {

  /**
   * For comprehensions - Syntax: for (generator1;generator2;generatorN) yield value. Ex.: for (u <- users) yield u.name
   */
  case class User(name: String, age: Int)

  val users = List(
    User("User 1", 58),
    User("User 2", 19),
    User("User 3", 15),
    User("User 4", 65)
  )

  val olders = for (user <- users if user.age >= 20) yield user.name // yield is used to produce a value
  println(olders)

  for (user <- users if user.age <= 20) println(user.name) // Executing an action instead of producing a value

  /**
   * Two generators
   */
  def foo(n: Int, v: Int) = for (
    i <- 0 until n; // (0, 0)(0, 1)(0, 2)(0, 3)...(0, 9)(1, 0)(1, 1)(1, 2)...
    j <- 0 until n if i + j == v
  ) yield (i, j)

  foo(10, 10) foreach {
    case (i, j) => println(s"($i, $j)")
  }

}
