package arrays;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BeforeAfter {
    
    public static String[] determineOccurrences(int[] array) {
        int n = array.length;
        
        int[] seenEarlier = new int[n];
        int[] seenLater = new int[n];
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = i+1; j < n; j++) {
        //         if(array[i] == array[j]){
        //             seenEarlier[j] = 1;
        //             seenLater[i] = 1;
        //         }
        //     }
        // }

        IntStream.range(0, n)
            .forEach(i -> IntStream.range(i + 1, n)
            .filter(j -> array[i] == array[j])
            .forEach(j -> {
                seenEarlier[j] = 1;
                seenLater[i] = 1;
            }));

        String earlier = IntStream.of(seenEarlier).mapToObj(String::valueOf).collect(Collectors.joining());
        //earlier = Arrays.stream(seenEarlier).mapToObj(String::valueOf).collect(Collectors.joining());
        String later = IntStream.of(seenLater).mapToObj(String::valueOf).collect(Collectors.joining());;

        return new String[]{earlier.toString(), later.toString()};
    }
    
    public static void main(String[] args) {
        int[] array = {1, 2, 1, 3, 2, 1};
        String[] result = determineOccurrences(array);
        
        System.out.println("Earlier: " + result[0]);
        System.out.println("Later: " + result[1]);
    }

}
