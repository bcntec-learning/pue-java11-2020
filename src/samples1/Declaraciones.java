package samples1;

public class Declaraciones {
    //byte b1 = b1011;
    //byte b2 = 1011b;
    byte b3 = 0b1001;
    //byte b4 = 0xb001;

    char z = (char) ((long)  7L);
    long a = (char)  7F;
    int space = ' '; //32
    int space2 = 32;
    int b = (char)  7D;
    int b1= 'ç'; //valor ascii

    double c = 7D;
    float d = 7F;
    char d2 = (char) d;
     int d3;

     String cadena1=""; //no requiern 'new'

     String cadena2= new String("");
     String cade = cadena1+cadena2;
     String cade4= (z+a)+"->>>";

     Double t = 7D; //--> boxing/unboxing y wrapper

    String t2 = t.toString();
    String t3 = t+"";
    String t4 = 1+7+"=?";





}
