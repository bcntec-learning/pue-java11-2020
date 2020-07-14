package ejecicios;

public class SinConstructor {
    /* esto es redundante, lo coloca el compilador
    public SinConstructor() {
        super();
    }
    */

    public SinConstructor() {
        //super(); redundante
        System.out.println("hola");
    }
    public SinConstructor(int a) {
        this();
        System.out.println("hola");
    }
    {
        int[][] iaa=new int[3][];
        iaa[0] = new int[77];
        iaa[1] = new int[66];
        int t  = iaa[1].length;

        char [][] c=new char[3][];
        c[0] = new char[77];
        c[1] = new char[66];
        int c2  = c[1].length;


        char z [] =new char[0];
        char z1 [][][] =new char[1][3][];
        char  [][][] z2 =new char[1][][];

        boolean a=false;
        boolean b=true;
        if(a=b){
            System.out.println("siiiiii");
        }

    }

    /*
    static Logger log1 = Logger.get(SinConstructor.class);
    static Logger log;
   static  {  //
       log = Logger.get(SinConstructor.class);
       if(){

       }
       //llamar a base de datos
    }
     {

    }

     */
}
