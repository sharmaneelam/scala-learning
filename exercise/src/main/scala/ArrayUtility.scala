package com.github.nsharma.scalalearning
import scala.reflect.ClassTag
case class ArrayUtility(nums: Array[Any]) {
  def apply(nums: Array[Any])={}

  /****************************************
    * Algorithm
     Since the array is already sorted, we can keep two pointers i and j, where i is the slow-runner while j is
     the fast-runner. As long as nums[i] = nums[j]nums[i]=nums[j], we increment j to skip the duplicate.

     When we encounter nums[j] \neq nums[i]nums[j]≠nums[i], the duplicate run has ended so we must copy its value to
     nums[i + 1]nums[i+1]. i is then incremented and we repeat the same process again until j reaches the end of array.
    * @return count of distinct elements
    *
    * Complexity analysis
    * Time complextiy : O(n). Assume that n is the length of array. Each of i and j traverses at most n steps.
    * Space complexity : O(1).
    */
  def removeDuplicates(): Int = {
    /* check for empty Array */
    if (nums.length == 0) return 0
    var i = 0
    var j = 1
    while ( j < nums.length) {
      if ( nums(i) != nums(j)) {
        /* the duplicate run has ended so we must copy its value to nums[i + 1] */
        i += 1
        nums(i) = nums(j)
      }
      /* increment j to */
      j += 1
    }
    return i+1
  }

  /****************************************
    * Algorithm
      replace farther most elements from both ends till middle of array is reached. Here we have 2 pointer i and j ,
      i tracking element from from end and j tracking elements from back end.  Used temp variable for swap.

    * @return reverse array
    *
    * Complexity analysis
    * Time complextiy : O(n/2)=> O(n). Assume that n is the length of array.
    * Space complexity : O(1).
    */
  def reverse(start:Int = 0,end:Int = nums.length-1):Array[Any] ={
    if (nums.length == 0) return nums
    var s = start
    var e = end
    while( s < e ){
      val t = nums(s)
      nums(s) = nums(e)
      nums(e) = t
      s +=1
      e -=1
    }
    return nums
  }

  /*********************************************************
    * Algorithm
    We have to rotate the elements of the given array k times to the right.
    This approach is based on the fact that when we rotate the array k times, k elements from the back end of the array
    come to the front and the rest of the elements from the front shift backwards.
    In this approach, we firstly reverse all the elements of the array. Then, reversing the first k elements followed by
    reversing the rest n-kn−k elements gives us the required result.
    Let n=7n=7 and k=3k=3.
    Original List                   : 1 2 3 4 5 6 7
    After reversing all numbers     : 7 6 5 4 3 2 1
    After reversing first k numbers : 5 6 7 4 3 2 1
    After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
    * @return rotated array
    *
    * Complexity Analysis
    * Time complexity : O(n). n elements are reversed a total of n(max) times.
    * Space complexity : O(1). No extra space is used.
    */
  def rotateRight(position: Int):Array[Any] = {
    if (position < nums.length-1) {
      reverse(0, nums.length - 1)
      reverse(0, position - 1)
      reverse(position, nums.length-1)
    }
    return nums
  }

  /*def containDuplicates():Boolean = {
    val res = false
    //nums.sorted
    var i = 0
    var j = 1
    while(j < nums.length{
      if (nums(i) == nums(j)) return true
      else i+=1

      j += 1
    }
    res
  }*/
}
