package ejecicios;

public interface MiInterace {
    public static final int y = 0;
}

class A implements MiInterace {
    static final public int y = 0;

    static {
        int y = A.y + MiInterace.y;
    }
    //private int y=0;

    public  void add(){}
//    public static void add(){}


}
