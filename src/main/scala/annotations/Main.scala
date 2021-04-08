package annotations

import scala.annotation.StaticAnnotation
import scala.reflect.runtime.universe

object Main extends App {
  /**
   * Annotations
   */
  class Info(value: String) extends StaticAnnotation

  @Info("User class")
  case class User(name: String)

  val userType = universe.typeOf[User]
  val symbol = userType.typeSymbol.asClass
  println(symbol.annotations)

}