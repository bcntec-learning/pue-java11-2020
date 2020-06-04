package paquete2;

public interface SayHello {

    String getName();

    default void sayHello(){
        System.out.println("hello "+getName());
    }
}
