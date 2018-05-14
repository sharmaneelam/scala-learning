import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object Solution {

  /** Eliminate consecutive duplicates of list elements.
    * *
    * If a list contains repeated elements they should be replaced with a single copy of the
    *element. The order of the elements should not be changed.
    * Example:
    * scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    * res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
    */
  def compress(lst: Array[String]): Array[String] = {
    var i = 0;
    var j = 1;
    while (j < lst.length) {
      if (lst(i) != lst(j)) {
        /* the duplicate run has ended so we must copy its value to lst[i + 1] */
        i += 1
        lst(i) = lst(j)
        // println(i+":"+lst(i) +":"+ j+":"+ lst(j)+"::"+ lst.mkString(","))
      }
      j += 1
    }
    /** there are compressed elements till i+1. We need to trim sub **/
    lst.slice(0, i + 1)
  }

  compress(List("a", "a", "a", "a", "b", "c", "c", "d", "e", "e", "e", "e").sorted[String](Ordering.String).toArray)

  List("a", "a", "a", "a", "b", "c", "c", "d", "e", "e", "e", "e").sorted[String](Ordering.String)

  /** Pack consecutive duplicates of list elements into sublists.
    * *
    * If a list contains repeated elements they should be placed in separate sublists.
    * *
    * Example:
    * *
    * scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    * res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
    */

  def pack(lst: List[String]): List[List[String]] = {
    val res: ListBuffer[List[String]] = ListBuffer()
    var i = 0;
    var j = 1;
    while (j < lst.length) {
      if (lst(i) != lst(j)) {
        /* the duplicate run has ended so we must copy its value to lst[i + 1] */
        res += lst.slice(i, j)
        println(res.mkString(",") + i + j)
        i = j
      }
      j += 1
    }
    res += lst.slice(i, j)
    res.toList
  }

  pack(List("a", "a", "a", "a", "b", "c", "c", "d", "e", "e", "e", "e"))

  /*
  Duplicate the elements of a list.

  Example:
  scala> duplicate(List('a, 'b, 'c, 'c, 'd))
  res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  * */

  def duplicateN[T](times: Int, list: List[T]): List[T] = {
    list.flatMap(x =>
      List.fill(times)(x)
    )
  }

  duplicateN(3, List("a", 1, "b"))

  /*Drop every Nth element from a list.

  Example:
  scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
  * */

  def drop[T](n: Int, list: List[T]): List[T] = {
    /*list.zipWithIndex.foldLeft(List[T]()) { (acc, tuple) =>
      tuple match {
        case (x, pos) =>
          if ((pos + 1) % n == 0) acc else acc ::: List(x)
      }
    }*/
    var i = 0
    list.filter { _ => i = i + 1; i % n != 0 }
  }

  drop(2, List(1, 2, 3, 4))

  /* Extract a slice from a list.

  Given two indices, I and K, the slice is the list containing the elements from and i
  ncluding the Ith element up to but not including the Kth element of the original list.
  Start counting the elements with 0.

  Example:
  scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  res0: List[Symbol] = List('d, 'e, 'f, 'g)
  *
  * */
  def slice[T](i: Int, k: Int, list: List[T]): List[T] = {
    var ind = 0
    if (i <= k) {
      list.filter { _ => ind = ind + 1; i < ind && ind <= k }
    } else {
      null
    }

  }

  slice(3, 7, List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"))
  slice(3, 4, List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"))
  slice(10, 10, List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"))


}