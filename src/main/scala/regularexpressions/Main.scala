package regularexpressions

object Main extends App {
  /**
   * Regular expressions
   */
  val numberPattern = "[0-9]".r // .r method converts a String into a Regex
  numberPattern.findFirstMatchIn("test") match {
    case Some(_) => println("Password OK")
    case None => println("Password NOK")
  }

  val keyValPattern = "(\\w+): ([0-9]+)".r
  val input =
    """One: 1
      |Two: 2
      |Three: 3
      |""".stripMargin

  for (patternMatch <- keyValPattern.findAllMatchIn(input)) {
    println(s"Key: ${patternMatch.group(1)} - Value: ${patternMatch.group(2)}")
  }
}
