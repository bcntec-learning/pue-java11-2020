package informes;

import java.util.Date;

public abstract class InformeAbstracto {

    private final Date fecha;
    private final String titulo;
    private final double[] serie;

    public InformeAbstracto(Date fecha, String titulo, double[] serie) {
        this.fecha = fecha;
        this.titulo = titulo;
        this.serie = serie;
        calcular();
    }

    public abstract void calcular();
    public abstract void renderizar();

    public Date getFecha() {
        return fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public double[] getSerie() {
        return serie;
    }

}
