package informes;

import java.util.Date;

public class InformeMarketing extends InformeAbstracto {
    private double media;

    public InformeMarketing(Date fecha, double[] serie) {
        super(fecha,"Informe Marketing",serie);
    }

    @Override
    public void calcular() {
        double total =0;
        for (double valor:getSerie() ) {
            total = total+valor;
        }
        media = total /getSerie().length;
    }

    @Override
    public void renderizar() {
        System.out.println("******"+media+"***");
    }
}
