package extractorobjects

import scala.util.Random

object Main extends App {

  /**
   * Extractor object - It is an object with an unapply method. Unlinke the apply method, unapply receives an object and returns the arguments
   */
  object CustomerID {
    def apply(name: String) = s"$name--${Random.nextLong}"

    def unapply(id: String): Option[String] = {
      val a = id.split("--")
      if (a.tail.nonEmpty) Some(a.head) else None
    }
  }

  val id = CustomerID("Scala") // Here the method apply is called
  id match {
    case CustomerID(name) => println(name) // Here the method unapply is called. Unapply is the inverse of apply
    case _ => println("Invalid")
  }

  val customerID = CustomerID("Scala") // Apply is called and returns Scala--3207172509326212959
  println(customerID)

  // This is equivalent to CustomerId.unapply(customerID).get
  val CustomerID(name) = customerID // Unapply is called and returns Some[Scala]
  println(name)

}
