package pantalla;

public class Pantalla {
    String fondo;
    Comando alSlir;
    public void add(Boton boton){
        boton.setPantalla(this);
    }

    public void cambiaFondo(Imagen image){
        fondo=image.url();
    }

    public void salir(){
        alSlir.ejecutar();

    }

    public void alSalir(Comando alSlir){
        this.alSlir=alSlir;
    }
}
