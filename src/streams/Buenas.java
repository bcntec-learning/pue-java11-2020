package streams;

import java.util.stream.Stream;

public class Buenas {

    public static void main(String[] args) {
        Stream.iterate(0, a -> a + 1).forEach(c -> {
            System.out.println(c);
        });

        Stream<MiObjeto> stream = Stream.iterate(0, a -> a + 1).map(Buenas::convertir)
                .peek(Buenas::peek).filter(Buenas::filtroDeModulo);

        if ("ON".equalsIgnoreCase(System.getProperty("DEBUG"))) {
            stream = stream.peek(System.out::println);
        }

        stream.forEach(Buenas::forEachElent);


    }


    //es mas testeable
    private static MiObjeto convertir(Integer r) {
        MiObjeto l = new MiObjeto(r);
        l.setPotencia(r * r);
        //.....
        //.....
        //.....
        //.....
        //.....
        //.....
        //.....
        //.....
        //.....
        //.....
        //.....
        //.....
        return l;
    }

    private static void peek(MiObjeto y) {
        //llamadas a mi api de trazabilidad
        //llamadas a mi api de trazabilidad
        //llamadas a mi api de trazabilidad
        //llamadas a mi api de trazabilidad
        //llamadas a mi api de trazabilidad
        //llamadas a mi api de trazabilidad
    }


    private static void forEachElent(MiObjeto o) {
        System.out.println(o.getDato());
    }

    private static boolean filtroDeModulo(MiObjeto o) {
        return o.getPotencia() % 4 != 0;
    }


    static class MiObjeto {
        Integer dato;
        Integer potencia;

        public MiObjeto(Integer dato) {
            this.dato = dato;
        }

        public Integer getDato() {
            return dato;
        }

        public void setDato(Integer dato) {
            this.dato = dato;
        }

        public Integer getPotencia() {
            return potencia;
        }

        public void setPotencia(Integer potencia) {
            this.potencia = potencia;
        }
    }


}
