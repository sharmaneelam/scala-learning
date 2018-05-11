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

  def pack(lst: Array[String]): Array[Array[String]] = {
    val res:ArrayBuffer[Array[String]] = ArrayBuffer(Array[String]())
    var i = 0;
    var j = 1;
    while (j < lst.length) {
      if (lst(i) != lst(j)) {
        /* the duplicate run has ended so we must copy its value to lst[i + 1] */
        res += lst.slice(i,j-1)
        println(lst.slice(i,j-1).mkString(",") )
        i=j
        j+=1
      }
      j+=1
    }
    res.toArray
  }
  pack(List("a", "a", "a", "a", "b", "c", "c", "d", "e", "e", "e", "e").toArray)
}