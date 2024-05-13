package sorting;
/**
 * TelInsertionSort
 */

public class InsertionSort {
    public static void main(String[] args) {


        int arr[] = {5,6,2,3,1};
        int size = arr.length;

        System.out.println("Before sorting");
        for (int i : arr) {
            System.out.print(i + " ");
        }


        for(int i=1; i<size-1; i++){
            int key = arr[i];
            int j = i-1;
            
            while(j>=0 && arr[j] > key){

                //if()

            }
        }




        System.out.println();
        System.out.println("After sorting");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        


    }
}