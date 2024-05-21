package functional;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPIPrac {

    public static void main(String[] args) {
        List<Student> list = setDet();

        // 1- Find list of students whose first name starts with alphabet A
        // findByChar(list);

        // 2- Find the student who has second rank
        // secondHighest(list);

        // 3- Students sorted by ranks
        // sortedByRank(list);





     }

     private static void secondHighest(List<Student> list){
        Student record = list.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();
        System.out.println("Student who has second rank:" + record);
     }

     private static void sortedByRank(List<Student> list){
        List<Student> record = list.stream().sorted(Comparator.comparing(Student::getRank)).collect(Collectors.toList());
        System.out.println("Student who has second rank:");
        record.forEach(x -> {
            System.out.println(x);
        });
     }


     private static void findByChar(List<Student> list){
        List<Student> record = list.stream().filter(x -> x.getFirstName().startsWith("A")).collect(Collectors.toList());
        System.out.println("Students whose first name starts with alphabet A:");
        record.forEach(x -> {
            System.out.println(x);
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
