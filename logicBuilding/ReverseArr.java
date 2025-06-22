package logicBuilding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseArr {

    public static void main(String[] args) {
         String []arr = new String[5];
        arr[0] = "pawan";
        arr[1] = "prasoon";
        arr[2] = "mishra";
        arr[3] = "---+";
        arr[4] = "-++-";
        for(int i=0; i<arr.length; i++){
            char []reversed = reverse(arr[i].toCharArray());
            System.out.println(reversed);
        }
    }

    private static char[] reverse(char []charArr) {
        return new String(charArr).chars()
            .mapToObj(c -> (char)c)
            .filter(c -> c == 'a')
            .collect(StringBuilder::new,
             StringBuilder::append,
             StringBuilder::append)
            .toString()
            .toCharArray();
    }
    
}
