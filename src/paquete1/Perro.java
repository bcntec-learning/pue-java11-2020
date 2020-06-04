package paquete1;

public class Perro extends Mamifero implements Domestico, Vacunable{
    @Override
    public void subirALaCama() {
        System.out.println("arriba "+getNombre());
    }
}
