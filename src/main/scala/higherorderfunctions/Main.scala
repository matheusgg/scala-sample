package higherorderfunctions

object Main extends App {
  /**
   * Higher order functions - Are functions that take another function as parameters or return a function as a result
   */
  val salaries = Seq(1000, 2000, 3000)
  println(salaries)

  val doubleSalary = (x: Int) => x * 2
  val newSalaries = salaries.map(doubleSalary)
  println(newSalaries)

  val originalSalaries = newSalaries.map(x => x / 2) // Passing a function directly
  println(originalSalaries)

  // Compiler already knows the type of the parameters, so we just need to provide the right side of the function
  val newSalariesAgain = originalSalaries.map(_ * 2)
  println(newSalariesAgain)

  /**
   * Coercing methods into functions
   */
  def doubleSalaryMethod(x: Int): Int = x * 2

  // Compiler will coerce method "doubleSalaryMethod(Int): Int" into "x => doubleSalaryMethod(x)" function
  val doubledSalaries = salaries.map(doubleSalaryMethod)
  println(doubledSalaries)

  /**
   * Higher order function that accepts another function
   */
  class Greeter {

    def greet(supplier: () => String): Unit = println(s"Hello ${supplier()}!")
  }

  val greeter = new Greeter
  greeter.greet(() => "Scala")

  /**
   * Higher order function that returns another function
   */
  object GreeterFactory {

    def construct(prefix: String, suffix: String): (String) => String = {
      (name: String) => s"$prefix$name$suffix"
    }
  }

  val greeter2 = GreeterFactory.construct("Hey ", "!")
  println(greeter2("Scala"))

}
