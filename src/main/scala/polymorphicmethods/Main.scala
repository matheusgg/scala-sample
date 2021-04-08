package polymorphicmethods

object Main extends App {
  /**
   * Polymorphic methods
   */
  def listOfDuplicates[A](x: A, length: Int): List[A] = {
    if (length < 1) Nil else x :: listOfDuplicates(x, length - 1)
  }

  println(listOfDuplicates[Int](2, 5))
  println(listOfDuplicates("S", 5)) // When we do not specify the parameter type, compiler will infer it based on the context "listOfDuplicates[String]"

}
