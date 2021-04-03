package patternmatching

import scala.util.Random

object Main extends App {
  /**
   * Pattern matching - It is a mechanism for checking a value against a pattern
   */
  val x = Random.nextInt(5)

  val result = x match {
    case 0 => "Zero"
    case 1 => "One"
    case 2 => "Two"
    case _ => "None"
  }

  println(result)

  /**
   * Matching on case classes
   */
  abstract class Notification

  case class Mail(sender: String, title: String, body: String) extends Notification

  case class SMS(caller: String, message: String) extends Notification

  case class VoiceRecording(contactName: String, link: String) extends Notification

  def showNotification(notification: Notification): String = {
    notification match {
      // It is possible to declare values to be used inside the case
      // Underscore (_) ignores a value
      case Mail(sender, title, _) => s"You got a mail from $sender with title $title"
      case SMS(number, message) => s"You got an SMS from $number! Message: $message"
      // Values does not need to have the same names declared in the class (contactName -> name)
      case VoiceRecording(name, link) => s"You received a Voice Recording from $name! Click here to hear it: $link"
    }
  }

  val mail = Mail("Scala", "Pattern matching", "https://docs.scala-lang.org/tour/pattern-matching.html")
  val sms = SMS("12345", "How are you?")
  val voice = VoiceRecording("Scala", "https://docs.scala-lang.org/tour/pattern-matching.html")

  println(showNotification(mail))
  println(showNotification(sms))
  println(showNotification(voice))

  /**
   * Pattern guards - Are boolean expressions to make cases more specific
   */
  def showImportantNotification(notification: Notification, importantInfo: Seq[String]): String = {
    notification match {
      case Mail(sender, _, _) if importantInfo.contains(sender) => s"You got a mail from an important person!"
      case SMS(number, _) if importantInfo.contains(number) => s"You got an SMS from an important number!"
      case VoiceRecording(name, _) if importantInfo.contains(name) => s"You received an important Voice Recording!"
    }
  }

  val importantInfo = Seq("Scala", "12345")
  println(showImportantNotification(mail, importantInfo))
  println(showImportantNotification(sms, importantInfo))
  println(showImportantNotification(voice, importantInfo))

  /**
   * Matching on type only
   */
  abstract class Device

  case class Phone() extends Device {
    def screenOff = "Turning screen off"
  }

  case class Computer() extends Device {
    def screenSaverOn = "Turning screen saver on..."
  }

  def goIdle(device: Device) = device match {
    // It is a convention to use the first letter of the type as the case value (p and c)
    case p: Phone => p.screenOff
    case c: Computer => c.screenSaverOn
  }

  println(goIdle(Phone()))
  println(goIdle(Computer()))

  /**
   * Sealed classes - It is possible to mark abstract classes and traits as sealed. All classes that extend a sealed class must be in the same file.
   */
  sealed abstract class Furniture

  case class Couch() extends Furniture

  case class Chair() extends Furniture

  // With sealed classes there is no need to specify the default case (case _ =>)
  def showFurnitureDescription(furniture: Furniture) = furniture match {
    case a: Couch => "It is a couch!"
    case b: Chair => "It is a chair!"
  }

  println(showFurnitureDescription(Couch()))
  println(showFurnitureDescription(Chair()))

}
