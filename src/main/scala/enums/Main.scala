package enums

object Main extends App {
  /**
   * Enums
   */
  object Weekday extends Enumeration {
    val Monday = Value("Mon")
    val Tuesday = Value("Tue")
    val Wednesday, Thursday, Friday, Saturday, Sunday = Value
  }

  println(Weekday.Monday) // Prints Mon
  println(Weekday.Tuesday) // Prints Tue
  println(Weekday.Wednesday) // Prints Wednesday

}
