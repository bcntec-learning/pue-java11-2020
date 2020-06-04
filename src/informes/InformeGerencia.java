package informes;

import java.util.Date;

public class InformeGerencia extends InformeAbstracto {

    private double importe;

    public InformeGerencia(Date fecha, double[] serie) {
        super(fecha,"Informe Gerencia",serie);
    }

    @Override
    public void calcular(){

        for(double valor:getSerie()){ //for each  Arrays y coleciones
            importe+=valor;
        }

    }

    @Override
    public void renderizar(){
        System.out.println("******"+importe+"***");
    }

}
