package binarySearch;

/**
 * Searching algorithm that searches through a SORTED array
 * continuously divides the array in half until the target is found
 *
 * A = array, t = target
 *
 * compare t with middle element
 * if t matches with middle element, return middle index (return type depends on question)
 * else if t > middle element, cut A in half and search right half
 * else if t < middle element, cut A in half and search left half
 * return -1 if not found
 * **/

//git test

public class BinarySearchIterative {

    public int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length-1;

        while(left <= right ) {
            int mid = left + (right-left) / 2;
            if(target == array[mid]) {
                return mid;
            } else if(target < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1; // not found
    }
}
