package visibilidad;

public class EjemplosVisiblidad {

    public Integer publico;
    Integer porDefecto;
    private Integer privada;
    protected Integer protegida;


    {
        //private Integer privada; no es viable
    }

    public void metodo(){
        Integer privada;  //shadow es visle solo dentro del metodo (dentro delas llaves)

    }


    public static void main(String[] args) {
        Integer t = new EjemplosVisiblidad().privada;
    }


}
class OtraClase {

    public static void main(String[] args) {
        //no Integer t = new EjemplosVisiblidad().privada;
        Integer t0 = new EjemplosVisiblidad().publico;
        Integer t1 = new EjemplosVisiblidad().porDefecto;
        Integer t2 = new EjemplosVisiblidad().protegida;
    }

}