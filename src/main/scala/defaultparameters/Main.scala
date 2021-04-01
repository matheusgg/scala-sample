package defaultparameters

object Main extends App {

  /**
   * Default parameters can be defined in methods or constructors
   */
  def log(message: String, level: String = "INFO"): Unit = println(s"[$level] $message")

  log("Info message")
  log("Error message", "ERROR")
}
