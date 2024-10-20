package sorting;

// ATC:O(n^2)
public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {6,5,2,8,9,4};
        int size = arr.length;

        System.out.println("Before sorting");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        int count = 0;
        int count2 = 0;

        // for(int i=0; i<size; i++){
        //     boolean bool = false;
        // smallest one goes first after this completes: one more itr found compared with sec approach
        //     for(int j=i+1; j<size; j++){
        //         if(arr[i] > arr[j]){
        //             int temp = arr[i];
        //             arr[i] = arr[j];
        //             arr[j] = temp;
        //             bool = true;
        //         }
        //         count ++;
        //     }
        //     count2++;
        //     if(!bool) break;
        // }

        for(int i=0; i<size; i++){
            boolean bool = false;
            // largest one goes last after this completes
            for(int j=0; j<size-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    bool = true;
                } 
                count++;
            }
            count2++;
            if(!bool) break;
        }



        System.out.println("After sorting with count:" + count2);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        


    }
}