package com.github.nsharma.scalalearning

object exercise{
  def main(args: Array[String]): Unit = {

  }

  /*** TRee example***/
  /*val t1 = Tree.node(4,
    Tree.node(2
      , Tree.node(1)
      , Tree.node(3)
    ) ,
    Tree.node(7
      , Tree.node(6)
      , Tree.node(9)
    )
  )
  println(t1)
  println("Preorder: " + t1.preorder)
  println("Inorder: " + t1.inorder)
  println("Postorder: " + t1.postorder)*/

  /** Remove duplicates from sorted Array **/
  val arr:Array[Any] = Array(0,0,1,1,1,2,2,3,3,4,4,5,6,7)
  println(arr.mkString(","))
  println("Distinct array elements:" + ArrayUtility(arr).removeDuplicates())
 // println("Reverse array :" + ArrayUtility(arr).reverse().mkString(","))
  println("Rotate/shift n positions right  :" + ArrayUtility(arr).rotateRight(5).mkString(","))


}

