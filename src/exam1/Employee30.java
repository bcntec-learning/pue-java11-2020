package exam1;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employee30 {
    private String name;
    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        List<Employee30> roster = new ArrayList<>();
        Predicate<Employee30> y = e->e.getBirthday()
                .isBefore(IsoChronology.INSTANCE.date(1989, 1,1));

        Set<String> sa = roster.stream().collect(Collectors.partitioningBy(y)) //devuelvo un Map<Boolean, List<Employee30>>
                .get(true) //obtengo las lista que su key = true
                .stream()  // de la lista obtengo el stream
                .map(Employee30::getName) //transformo de Employee a String
                .collect(Collectors.toCollection(TreeSet::new));  //acumulo en foramte TreeSet<String>

        Map<Boolean, List<Employee30>> au = roster.stream().collect(Collectors.partitioningBy(y));  //collect en 2 lista dentro de un Map<Boolean,List<Emploee30>>
        ///au.get(true).stream().map()

        //Set<String> sb = roster.stream().collect(Collectors.partitioningBy(y)).get(true)  //devuelve un Map, collect son final
                    //.map(Employee30::getName).collect(Collectors.toCollection(TreeSet::new));

        //C
        Map<Boolean,Set<String>> sc = roster.stream().collect(
                Collectors.partitioningBy(y, Collectors.mapping(Employee30::getName, Collectors.toSet())));
        //D
        Map<Boolean,Set<String>> sD = roster.stream().collect(
                Collectors.partitioningBy(y, Collectors.mapping(Employee30::getName, Collectors.toCollection(TreeSet::new))));

        //Set<String> sc = roster.stream().collect(Collectors.partitioningBy(y, Collectors.mapping(Employee30::getName, Collectors.toSet())));

        //Francisco's way
        Set<String> sFP  = roster.stream().filter(y).map(Employee30::getName).collect(Collectors.toSet());

    }
}
