package com.github.nsharma.scalalearning
import org.scalatest.{Matchers, WordSpec}

class ArrayUtilitySpec extends WordSpec with Matchers{

  "Array Utility" should {
    "handle empty Array" in {
      assert(ArrayUtility(new Array(0)).removeDuplicates() == 0)
    }
  }
}
