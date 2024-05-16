package sorting;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {5,6,2,3,1};
        int size = arr.length;

        System.out.println("Before sorting");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        quickSort(arr, 0, size-1);

        System.out.println("After sorting");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        


    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            
        }
    }
    
}
