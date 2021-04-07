package abstracttypemembers

object Main extends App {
  /**
   * Abstract type members
   */
  trait Buffer {
    type T
    val element: T
  }

  abstract class SeqBuffer extends Buffer {
    type U
    type T <: Seq[U]

    def length: Int = element.length
  }

  abstract class IntSeqBuffer extends SeqBuffer {
    type U = Int
  }

  def newIntSeqBuf(elem1: Int, elem2: Int): IntSeqBuffer = new IntSeqBuffer {
    override type T = List[U]
    override val element = List(elem1, elem2)
  }

  val buf = newIntSeqBuf(7, 8)
  println(s"length: ${buf.length}")
  println(s"content: ${buf.element}")

}
