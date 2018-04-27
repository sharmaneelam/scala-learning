package com.github.nsharma.scalalearning

case class ArrayUtility(nums: Array[Int]) {

  def apply(nums: Array[Int]) = removeDuplicates()
  /****************************************
    * Algorithm
     Since the array is already sorted, we can keep two pointers ii and jj, where ii is the slow-runner while jj is
     the fast-runner. As long as nums[i] = nums[j]nums[i]=nums[j], we increment jj to skip the duplicate.

     When we encounter nums[j] \neq nums[i]nums[j]≠nums[i], the duplicate run has ended so we must copy its value to
     nums[i + 1]nums[i+1]. ii is then incremented and we repeat the same process again until jj reaches the end of array.
    * @return count of distinct elements
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
}
