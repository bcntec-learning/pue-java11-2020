package functional;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FunctionalCounter {


    public static void main(String[] args) {
        Bizz an= new Bizz(){ //anonymous inner class
            long qty =0;
            @Override
            public void operate() {
                qty++;
                System.out.println("mi negocio "+qty);
            }

        };


        for (int i = 0; i < 100; i++) {
            an.operate();
        }

        //los parentesis del area de argumentos de la expresion son
        // obligatorios si la cantidad de argumento !=1
        //Bizz fu = ->{};  //no compila
        //Bizz fu = (i) ->{};  //lamda expression
        //Bizz fu = () ->{};  //lamda expression
        //Bizz fu2 = (i,j) ->{};  //lamda expression
        Bizz fu1 = ()-> System.out.println("mi negocio");
        Bizz fu11 = ()->  new Random().nextInt(100);
        Bizz fu12 = ()-> {System.out.println("mi negocio");};
        Bizz2 fu2 = ()-> new Random().nextInt(100);


        new Bizz2(){long qty=99;  public int operate() {return new Random().nextInt(100);}};
        Bizz2 fu3 = ()-> {return new Random().nextInt(100);};


        Long qty=0L; //debe ser final, la ref 'qty' no puede cambiar pq ademas es inmutable
        //Bizz migrate = ()-> System.out.println("mi negocio "+(qty++));
        /* pswudo codigo del 'qty++';
          qty = qty.longValue()+1

         */

        class MyLong {
            long val;
            public long val(){return val;};
            public long incr(){return val++;};
        }


        MyLong m = new MyLong(); //MyLong no garantiza la atomizidad o la gestion de la concurrencia
        Bizz migrate2 = ()-> System.out.println("mi negocio "+m.incr());
        //m = new MyLong(); si descomento, 'm' deja de ser final



        AtomicInteger a = new AtomicInteger(); //garantiza la atomizidad
        Bizz migrate3 = ()-> System.out.println("mi negocio "+a.incrementAndGet());
        //a= new AtomicInteger();

        //for (int i = 0; i < 100; i++)

        Stream.iterate(0, v->v+1).limit(100).forEach(y->migrate3.operate());
        Stream.of(1,2,3,4,5,6,7,8,9).limit(4).forEach(y->migrate3.operate());
        Arrays.stream(new int[]{1,2,3,4,5,6,7,8,9}).limit(4).forEach(y->migrate3.operate());

        Random random = new Random();
        Supplier<Long> supllier1 = ()->random.nextLong(); //lambda expression
        Supplier<Long> supllier2 = random::nextLong; //method reference


        Consumer<Long> sysout= System.out::println;

        for (int i = 0; i <100; i++) {
            sysout.accept(supllier2.get());
        }


        Stream.generate(supllier1).limit(1000).forEach(sysout);

        Function<Long,String> f = (v)-> String.format("[%d]", v);

        Consumer<String> sysout2= System.out::println;

        MyConsumer<String> sysout3= new MyConsumer<>() {
            int y;
            @Override
            public void accept(String s) {
                System.out.println(s);
                y++;
            }
            public void t(){};

        };

        Stream.generate(supllier1).limit(1000).map(f).forEach(sysout2);
        Stream.generate(supllier1).limit(1000).map(f).forEach(sysout3);
        Stream.generate(()->random.nextLong()).limit(1000).map((v)-> String.format("[%d]", v)).forEach((y)-> System.out.println(y));
        Stream.generate(random::nextLong).limit(1000).map((v)-> String.format("[%d]", v)).forEach( System.out::println);

    }

}

interface MyConsumer<T> extends Consumer<T>{
    void t();
};
interface Bizz {
    void operate();
}
interface Bizz2 {
    int operate();
}
