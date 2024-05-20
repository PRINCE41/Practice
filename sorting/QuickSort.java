package sorting;


public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {5,6,2,3,1,8,4};
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
            int pi = partition(arr, low, high); 


            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1;
        for(int j=low; j<high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                System.out.print("After inner swap: i:" + i + "|arr:");
                for(int k=0; k<arr.length; k++){
                    System.out.print(arr[k] + " ");
                }
                System.out.println("|j:" + j + "|pivot:" + pivot + "|low:" + low + "|high:" + high);
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        System.out.print("After outer swap: i:" + i + "|arr:");
                for(int k=0; k<arr.length; k++){
                    System.out.print(arr[k] + " ");
                }
                System.out.println("|toRet:" + (i+1) + "|pivot:" + pivot + "|low:" + low + "|high:" + high);
        return i+1;
    
    }
}
