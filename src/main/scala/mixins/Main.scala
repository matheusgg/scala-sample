package mixins

object Main extends App {

  /**
   * Mixins - A class can have multiple mixins using "with" keyword
   */
  abstract class A {
    val message: String
  }

  class B extends A {
    override val message: String = "Instance of B"
  }

  trait C extends A {
    def loudMessage: String = message.toUpperCase()
  }

  class D extends B with C // Mixin using "with" keyword

  val d = new D
  println(d.message)
  println(d.loudMessage)

  /**
   * Another Mixin
   */
  abstract class AbsIterator {
    type T

    def hasNext: Boolean

    def next: T
  }

  class StringIterator(s: String) extends AbsIterator {
    override type T = Char

    private var i = 0

    override def hasNext: Boolean = i < s.length

    override def next: T = {
      val ch = s charAt i
      i += 1
      ch
    }
  }

  trait RichIterator extends AbsIterator {
    def foreach(f: T => Unit): Unit = while (hasNext) f(next)
  }

  class RichStringIterator(s: String) extends StringIterator(s) with RichIterator

  val iterator = new RichStringIterator("Scala")
  iterator.foreach(println)
}
