package refernce;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ReferenceMethods {
    int i;

    public ReferenceMethods(int i) {
        this.i=i;

    }

    public static void main(String[] args) {
        ReferenceMethods obj1 = new ReferenceMethods(67);
        ReferenceMethods obj2 = new ReferenceMethods(31);

        Comparator<Integer> case1= new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1%o2;
            }
        };
        Comparator<Integer> case2= (o1, o2) -> o1/o2; //construye lambdas

        Comparator<Integer> case3 = ReferenceMethods::resta; //static method reference
        Comparator<Integer> case4 = obj1::suma; //object method reference
        Comparator<Integer> case5 = obj2::suma; //object method reference

        Supplier<Circle> dameNumeros = Circle::new; //constructor reference

        List<Circle> list = new ArrayList<>();

        for (int i = 0; i < 30000000; i++) {
            Circle z = dameNumeros.get();
            list.add(z);
            //System.out.println(z);
        }

        Predicate<Circle> mayor77 = (c)->c.r>77;
        Predicate<Circle> mayor78 = (c)->c.r>78;
        Predicate<Circle> mayor79 = (c)->c.r>79;

        Long t= System.currentTimeMillis();
        List<Circle> mayor5 = list.stream().filter(c -> c.r>5).collect(Collectors.toList());
        System.out.println(mayor5.size()+">5");

        List<Circle> mayorObj1 = list.stream().filter(obj1::mayor).collect(Collectors.toList());
        System.out.println(mayorObj1.size()+">"+obj1.i);

        List<Circle> mayorObj2 = list.stream().filter(obj2::mayor).collect(Collectors.toList());
        System.out.println(mayorObj2.size()+">"+obj2.i);
        System.out.println(System.currentTimeMillis()-t);

    }

    boolean mayor(Circle o ){
        return o.r>i;
    }

    static class Circle {
        int x;
        int y;
        int r;

        public Circle() {
            Random random = new Random();
            this.x= random.nextInt(100);
            this.y= random.nextInt(100);
            this.r= random.nextInt(100);
        }


        @Override
        public String toString() {
            return "[" +
                    "x=" + x +
                    ", y=" + y +
                    ", r=" + r +
                    ']';
        }
    }

    private int suma(Integer a, Integer b) {
        return i+a+b;
    }

    private static int resta(Integer a, Integer b) {
        return a-b;
    }

}
