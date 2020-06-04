package constructores;

public class HijoDelCaso2 extends Caso2 {
    public HijoDelCaso2(){
        //super(); linea por defecto no sirve, el padreo no tiene constructor sin arg
        super(1);
    }

    public static void main(String[] args) {
        new HijoDelCaso2();
        new Caso2(2);
    }
}
