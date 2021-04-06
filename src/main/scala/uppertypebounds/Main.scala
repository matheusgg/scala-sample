package uppertypebounds

object Main extends App {

  /**
   * Upper Type
   */
  abstract class Animal {
    def name: String
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

  // Upper type operator (<:) restricts type P to be a subtype of Pet
  class PetContainer[P <: Pet](p: P) {
    def pet: P = p
  }

  val dogContainer = new PetContainer[Dog](new Dog)
  val catContainer = new PetContainer[Cat](new Cat)
  //  val lionContainer = new PetContainer[Lion](new Lion) // Does not compile

}
