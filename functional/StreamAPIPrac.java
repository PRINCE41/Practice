package functional;

import java.util.*;
import java.util.Map.Entry;
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

        // 4- Group The Student By Department Names
        // groupByDeptName(list);

        // 5- Find the total count of student using stream
        // totalNoOfStu(list);

        // 6- Find the max age of student
        // maxAgeOfStu(list);

        // 7- Find all departments names
        // findAllDeptNames(list);

        // 8- Find the count of student in each department
        // countAllStuInDepts(list);

        // 9- Find the list of students whose age is less than 30
        // countStuWithUpperBound(list, 30);

        // 10- Find the list of students whose rank is in between 50 and 100
        // countStuWithLimit(list, 50, 100);

        // 11- Find the average age of male and female students
        // avgAge(list);

        // 12- Find the department who is having maximum number of students
        // deptNameByMaxStuCounts(list);

        // 13- Find the Students who stays in Delhi and sort them by their names
        // stuNameByLoc(list, "Delhi");

        // 14- Find the average rank in all departments
        // avgRanksByDeptNames(list);

        // 15- Find the highest rank in each department
        // highestRanksByDeptNames(list);


    }

    private static void highestRanksByDeptNames(List<Student> list){
        Map<String, Optional<Student>> deptName = list.stream()
            .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.minBy(Comparator.comparing(Student::getRank))));
        System.out.println("Highest rank by dept names:");
        deptName.forEach((k,v) -> {
            System.out.println(k + ":" + v.get().getRank());
        });
    }

    private static void avgRanksByDeptNames(List<Student> list){
        Map<String, Double> deptName = list.stream()
            .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));
        System.out.println("Avg rank by dept names:");
        deptName.forEach((k,v) -> {
            System.out.println(k + ":" + v);
        });
    }

    private static void stuNameByLoc(List<Student> list, String loc){
        List<Student> students = list.stream()
            .filter(x -> x.getCity().equalsIgnoreCase(loc))
            .sorted(Comparator.comparing(Student::getFirstName))
            .collect(Collectors.toList());
        System.out.println("Students lives in " + loc + ":");
        students.forEach(x -> System.out.println(x));
    }

    private static void deptNameByMaxStuCounts(List<Student> list){
        Entry<String, Long> deptName = list.stream()
            .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
            .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("Dept name having max students:" + deptName.getKey() + " with count:" + deptName.getValue());
        
    }

    private static void avgAge(List<Student> list){
        Map<String, Double> age = list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println("Avg age of male & female students:");
        age.forEach((k,v) -> System.out.println(k + ":" + v));
    }

    private static void countStuWithLimit(List<Student> list, int low, int high){
        List<Student> stuCounts = list.stream().filter(rank -> rank.getRank() > low && rank.getRank() < high).collect(Collectors.toList());
        System.out.println("All students having age from " + low + " to " + high + ":");
        stuCounts.forEach((stu) -> System.out.println(stu.toString()));
    }

    private static void countStuWithUpperBound(List<Student> list, int limit){
        List<Student> stuCounts = list.stream().filter(age -> age.getAge() < 30).collect(Collectors.toList());
        System.out.println("All students having age less than " + limit + ":");
        stuCounts.forEach((stu) -> System.out.println(stu.toString()));
    }

    private static void countAllStuInDepts(List<Student> list){
        Map<String, Long> stuCounts = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
        System.out.println("All students counts grouped by dept names:");
        stuCounts.forEach((k,v) -> {
            System.out.println(k + ":" + v);
        });
    }

    private static void findAllDeptNames(List<Student> list){
        List<String> allDeptNames = list.stream().map(x -> x.getDepartmantName()).distinct().collect(Collectors.toList());
        System.out.println("All dept names:");
        allDeptNames.forEach(names -> System.out.println(names));
    }

     private static void maxAgeOfStu(List<Student> list){
        OptionalInt maxAge = list.stream().mapToInt(dt -> dt.getAge()).max();
        System.out.println("Max age of Students:" + maxAge.getAsInt());

     }

     private static void totalNoOfStu(List<Student> list){
        long totalStu = list.stream().count();
        System.out.println("Total no of students:" + totalStu);

     }

     private static void groupByDeptName(List<Student> list){
        Map<String, List<Student>> records = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
        System.out.println("Students grouped by dept-Names:");
        records.forEach((k,v) -> {
           System.out.println(k + ":" + v);
        });
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
