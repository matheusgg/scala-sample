package lowertypebounds

object Main extends App {

  /**
   * Lower type
   */
  class Animal {
    def name: String = "Animal"
  }

  abstract class Pet extends Animal

  class Cat extends Pet {
    override def name: String = "Cat"
  }

  class Dog extends Pet {
    override def name: String = "Dog"
  }

  class Lion extends Animal {
    override def name: String = "Lion"
  }

  class Tiger extends Animal {
    override def name: String = "Tiger"
  }

  // Lower operator (>:) restricts A to be a Lion or a supertype of Lion
  class LionPrinter[A >: Lion](l: A) {
    def print(): Unit = println(l)
  }

  val lionPrinter = new LionPrinter[Lion](new Lion)
  lionPrinter.print()

  //  val catPrinter = new LionPrinter[Cat](new Cat) // Does not compile, Cat is not a Lion or a supertype of Lion
  //  catPrinter.print()

  //  val tigerPrinter = new LionPrinter[Tiger](new Tiger) // Does not compile, Tiger is not a Lion or a supertype of Lion
  //  tigerPrinter.print()

  val animalPrinter = new LionPrinter[Animal](new Animal)
  animalPrinter.print()

}
