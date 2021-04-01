package unifiedtypes

object Main extends App {
  /**
   * All classes extend AnyVal or AnyRef. Any is the main supertype
   */
  val list: List[Any] = List(
    "string",
    732,
    'c',
    true,
    () => "anonymous function"
  )
  list.foreach(it => println(it))

  /**
   * Type cast - Byte -> Short -> Int (Char) -> Long -> Float -> Double
   */
  val x: Long = 987654321
  val y: Float = x
  val face: Char = '☺'
  val number: Int = face
  //  val z: Long = y // Does not compile
  val value: AnyRef = null // Null is a subtype of AnyRef
}
