package visibilidad.sub;

import visibilidad.EjemplosVisiblidad;

class SubClase  extends EjemplosVisiblidad {

    public static void main(String[] args) {
        //no Integer t = new EjemplosVisiblidad().privada;
        Integer t0 = new EjemplosVisiblidad().publico;
        //no se permite Integer t1 = new EjemplosVisiblidad().porDefecto;
        //no se permite Integer t2 = new EjemplosVisiblidad().protegida;  <<<<<<<<<<<<<<<
        Integer t3 = new SubClase().protegida;  //si la puedo ver
    }

}
