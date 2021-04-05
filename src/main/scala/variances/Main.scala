package variances

object Main extends App {

  /**
   * Covariance - Allows using a subtype where a supertype is expected
   */
  abstract class Animal {
    def name: String
  }

  case class Cat(name: String) extends Animal

  case class Dog(name: String) extends Animal

  def printAnimalNames(animals: List[Animal]): Unit = animals.foreach {
    it => println(it.name)
  }

  // AnimalHolder[+A] is covariant, so we can pass a List[Cat] or a List[Dog] where a List[Animal] is expected
  case class AnimalHolder[+A](items: List[A])

  val catHolder = AnimalHolder[Animal](List(Cat("Whiskers"), Cat("Tom")))
  val dogHolder = AnimalHolder[Animal](List(Dog("Fido"), Dog("Rex")))

  printAnimalNames(catHolder.items) // Passing a list of Cats
  printAnimalNames(dogHolder.items) // Passing a list of Dogs

  /**
   * Contravariance - Allows using a supertype where a subtype is expected when the subtype extends the supertype
   */
  abstract class Printer[-A] {
    def print(value: A): Unit
  }

  class AnimalPrinter extends Printer[Animal] {
    override def print(value: Animal): Unit = println(s"Animal's name is $value")
  }

  class CatPrinter extends Printer[Cat] {
    override def print(value: Cat): Unit = println(s"Cat's name is $value")
  }

  def printCat(printer: Printer[Cat], cat: Cat): Unit = printer.print(cat)

  val catPrinter: Printer[Cat] = new CatPrinter
  val animalPrinter: Printer[Animal] = new AnimalPrinter

  printCat(catPrinter, Cat("Boots"))
  printCat(animalPrinter, Cat("Boots")) // Printer[-A] is contravariant, so we can pass a supertype of Cat (Animal)

  /**
   * Invariance - Does not allow to use different types
   */
  class Container[A](value: A) {
    private var _value: A = value

    def getValue: A = _value

    def setValue(value: A): Unit = _value = value
  }

  val catContainer: Container[Cat] = new Container[Cat](Cat("Felix"))
  val dogContainer: Container[Dog] = new Container[Dog](Dog("Beethoven"))
  val animalContainer: Container[Animal] = new Container[Animal](Cat("Felix"))
  //  val animalContainer2: Container[Animal] = catContainer // Does not compile, Container[A] is invariant

  println(catContainer.getValue)
  println(dogContainer.getValue)
  println(animalContainer.getValue)

}
