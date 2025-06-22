package logicBuilding;

// Alt
public class PalindromeChk2 {
    public static void main(String[] args) {
        /*
         * Input: "abba" → Output: true
         * Input: "abcd" → Output: false
         */
        String []arr = new String[5];
        arr[0] = "abba";
        arr[1] = "abbbba";
        arr[2] = "abbaabba";
        arr[3] = "---+";
        arr[4] = "-++-";
        for(int i=0; i<arr.length; i++){
            if (isPlaindrome(arr[i])) System.out.println("Success for " + arr[i]);
            else System.out.println("Failure for " + arr[i]);
        }
    }


    private static boolean isPlaindrome(String sample){
        boolean bool = false;
        StringBuilder str = new StringBuilder(sample);
        bool = (str.reverse().toString().equals(sample)) ? true : false;
        return bool;
    }
}
