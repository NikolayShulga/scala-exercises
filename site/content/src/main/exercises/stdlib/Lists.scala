package stdlib

import org.scalatest._

/** Lists
  *
  * Lists Description
  */

object Lists extends FlatSpec with Matchers with exercise.Section {


  /** similarToArraysLists
    *
    * Scala Lists are quite similar to arrays which means, all the elements of a list have the same type but there are two important differences. First, lists are immutable, which means elements of a list cannot be changed by assignment. Second, lists represent a linked list whereas arrays are flat. The type of a list that has elements of type `T` is written as `List[T]`.
    *
    * `eq` tests identity (same object)
    */
  def similarToArraysLists(res0: String) {
    val a = List(1, 2, 3)
    val b = List(1, 2, 3)
    (a eq b) should be(res0)


  }

  /** sameContentLists
    *
    * `==` tests equality (same content)
    */
  def sameContentLists(res0: String) {
    val a = List(1, 2, 3)
    val b = List(1, 2, 3)
    (a == b) should be(res0)


  }

  /** nilListsLists
    *
    * Nil lists are identical, even of different types
    */
  def nilListsLists(res0: String, res1: String, res2: String, res3: String, res4: String, res5: String) {
    val a: List[String] = Nil
    val b: List[Int] = Nil

    (a == Nil) should be(res0)
    (a eq Nil) should be(res1)

    (b == Nil) should be(res2)
    (b eq Nil) should be(res3)

    (a == b) should be(res4)
    (a eq b) should be(res5)


  }

  /** easilyCreatedLists
    *
    * Lists are easily created
    */
  def easilyCreatedLists(res0: String, res1: String, res2: String) {
    val a = List(1, 2, 3)
    a should equal(List(res0, res1, res2))


  }

  /** headAndTailLists
    *
    * Lists can be accessed via head and tail
    */
  def headAndTailLists(res0: String, res1: String, res2: String) {
    val a = List(1, 2, 3)
    a.head should equal(res0)
    a.tail should equal(List(res1, res2))


  }

  /** byPositionLists
    *
    * Lists can be accessed by position
    */
  def byPositionLists(res0: String, res1: String, res2: String) {
    val a = List(1, 3, 5, 7, 9)
    a(0) should equal(res0)
    a(2) should equal(res1)
    a(4) should equal(res2)

    intercept[IndexOutOfBoundsException] {
      println(a(5))
    }


  }

  /** areInmutableLists
    *
    * Lists are immutable
    */
  def areInmutableLists(res0: String, res1: String, res2: String, res3: String) {
    val a = List(1, 3, 5, 7, 9)
    val b = a.filterNot(v => v == 5) // remove where value is 5

    a should equal(List(1, 3, 5, 7, 9))
    b should equal(List(res0, res1, res2, res3))


  }

  /** usefulMethodsLists
    *
    * Lists have many useful methods
    */
  def usefulMethodsLists(res0: String, res1: String, res2: String, res3: String, res4: String, res5: String, res6: String, res7: String, res8: String, res9: String, res10: String, res11: String, res12: String, res13: String, res14: String, res15: String, res16: String, res17: String) {
    val a = List(1, 3, 5, 7, 9)

    // get the length of the list
    a.length should equal(res0)

    // reverse the list
    a.reverse should equal(List(res1, res2, res3, res4, res5))

    // convert the list to a string representation
    a.toString should equal("List(res6, res7, res8, res9, res10)")

    // map a function to double the numbers over the list
    a.map { v => v * 2 } should equal(List(res11, res12, res13, res14, res15))

    // filter any values divisible by 3 in the list
    a.filter { v => v % 3 == 0 } should equal(List(res16, res17))


  }

  /** wildcardAsShorhandLists
    *
    * Functions over lists can use _ as shorthand
    */
  def wildcardAsShorhandLists(res0: String, res1: String, res2: String, res3: String) {
    val a = List(1, 2, 3)

    a.map {
      _ * 2
    } should equal(List(res0, res1, res2))

    a.filter {
      _ % 2 == 0
    } should equal(List(res3))


  }

  /** functionsOverListsLists
    *
    * Functions over lists can use `()` instead of `{}`
    */
  def functionsOverListsLists(res0: String, res1: String, res2: String, res3: String, res4: String) {
    val a = List(1, 2, 3)
    a.map(_ * 2) should equal(List(res0, res1, res2))
    a.filter(_ % 2 != 0) should equal(List(res3, res4))


  }

  /** reducingListsLists
    *
    * Lists can be *reduced* with a mathematical operation
    */
  def reducingListsLists(res0: String, res1: String) {
    val a = List(1, 3, 5, 7)
    a.reduceLeft(_ + _) should equal(res0)
    a.reduceLeft(_ * _) should equal(res1)


  }

  /** foldLeftLists
    *
    * Foldleft is like reduce, but with an explicit starting value
    */
  def foldLeftLists(res0: String, res1: String, res2: String, res3: String) {
    val a = List(1, 3, 5, 7)
    // NOTE: foldLeft uses a form called currying that we will explore later
    a.foldLeft(0)(_ + _) should equal(res0)
    a.foldLeft(10)(_ + _) should equal(res1)
    a.foldLeft(1)(_ * _) should equal(res2)
    a.foldLeft(0)(_ * _) should equal(res3)


  }

  /** fromRangeLists
    *
    * You can create a list from a range
    */
  def fromRangeLists(res0: String, res1: String, res2: String, res3: String, res4: String) {
    val a = (1 to 5).toList
    a should be(List(res0, res1, res2, res3, res4))


  }

  /** reuseTailsLists
    *
    * Lists reuse their tails
    */
  def reuseTailsLists(res0: String, res1: String, res2: String, res3: String, res4: String, res5: String) {
    val d = Nil
    val c = 3 :: d
    val b = 2 :: c
    val a = 1 :: b

    a should be(List(res0, res1, res2))
    a.tail should be(res3)
    b.tail should be(res4)
    c.tail should be(res5)


  }

}