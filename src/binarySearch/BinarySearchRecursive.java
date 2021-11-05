package binarySearch;

public class BinarySearchRecursive {

    public int binarySearch(int[] array, int left, int right, int target) {
        int mid = left + (right-left) / 2;

        if(right < left) {
            return -1;
        }

        if(target < array[mid]) {
            return binarySearch(array, left, mid - 1, target);
        }

        if(target > array[mid]) {
            return binarySearch(array, mid + 1, right, target);
        }

        if(target == array[mid]) {
            return mid;
        }

        return -1; //not found
    }
}
