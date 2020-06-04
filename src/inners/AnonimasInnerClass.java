package inners;

import java.util.Date;

public class AnonimasInnerClass {

    class Anonima1 {
        public void sayHello(){
            System.out.println("hello "+getHora());
        }
        public Date getHora(){
            return null;
        };
    }
    class Anonima2 extends Anonima1 {}

    public void main(String[] args) {
        Anonima1 z1 = new Anonima1(){ //es un hijo no es Anonimo1
            @Override
            public Date getHora(){
                return new Date();
            }
        };
        z1.sayHello();
        Anonima1 z2 = new Anonima1(){ //es un hijo no es Anonimo1
            @Override
            public void sayHello(){
                System.out.println("hola ");
            }
        };
        z1.sayHello();
    }
}
