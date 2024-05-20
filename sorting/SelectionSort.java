package sorting;

// ATC:O(n^2)
public class SelectionSort {

    public static void main(String[] args) {

        int[] nums = {6,5,2,8,9,4};
        int size = nums.length;
        int temp = 0;
        int minIndex = -1;


        System.out.println("before sorting...");
        for (int i : nums) {
            System.out.print(i + " ");
        }


        // core-logic:Start
        for(int i=0; i<size-1; i++){

            minIndex = i;

            for(int j=i+1; j<size; j++){
                if(nums[minIndex] > nums[j]){
                    minIndex = j;
                }
            }

            temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;

            System.out.println();
            for (int k : nums) {
                System.out.print(k + " ");
            }
        }
        // core-logic:End



        System.out.println("\nafter sorting...");
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
    
}
