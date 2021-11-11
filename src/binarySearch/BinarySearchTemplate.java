package binarySearch;
/**
 * Generalized Binary Search Template
 */
public class BinarySearchTemplate {
    /*
    * Suppose we have a search space.. an array, range etc. Usually it's sorted in ascending order.
    * For most tasks we can transform the requirement into the following generalized form:
    * */

    /**
     *  def binarySearch(array) --> int:
     *    def condition(value) --> boolean:
     *
     *        left = min(search_space)
     *        right = max(search_space)
     *
     *        while (left < right)
     *            mid = left + (right - left) / 2
     *
     *            if( condition( mid ))
     *                right = mid
     *            else
     *                left = mid + 1
     *
     *        return left
     */

    /*
    * The best part of this template is that for most binary search problems, we only need to modify 3 parts after
    * copy-pasting this template and never need to worry about edge cases and bugs in code
    *
    * 1. Correctly initialize the boundary variables left and right to specify the search space (include all possible elements)
    * 2. Decide return value. return left?   return left-1?   (after exiting the while loop, left is the minimal k satisfying the condition function)
    * 3. Design the condition function. The most difficult part...
    *
     */
}
