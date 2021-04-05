package genericclasses

object Main extends App {

  /**
   * Generic classes - Are classes which take a type as a parameter
   */
  class Printer[A] { // By convention, letter A is used to identify the type parameter
    def print(value: A): Unit = println(value)
  }

  val printer = new Printer[String]
  printer.print("Scala")

}
