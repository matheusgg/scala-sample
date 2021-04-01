package classes

object Main extends App {

  /**
   * Simple class
   */
  class User

  val user = new User
  println(user)

  /**
   * Class with members
   */
  class Point(var x: Int, var y: Int) {

    def move(dx: Int, dy: Int): Unit = {
      x = x + dx
      y = y + dy
    }

    override def toString: String = s"($x, $y)"
  }

  val point = new Point(1, 2)
  println(point)
  point.move(1, 1)
  println(point)

  /**
   * Visibility / Getter and Setter
   */
  class Data {
    // Members are public by default
    private var _x = 0
    private var _y = 0

    // Getters
    def x: Int = _x

    def y: Int = _y

    // Setters - Syntax: def attributeName_=(parameters): Unit = {}
    def x_=(newValue: Int): Unit = {
      _x = newValue
    }

    def y_=(newValue: Int): Unit = {
      _y = newValue
    }
  }

  val data = new Data
  println(data.x) // Call getter method x
  println(data.y) // Call getter method y

  data.x = 10 // Call setter method x_=
  data.y = 10 // Call setter method y_=

  println(data.x)
  println(data.y)

  /**
   * Primary constructor
   */
  class Person(var age: Int)

  val person = new Person(28)
  println(person.age)

  /**
   * Primary constructor with default values
   */
  class Info(var x: Int = 0, var y: Int = 0)

  val i1 = new Info
  println(s"${i1.x}, ${i1.y}")

  val i2 = new Info(1)
  println(s"${i2.x}, ${i2.y}")

  val i3 = new Info(y = 1)
  println(s"${i3.x}, ${i3.y}")

  /**
   * Primary constructor parameters
   */
  class Info2(var x: Int) // Parameters with var/val are public by default

  val info2 = new Info2(10)
  println(info2.x)
  info2.x = 20
  println(info2.x)

  // Parameters without var/val are final and private by default
  class Info3(_x: Int) {

    def x: Int = _x

    def x_=(newValue: Int): Unit = {
      //      _x = newValue // Does not compile. Parameter _x is a val
      println(newValue)
    }
  }

  val info3 = new Info3(30)

  //  println(info3._x) // Does not compile. Parameter _x is private
  println(info3.x)
  info3.x = 50
  println(info3.x)

  /**
   * Auxiliary constructors
   */
  class DataHolder(x: Int, y: Int) {

    // Auxiliary constructors are defined with this and must call one of the previously defined constructor
    def this(x: Int) = {
      this(x, 0)
    }

    // No-arg auxiliary constructor
    def this() = this(0)
  }

  val holder1 = new DataHolder
  val holder2 = new DataHolder(1)
  val holder3 = new DataHolder(1, 2)

}
