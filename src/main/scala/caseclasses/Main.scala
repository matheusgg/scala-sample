package caseclasses

object Main extends App {

  /**
   * Case Classes
   */
  case class Book(price: Double)

  // No need for "new" keyword
  // Case classes have an "apply" method by default responsible for object creation
  val book1 = Book(10) // Or Book.apply(10)
  println(book1)
  println(book1.price)

  /**
   * Parameters
   */
  // Parameters are public val's by default
  case class Message(text: String) // val text: String

  val message = Message("Some message")
  println(message)

  // message.text = "Reassigning" // Does not compile, text is a val

  /**
   * Comparison
   */
  val m1 = Message("Message 1")
  val m2 = Message("Message 1")
  println(m1 == m2) // Instances of case classes are compared by value not by reference

  /**
   * Copy
   */
  // Case classes have a copy method by default
  val m3 = m1.copy()
  println(m3)

  val m4 = m1.copy(text = "Message 2")
  println(m4)

}
