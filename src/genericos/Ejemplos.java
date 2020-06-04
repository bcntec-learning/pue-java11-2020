package genericos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejemplos {


    {
        //1.4 -> 5 Generics
        List li4 = new ArrayList(); //-> Objects
        li4.add(new Toy());
        li4.add("hola");
        li4.add(Integer.valueOf(5));
        li4.add(5); // en 1.4 esto no era valido

        for (int y = 0; y < li4.size(); y++) {
            Object o = li4.get(y);
            Toy t = (Toy) o; //posible class cast exception

        }
        //li4.iterator().next()

        //Generics
        List<Integer> li5 = new ArrayList<>();
        li5.add(5);
        li5.add(Integer.parseInt("1"));
        //li5.add("String"); no va a compilar

        li5.forEach(t->{
            System.out.println(t*t);
        });

        Toy<String> t1 = new Toy<>(); //java diamond wildcard
        Toy<Long> t2 = new Toy<>();
        String s1 = t1.getObjecto();
        Long s2 = t2.getObjecto();
        Stream<Long> longStream = Stream.of(1L,3L,4L,6L,7L,9L);
        Stream<Integer> integerStream = Stream.of(1,3,4,6,7,9);

        Toy2<Double, String> t21 = new Toy2<>(); //java diamond wildcard
        Toy2<Long, Date> t22 = new Toy2<>();
        Double s21 = t21.getObjecto();
        Long s22 = t22.getObjecto();

        Function<Date, String> function1 = (d)->d.toString();
        Function<Date, Long> function2 = (d)->d.getTime();

        Stream<Long> streamLongs = Stream.of(new Date(), new Date()).map(function2);
        List<Long> listLongs= streamLongs.collect(Collectors.toList());

        Stream<String> sToys = Stream.of(t1).map(t->t.getObjecto());


    }



}

class Toy<T> { //objeto generico
    T objecto;
    T getObjecto(){
        return objecto;
    }
}
class Toy2<T extends Number, F> extends Toy<T> { //objeto generico tipo Number
    F paridad;
    F get(){
        return paridad;
    };
  T suma(T s){
      //getObjecto()+s;
      return null;
  }
}