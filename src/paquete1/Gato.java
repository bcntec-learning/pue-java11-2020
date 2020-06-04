package paquete1;

public class Gato extends Mamifero implements Domestico{

    public void maujar(){

    }
    public static void main(String[] args) {
        Object a = new Gato(); //upcasting y polimorfismo "a asume la fomra de gato" Obj1
        //a.maujar(); //no puede porq a asume el objeto Gato pero no su capacidades
        validando(a);
        validando("hola mundo");
        validando(1L);
        validando(new Object());
        validando(new Perro());


    }

    public static void validando(Object a){
        if(a instanceof Mamifero){
            System.out.println("'a' es mamifero");
            Mamifero b = (Mamifero) a; // debido al instanof estoy seguro
            System.out.println(b.getEdad());

            // class cast exception cuando es mamifero y gato
            Gato c = (Gato) b; //no estoy seguro q esto sea un gato (salvo pq esta arriba)
            System.out.println(c.getEdad());
            c.maujar();
        } else{
            System.out.println("'a' no es mamifero"+a);
        }
    }

    @Override
    public void subirALaCama() {
        System.out.println("subir "+getNombre());
    }

}
