package pantalla;

public class MiPantalla {
    Pantalla miPantalla;
    Boton salir;
    Boton calcular;
    Boton congelar;
    Boton resetar ;

    public MiPantalla() {

         miPantalla = new Pantalla();
         salir = new Boton(miPantalla, "salir"){

             @Override
             public void accion() {
                 System.exit(0);
             }
         };

         calcular = new Boton(miPantalla, "calcular"){
             @Override
             public void accion() {
                //calculo
                 Math.sin(12342d);
             }};
         congelar = new Boton(miPantalla, "congelar"){
             @Override
             public void accion() {
             }};
         resetar = new Boton(miPantalla, "salir"){ //inner anonymous class que extiende de Boton
             @Override
             public void accion() {
                 miPantalla.salir();
             }};


        miPantalla.add(salir);
        miPantalla.add(calcular);
        miPantalla.add(congelar);
        miPantalla.add(resetar);

        miPantalla.cambiaFondo(new Imagen() {//inner anonymous class que implementa de Imagen
            private String url="mi-imagen.jpg";
            @Override
            public String url() {
                return url;
            }
        });
        miPantalla.alSalir(new Comando() {

            @Override
            public void ejecutar() {
                System.out.println("adios");
            }
        });
        miPantalla.alSalir(new MiPantallaAlSalir());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hola");
            }
        }).start();

    }

    class MiPantallaAlSalir implements Comando{

            @Override
            public void ejecutar() {
                System.out.println("adios");
            }
        }

    public static void main(String[] args) {
        new MiPantalla();
    }


}
