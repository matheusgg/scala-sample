package loops

object Main extends App {
  /**
   * While
   */
  var count = 0
  while (count < 5) {
    println(s"Count: $count")
    count += 1
  }

  /**
   * Do-While
   */
  var count2 = 0
  do {
    println(s"Count2: $count2")
    count2 += 1
  } while (count2 < 5)

  /**
   * For with range
   */
  for (count3 <- 6 to 12) {
    println(s"Count3: $count3")
  }

  for (count4 <- 3 until 5) {
    println(s"Count4: $count4")
  }

  /**
   * For with multiple rages
   */
  for (id <- 1 to 2; mark <- 10 to 12) {
    println(s"Id: $id - Mark: $mark")
  }

  /**
   * For with collections
   */
  val nums = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  for (num <- nums) {
    println(s"Num: $num")
  }

  /**
   * For with filters
   */
  for (num2 <- nums; if num2 >= 3; if num2 <= 6) {
    println(s"Num2: $num2")
  }

  /**
   * For with yield
   */
  val ids = List(1, 2, 3, 4, 5)
  var result = for (id <- ids; if id < 5) yield id
  println(result)

}
