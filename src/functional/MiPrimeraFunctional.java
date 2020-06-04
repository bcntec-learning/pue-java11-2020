package functional;

@FunctionalInterface
public interface MiPrimeraFunctional {


    //keywords redundantes public abstract void sayHello(String hello);
    void sayHello(String hello);

    default String uppercase(String hello){
        return hello.toUpperCase();
    }
}
