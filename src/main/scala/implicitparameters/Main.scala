package implicitparameters

object Main extends App {
  /**
   * Implicit parameters
   */
  abstract class Monoid[A] {
    def add(x: A, y: A): A

    def unit: A
  }

  implicit val stringMonoid: Monoid[String] = new Monoid[String] {
    override def add(x: String, y: String): String = x concat y

    override def unit: String = ""
  }

  implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
    override def add(x: Int, y: Int): Int = x + y

    override def unit: Int = 0
  }

  // When an implicit parameter is not provided Scala will try to lookup in implicit value to replace the parameter according to the context
  def sum[A](xs: List[A])(implicit m: Monoid[A]): A = if (xs.isEmpty) m.unit else m.add(xs.head, sum(xs.tail))

  println(sum(List(1, 2, 3))) // Will use implicit val intMonoid
  println(sum(List("a", "b", "c"))) // Will use implicit val stringMonoid
}