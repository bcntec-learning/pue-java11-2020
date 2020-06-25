package exam1;

import java.util.Arrays;
import java.util.Comparator;

public class Person36  implements Comparator<Person36> /* Comparable<Person36>*/ {



     public int compare(Person36 p1, Person36 p2) { return p1.name.compareTo(p2.name); }
//
//    @Override
//    public int compareTo(Person36 o) {
//        return 0;
//    }
    private String name;

    public Person36(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Person36[] t = new Person36[]{
                new Person36("Joe"),
                new Person36("Jane"),
                new Person36("John")
        };
        Arrays.sort(t);

    }

}
