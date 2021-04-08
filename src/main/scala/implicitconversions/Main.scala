package implicitconversions

import scala.language.implicitConversions

object Main extends App {
  /**
   * Implicit conversions
   */
  case class SomeValue(value: Any)

  case class SomeStringValue(value: String)

  // With implicit conversions Scala will lookup for a function (or a convertible method) of the type S => T to convert some value
  implicit def someValueToSomeStringValue(someValue: SomeValue): SomeStringValue = SomeStringValue(someValue.value.toString)

  val someValue = SomeValue(10)
  println(someValue)

  val someStringValue: SomeStringValue = someValue // Scala will call implicit method "someValueToSomeStringValue" to convert SomeValue to a SomeStringValue
  println(someStringValue)

}
