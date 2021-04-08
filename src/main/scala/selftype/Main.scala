package selftype

object Main extends App {
  /**
   * Self type
   */
  trait User {
    def username: String
  }

  // Self types are a way to declare a dependency between traits without imports using mixin
  trait Tweeter {
    this: User => // Self types allow us to change the type of "this" to another type
    def tweet(text: String): Unit = println(s"$username: $text") // "this" is now a reference to User type, so we can call the method "username" of User
  }

  class VerifiedTweeter(username_ : String) extends Tweeter with User {
    def username = s"$username_"
  }

  val tweet = new VerifiedTweeter("Scala")
  tweet.tweet("Some text")

}
