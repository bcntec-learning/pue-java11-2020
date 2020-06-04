package anonimo;

public class AnonimasClass {

    Object z1 = new Object(){};
    {
        Object z1 = new Object(){}; //shadow variable
        {
            //Object z1 = new Object(){}; quien hace esto?
        }
    }

    String name;
    public void setName(String name){
        this.name=name;
    }

    public void i(Object z1){ //shadow variable que esta en el stack con refrencia al objecto
        this.z1=z1;
        ///Object z1 = new Object(){}; shado variable
    }
    static class Inner{}

    public static void main(String[] args){
        Object o1= new Object();
        Object o2= new Object();
        Object o3= new Object(){}; // es un instanceof Object pero no es un Object, es un hijo anonimo
        Object o4= new Object(){}; // es un instanceof Object pero no es un Object, es un hijo anonimo
        System.out.println("o1 es "+o1.getClass());
        System.out.println("o2 es "+o2.getClass());
        System.out.println("o3 es "+o3.getClass());
        System.out.println("o4 es "+o4.getClass());

        Runnable t= new Runnable(){
            @Override
            public void run() {
                System.out.println("run run run");
            }
        };
        AnonimasClass.Inner z = new AnonimasClass.Inner();     //uso de una inner class no anonima
        Object z2= new Object(){
            public void miMetodo(){};
        }; //creando una inner class anonima que herada del tipo que construyes
        if(z instanceof  AnonimasClass.Inner){

        }
    }
}
