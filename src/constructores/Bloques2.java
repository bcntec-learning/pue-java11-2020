package constructores;

import java.util.Date;

public class Bloques2 extends Bloques1{

    {
        System.out.println("bloque de inicalizacion 2.0");
    }
    private Date unDate= new Date();
    private Date otroDate= otroDate("otroDate de Bloques2"); //inicializacion

    {
        System.out.println("bloque de inicalizacion 2.1");
    }

    public Bloques2(){ // construtor
        //super()
        System.out.println("en el constructor de Bloques2");
    }

    {
        System.out.println("bloque de inicalizacion 2.2");
    }

    private Date otroDate2= otroDate("otroDate2 de Bloques2"); //inicializacion

    public  Date otroDate(String s){
        System.out.println("bloque 2 dice:"+s);
        return new Date();
    }

    public static void main(String[] args) {
        new Bloques2();
        new Bloques2();
    }

}
