package informes;

import java.util.Date;

public class Informes {
    public static void main(String[] args) {
        double t[] = new double[]{12,122,131};
        Date fecha = new Date();
        new InformeGerencia(fecha, t).renderizar();
        new InformeMarketing(fecha, t).renderizar();
    }
}
