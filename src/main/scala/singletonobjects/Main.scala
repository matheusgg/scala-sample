package singletonobjects

object Main extends App {

  /**
   * Singleon object - It is a class that has exactly one instance
   */
  object Logger {
    def info(message: String): Unit = println(s"[INFO ] $message")

    def error(message: String): Unit = println(s"[ERROR] $message")

    def warn(message: String): Unit = println(s"[WARN ] $message")
  }

  Logger.info("Message")
  Logger.error("Message")
  Logger.warn("Message")

  /**
   * Companion objects - Are objects inside a class. They must have the same name of the class and must be in the same file.
   */
  object Circle {
    private def showMessage(): Unit = println("I'm a circle!")
  }

  case class Circle() {

    import Circle._ // Companion object, importing all members and must have the same name of the class

    // A class can access a private member of a companion object
    def salute(): Unit = showMessage()
  }

  val circle = Circle()
  circle.salute()

}
