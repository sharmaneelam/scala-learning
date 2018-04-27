package com.github.nsharma.scalalearning

import com.github.nsharma.scalalearning._

trait Tree[+A]{
  def preorder: List[A]
  def inorder: List[A]
  def postorder: List[A]
  def toDotstring: String
}

case object EmptyTree extends Tree[Nothing] {
  def inorder: List[Nothing] = List()
  def preorder: List[Nothing] = List()
  def postorder: List[Nothing] = List()
  def toDotstring: String = ""
}

case class Node[A](value: A , left: Tree[A], right: Tree[A]) extends Tree[A]{
  def toDotstring: String = value.toString + left.toDotstring + right.toDotstring
  def preorder: List[A] = value :: left.preorder ::: right.preorder
  def inorder: List[A] = left.inorder ::: value :: right.inorder
  def postorder: List[A] = left.postorder ::: right.postorder ::: List(value)
}


object Tree{
  def empty[A]: Tree[A] = EmptyTree
  def node[A](value: A, left: Tree[A] = empty, right: Tree[A] = empty): Tree[A]
  = Node(value, left, right)
}

