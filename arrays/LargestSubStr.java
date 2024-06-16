package arrays;

public class LargestSubStr {

    public static void main(String[] args) {
        String s = "abgggggcbbbbbcvvb";
        //int[] arr = largeSubStr(s.toCharArray());
        // int[] arr = largePalinSubStr(s.toCharArray());



        // System.out.println("starting index:" + arr[0] + " length:" + arr[1]);
        // System.out.println("Largest Sub-Str:" + s.substring(arr[0], arr[0] + arr[1]));

        System.out.println(largePalinSubStr(s));


    }

    // return array containing index of largest palindromic sub str and its length
    private static String largePalinSubStr(String str) {

        if(str.length() == 1 ||str.length() == 2 ) return str; 

        int maxLength = 2;
        int maxStart = 0;

        int currentEnd = 0;

        String lastSub = str.substring(0, 2);

        for (int j = 2; j < str.length() - 2; j++) {
            for (int i = j; i < str.length(); i++) {
                lastSub = lastSub + str.charAt(i);
                if(chkPalindrome(lastSub)){
                    if(lastSub.length() > maxLength) {
                        maxLength = lastSub.length();
                        currentEnd = i;
                    }
                } 
            }
            lastSub = "";
        }
        System.out.println(maxLength + ":" + currentEnd);

       
        maxStart = (currentEnd - maxLength) + 1;

        return str.substring(maxStart, maxStart + maxLength);
    }



    // return array containing index of largest palindromic sub str and its length
    private static int[] largePalinSubStr(char[] charArray) {

        if(charArray.length == 1) return new int[]{0,1};
        else if(charArray.length == 2) return new int[]{0,2};

        int maxLength = 2;
        int maxStart = 0;

        int currentEnd = 0;

        StringBuilder lastSub = new StringBuilder();
        lastSub.append(charArray[0]).append(charArray[1]);

        for (int j = 2; j < charArray.length; j++) {
            for (int i = j; i < charArray.length; i++) {
                if(chkPalindrome(lastSub.append(charArray[i]).toString())){
                    if(lastSub.length() > maxLength) {
                        maxLength = lastSub.length();
                        currentEnd = i;
                    }
                } 
            }
            lastSub =  new StringBuilder("");
        }
        System.out.println(maxLength + ":" + currentEnd);

       
        maxStart = (currentEnd - maxLength) + 1;

        return new int[]{maxStart, maxLength};
    }


    private static boolean chkPalindrome(String str){
        return new StringBuilder(str).reverse().toString().equals(str);
    }

    // return array containing index of largest sub str and its length
    private static int[] largeSubStr(char[] charArray) {
        int maxLength = 1;
        int maxStart = 0;

        int currentEnd = 0;
        int currentLength = 1;

        char prev = charArray[0];;

        for (int i = 1; i < charArray.length; i++) {
            if(prev == charArray[i]){
                currentLength++;
            } else {
                prev = charArray[i];
                currentLength = 1;
            }
            if(currentLength > maxLength) {
                maxLength = currentLength;
                currentEnd = i;
            }
        }
        maxStart = (currentEnd - maxLength) + 1;
        return new int[]{maxStart, maxLength};
    }
    
}
