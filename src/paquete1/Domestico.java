package paquete1;

public interface Domestico {

    default void subirALaCama(){
        System.out.println("subir");
    }

}
