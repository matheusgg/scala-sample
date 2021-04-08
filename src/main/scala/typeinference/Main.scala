package typeinference

object Main extends App {
  /**
   * Type inference
   */
  val text = "Scala" // Compiler will infer value type "val text: String"

  def message() = "Scala" // Compiler will infer return type "def message(): String"

  def id[T](x: T) = s"id-$x"

  id(10) // Compiler will infer parameter type T "def id[Int](x: Int)"

  Seq(1, 3, 4).map(x => x * 2) // Compiler will infer function parameter and return types "Int => Int"
}
