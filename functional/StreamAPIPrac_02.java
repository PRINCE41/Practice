package functional;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.function.Function;

public class StreamAPIPrac_02 {

    public static void main(String[] args) {
        List<Student> list = setDet();

        String str = "12 32 49 87";

        // 1- Find occurrences of each single-digit given as string of nos separated by space
        // findOccurrences(str);

        // 1- Find highest occurred single-digit from given string of nos separated by space
        findHighestOccurredDigit(str);

    }

    private static void findHighestOccurredDigit(String str){
        Entry<Character, Long> mapEntry = str
            .chars()
            .mapToObj(c -> (char) c)
            .filter(c -> !Character.isWhitespace(c))
            .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .get();

        System.out.println(mapEntry.getKey() + ":" + mapEntry.getValue());
    }

    private static void findOccurrences(String str){
        Map<Character, Long> map = str
            .chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
            
        map.forEach((k,v) -> {
            System.out.println(k + ":" + v);
        });
    }

    private static List<Student> setDet(){
        List<Student> list = Arrays.asList(
        new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
        new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
        new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
        new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
        new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
        new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
        new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
        new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
        new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
        new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));
        return list;
    }
    
}
