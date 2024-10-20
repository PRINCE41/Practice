package search;

public class LinearNBinarySearch {

    public static void main(String[] args) {
        
        int nums[] = {5, 7, 9, 11, 13};
        int target = 11;

        // Linear Search
        int linearResult = linearSearch(nums, target);
        if (linearResult != -1) {
            System.out.println("Linear Search: Target found at index " + linearResult);
        } else {
            System.out.println("Linear Search: Target not found");
        }

        // Binary Search
        int binaryResult = binarySearch(nums, target);
        if (binaryResult != -1) {
            System.out.println("Binary Search: Target found at index " + binaryResult);
        } else {
            System.out.println("Binary Search: Target not found");
        }
    }

    // Linear Search Implementation
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Target not found
    }

    // Binary Search Implementation (Assumes the array is sorted)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is at mid
            if (arr[mid] == target) {
                return mid;
            }
            // If target is greater, ignore the left half
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }
}
