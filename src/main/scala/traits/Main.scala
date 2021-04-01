package traits

object Main extends App {

  /**
   * Traits - Are similar to Java 8 interfaces. A class can extend multiple traits. Traits are peculiarities and cannot be instantiated
   */
  trait BasicTrait

  class Person extends BasicTrait

  /**
   * Extending traits
   */
  trait Iterator[A] {
    def hasNext: Boolean

    def next(): A
  }

  // Extending multiple traits
  class IntIterator(to: Int) extends Iterator[Int] with BasicTrait {
    private var current = 0

    override def hasNext: Boolean = current < to

    override def next(): Int = {
      if (hasNext) {
        val result = current
        current += 1
        result
      } else 0
    }
  }

  val iterator = new IntIterator(3)
  println(iterator.next())
  println(iterator.next())
  println(iterator.next())
  println(iterator.next())

  /**
   * Trait abstract fields - Traits can have abstract fields that must by overridden
   */
  trait Pet {
    val name: String
  }

  class Cat(catName: String) extends Pet {
    override val name: String = catName
  }

  class Dog(val name: String) extends Pet

  val pets = List[Pet](new Cat("Tom"), new Dog("Beethoven"))
  pets.foreach(it => println(it.name))

}
