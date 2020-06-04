package constructores;

import java.util.Date;

public class Bloques1 {
    private Date unDate= new Date();
    private Date otroDate= otroDate("otroDate de Bloques1"); //inicializacion
    {
        System.out.println("bloque de inicalizacion 1.0");
    }
    public Bloques1(){ // construtor
        //super()
        System.out.println("en el constructor de Bloques1");
    }
    public Bloques1(int i){ // construtor
        //super()
        System.out.println("en el constructor(int) de Bloques1");
    }

    private Date otroDate2= otroDate("otroDate2 de Bloques1"); //inicializacion

    public Date otroDate(String s){
        System.out.println("bloque 1 dice:"+s);
        return new Date();
    }

    public static void main(String[] args) {
        new Bloques1();
    }

}
