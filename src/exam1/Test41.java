package exam1;

public class Test41 {

    public static void main(String[] args) {
        //B
        //Runnable b = ()->System.out::println;  ()-> {System.out.println();};
        //Runnable b = System.out::println;  //-->  System.out.println();
        //Runnable d= ->System.out.println("Message");  //si nro arg==1 no hace falta poner (), en el resto si
        //Runnable e = {System.out.println("Message")};
        Runnable c = () -> {System.out.println("Message");};
    }
}
