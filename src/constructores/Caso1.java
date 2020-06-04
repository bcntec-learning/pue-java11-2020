package constructores;

public class Caso1 { //extends Object
    /* por defecto
    public Caso1(){super();}
     */

    public void Caso1(){ //no es un constructor aunqu tenga el mismo nombre
        System.out.println("Metodo Caso1");
    }

    public Caso1(){ //es un constructor
        //super(); por defecto

        System.out.println("Constructor Caso1");
    }

    private Long dato;

}
