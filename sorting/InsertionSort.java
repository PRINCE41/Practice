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
        System.out.println();


        for(int i=1; i<size; i++){
            int key = arr[i];
            int j = i-1;
            System.out.println(key + ":" + j);
            
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                System.out.println("Inside while:" + arr[j+1] + ":" + j);
                j--;
            }
            arr[j+1] = key;
            System.out.println("_______________________________________________");
        }



        System.out.println("After sorting");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        


    }
}