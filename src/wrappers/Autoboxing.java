package wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Autoboxing {
    char c = 7;
    double d = 7d;
    float f = 7f;
    int i = 7;
    long l = 7l;
    boolean b = true;

    Character c1 = c;
    Double d1 = d;
    Float f1 = f;
    Integer i1 = 1;
    Long l1 = l;
    Boolean b1 = b;

    Holder<Character> ch1 = new Holder<>(c);
    Holder<Character> ch2 = new Holder<>(c1);
    Holder<Double> dh2 = new Holder<>(d1);

    {
        List<Integer> coll = new ArrayList<>();
        //vs Arrays
        //Collection<int> collectionInt = new ArrayList<>(); no compila
        int u = 5;
        coll.add(u); //primitivo se transofrma a su par objeto wrapper o envoltrio
        coll.add(new Integer(u)); //pierde sentido pq el lenguaje lo hace por nostros

        int unboxing = coll.get(0);
        Integer sinUnboxing = coll.get(0);

        Object o = new Object();
        o.toString(); //nos permite concatenar String
        o.hashCode(); //identificar el objeto como unico
        o.equals(o); // comparar con otro objeto sin importar el tipo

        //unboxing.equals(sinUnboxing);
        //unboxing=null;
        sinUnboxing.equals(unboxing);
        sinUnboxing = null;


        BiFunction<Integer, Integer, Long> sumar = (a, b) -> {
            a.equals(b);

            return (long) (a + b);
        };
        Long ret = sumar.apply(unboxing, sinUnboxing);
    }

}

class Holder<T>{
    T n;

    public Holder(T n) {
        this.n = n;
    }
    T getN(){
        return n;
    }
}
