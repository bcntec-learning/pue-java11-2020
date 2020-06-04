package constructores;

import java.sql.DriverManager;

public class Estatico1 {
    static final Long K = 1L;
    static final Long K2;
    static  Long V = 1L;
    Long O = 1L;
    final Long O2;

    static {
        //DriverManager.registerDriver();
        //Class.forName("orcle.Driver");
        System.out.println("static" + K.toString()+"/"+V.toString());
        //K=K+1;
        K2=System.currentTimeMillis();
        V=V+1;
        //K2=55L; K2 ya fue inicializada y es final
    }

    {
        System.out.println("no static "+K+"/"+V+"/"+O);
        V=V+1;
        //O2=O2+1; O2 no esta inicializada un

    }

    public static void main(String[] args) {
        new Estatico1();
        new Estatico1();
    }
    {
        O2=77L;
        //O2=77L; ya esta inicializada
    }
}
