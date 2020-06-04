package paquete2;

/**
 * @see NoAbstracto
 */
public class DemoAbstracto {

    public static void main(String[] args) {
        /*
        new Abstracto1();
         */
        NoAbstracto a = new NoAbstracto();
        a.setName("A");
        //a.setStreet()
        NoAbstracto2 a2 = new NoAbstracto2();
        a2.setName("A2");
        a2.setStreet("S2");


        if(a instanceof Abstracto1){
            System.out.println("si");
        }
        if(a2 instanceof Abstracto1){
            System.out.println("si");
        }
    }
}
