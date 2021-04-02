package multipleparameterlists

object Main extends App {
  /**
   * Multiple parameter list
   */
  def execute(text: String)(op: (String) => Unit): Unit = {
    println("Executing operation...")
    op(text)
    println("Operation executed!")
  }

  execute("Scala")(it => println(it))

  // If the last parameter is a function we can use {} to provide a lambda directly
  execute("Scala 2") {
    it => println(it)
  }

  /**
   * Type inference - Scala infers one parameter list at a time
   */
  def execute2[A, B](x: A, y: B)(op: (A, B) => B): B = op(x, y)

  // When compiler already knows the parameter types, we just need to provide the operation (after =>) and use underscore (_) to represent each parameter
  // Both parameters (_) are of type Int because it has already been inferred in the first parameter list
  val result = execute2(10, 20)(_ + _)
  println(result)

  /**
   * Implicit parameters
   */
  // Implicit parameters must be in their own parameter list
  def execute3(x: Int, y: Int)(implicit z: Int): Int = x * y + z

  println(execute3(2, 2)(10))

  /**
   * Partial application
   */
  def sum(x: Int, y: Int)(prefix: String): String = s"$prefix${x + y}"

  println(sum(2, 2)("Result: "))

  // This will generate a function taking the missing parameter list (prefix: String)
  val partialSum = sum(1, 1) _ // String => String
  println(partialSum("Result: "))

  def sum2(x: Int, y: Int)(prefix: String)(suffix: String): String = s"$prefix${x + y}$suffix"

  // This will generate a function taking the 2 missing parameter lists (prefix: String)(suffix: String)
  val partialSum2 = sum2(3, 3) _ // String => String => String
  println(partialSum2("Result: ")("!"))
}
