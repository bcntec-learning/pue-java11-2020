package usingVar;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class Var {
    //var uu = new String("uuuu"); error no compil solo locales

    {
        var integer = new Integer(77);
        var i =0;
        var d =0d;
        var f =0f;
        var l =0L;
        var l2 =new Long(88);

        Integer lf = i;
    }
    public static void main(String[] args) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(null);
        metodo(byteArrayInputStream);
        var byteArrayInputStream2 = new ByteArrayInputStream(null);
        metodo2(byteArrayInputStream2);

        //List<String> t = new ArrayList<String>();
        //ArrayList<String> t = new ArrayList<String>();
        var t = new ArrayList<String>();
    }

    private static void metodo(InputStream byteArrayInputStream) {


    }
    private static void metodo2(ByteArrayInputStream byteArrayInputStream) {


    }
}
