package pantalla;

public abstract class Boton {
    private Pantalla pantalla;
    private String color;
    private boolean activo;
    private String texto;

    public Boton(Pantalla pantalla, String texto) {
        this.pantalla = pantalla;
        this.texto = texto;
    }

    public Pantalla getPantalla() {
        return pantalla;
    }

    void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public abstract void accion();
}
