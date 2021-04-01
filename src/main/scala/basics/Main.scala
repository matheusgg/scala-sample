package basics

/**
 * App makes an object executable. The whole class body becomes main method.
 */
object Main extends App {
  /**
   * Expressions
   */
  println(1 + 1)
  println("Test")

  /**
   * Values
   */
  val x = 1 + 1
  println(x)

  val y: Int = 10 // With type
  println(y)

  /**
   * Variables
   */
  var a = 5 + 5L
  println(a)

  a = 50
  println(a)

  /**
   * Blocks
   */
  println({
    val b = 50 + 50
    b + 10 // The result of the last expression is the result of the block
  })

  val c = {
    val b = 50 + 50
    b + 10
  }
  println(c)

  /**
   * Functions
   */
  val addOne = (x: Int) => x + 1
  println(addOne(10))
  println(addOne.apply(10))

  val sum = (x: Int, y: Int) => x + y
  println(sum(1, 1))

  val greet = () => "Hello!"
  println(greet())

  /**
   * Methods
   */
  def addTwo(x: Int): Int = x + 2

  println(addTwo(1))

  def sayHello() = "Hello!"

  def sayHi = "Hi!" // Methods with no params dont need parentheses

  println(sayHello())
  println(sayHi) // Dont need parentheses

  def addThenMultiply(x: Int, y: Int)(mul: Int): Int = (x + y) * mul

  println(addThenMultiply(1, 2)(3))

  // Multi-line method
  def addThenMultiplyThenSubtract(x: Int, y: Int)(mul: Int)(sub: Int): Int = {
    val sum = x + y
    val multi = sum * mul
    multi - sub // The last expression in the body is the method's return value
  }

  println(addThenMultiplyThenSubtract(1, 2)(3)(9))

  /**
   * Classes
   */
  class Greeter(prefix: String, suffix: String) {
    def greet(name: String): Unit = println(this.prefix + name + this.suffix)
  }

  val greeter = new Greeter("Hello, ", "!")
  greeter.greet("Matheus")

  /**
   * Case classes - Are immutable classes and compared by value instead of reference
   */
  case class Point(x: Int, y: Int)

  val point1 = Point(1, 2) // Instantiates without "new" keyword
  val point2 = Point(1, 2)
  val point3 = Point(2, 2)

  println(point1 == point2) // Compared by value
  println(point1 == point3)

  /**
   * Objects - Are single instances of their own type
   */
  object IdFactory {
    private var counter = 0

    def create(): Int = {
      counter += 1
      counter
    }
  }

  val id1 = IdFactory.create()
  println(id1)

  val id2 = IdFactory.create()
  println(id2)

  /**
   * Traits - Are peculiarities. A class in scala can extend multiple traits
   */
  trait Speaker {
    def speak(): Unit
  }

  trait Talker {
    def talk(name: String): Unit = println("Hey " + name + "!") // Default implementation
  }

  class Person extends Speaker {
    override def speak(): Unit = println("Hello!") // Override a method
  }

  class AnotherPerson extends Talker

  // Extends multiple traits using "with" keyword
  class ThirdPerson extends Speaker with Talker {
    override def speak(): Unit = println("Hey yo!")
  }

  val person = new Person()
  person.speak()

  val anotherPerson = new AnotherPerson()
  anotherPerson.talk("Matheus")

  val thirdPerson = new ThirdPerson()
  thirdPerson.speak()
  thirdPerson.talk("Matheus")
}
