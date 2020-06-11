package streams;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class PrimerStream {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("123456", "Juan Lopez"),
                new Student("783444", "Ramiro Solanas"),
                new Student("826648", "Eduardo Gomez"));
        List<Course> courses = Arrays.asList(
                new Course("M", "Matematicas"),
                new Course("L", "Literatura"),
                new Course("F", "Fisica"));

        List<Inscription> inscriptions = Arrays.asList(
                new Inscription(2020L, "M", "123456", 7.5),
                new Inscription(2020L, "M", "783444", 4.5),
                new Inscription(2020L, "L", "123456", 7.1),
                new Inscription(2020L, "L", "826648", 9.5),
                new Inscription(2020L, "F", "123456", 7d),
                new Inscription(2020L, "F", "783444", 5.2),
                new Inscription(2021L, "F", "783444", 8.5),
                new Inscription(2020L, "F", "826648", 3.5));


        //students.get(0).getName().equals("Eduardo");  //null pointer
        //"Eduardo".equals(students.get(0).getName());  //null pointer zafe
        students.stream().filter(r -> r.getName().startsWith("Eduardo"))
                .map(Student::getName)
                .forEach(System.err::println);

        students.stream().filter(new Predicate<>() {
            @Override
            public boolean test(Student student) {
                return false;
            }
        })
                .map(Student::getName)
                .forEach(System.err::println);


        Map<String, Course> mapCourse_ = courses.stream().collect(toMap(Course::getId, c -> c));
        Map<String, Course> mapCourse = courses.stream().collect(toMap(Course::getId, Function.identity()));
        Map<String, String> mapCourseString = courses.stream().collect(toMap(Course::getId, Course::getName));
        Map<String, Student> mapStudents = students.stream().collect(toMap(Student::getId, Function.identity()));
        Map<String, String> mapStudentsString = students.stream().collect(toMap(Student::getId, Student::getName));


        Map<String, List<Inscription>> enJava = new HashMap<>();
        inscriptions.forEach(i -> {
            if (i.getYear() == 2020L) {
                List<Inscription> l = enJava.get(i.getCourse());
                if (l == null) {
                    l = new ArrayList<>();
                    enJava.put(i.getCourse(), l);
                }
                l.add(i);
            }
        });


        Map<String, List<Inscription>> inscriptionsByYear2020GroupingByCourse = inscriptions.stream()
                .filter(i -> i.getYear() == 2020).collect(groupingBy(Inscription::getCourse));


        DoubleSummaryStatistics summarized = inscriptions.stream()
                .filter(i -> i.getYear() == 2020).mapToDouble(Inscription::getCalification).summaryStatistics();



        for (Map.Entry<String, List<Inscription>> s : inscriptionsByYear2020GroupingByCourse.entrySet()) {
            System.out.println("Course " + mapCourseString.get(s.getKey())+" "
                    +s.getValue().parallelStream().mapToDouble(Inscription::getCalification).average());
            s.getValue().forEach(i -> System.out.println("     " + mapStudentsString.get(i.getStudent())+" "+i.getCalification()));
        }

        System.out.println(summarized);

        Optional<Student> optionalStudent1 = students.stream().findFirst();
        Optional<Student> optionalStudent11 = students.stream().findAny();

        Optional<Student> optionalStudent2 = new ArrayList<Student>().stream().findFirst();

        if(optionalStudent1.isPresent()){
            System.out.println(optionalStudent1.get());
        }
        optionalStudent1.ifPresent(System.out::println);





    }
}
