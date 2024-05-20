package sorting;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {3,5,1,6,4,2};
        int size = arr.length;

        System.out.print("Before sorting:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();


        mergeSort(arr, 0, size-1);


        System.out.print("After sorting:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        
    }

    private static int count1 = 0;
    private static int count2 = 0;
    private static void mergeSort(int[] arr, int left, int right){

        if(left < right) {
            int mid = (left+right)/2;
            
            System.out.print((++count1) + " Going to call 1Break-mergeSort:");
            print(arr, left, mid);
            System.out.println("|left:" + left + "|right:" + right + "|mid:" + mid);
            
            mergeSort(arr, left, mid);

            System.out.print((++count2) + " Going to call 2Break-mergeSort:");
            print(arr, mid+1, right);
            System.out.println("|left:" + left + "|right:" + right + "|mid:" + mid);

            mergeSort(arr, mid+1, right);

            System.out.print("Calling merge:");
            print(arr);
            System.out.println("|left:" + left + "|right:" + right + "|mid:" + mid);
            merge(arr, left, mid, right);
        }

    }

    private static void merge(int[] arr, int left, int mid, int right) {


        int n1 = mid - left+1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];


        for(int x=0; x<n1; x++){
            leftArr[x] = arr[left+x];
        }

        for(int x=0; x<n2; x++){
            rightArr[x] = arr[mid+1 + x];
        }
        System.out.print("Left-Array-Status:");
        print(leftArr);
        System.out.println("|n1:" + n1);
        System.out.print("Right-Array-Status:");
        print(rightArr);
        System.out.println("|n2:" + n2);

        int i = 0;
        int j = 0;
        int k = left;

        while(i<n1 && j<n2){
            if(leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = rightArr[j];
            j++;
            k++;
        }
        System.out.print("Updated-Sorted-Array:");
        print(arr);
        System.out.println();
    }

    private static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    private static void print(int[] arr, int start, int end){
        for(int i=start; i<end; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
}
