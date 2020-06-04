package inners;

import paquete2.NoAbstracto;

public class AnonimasConAbstactosInnerClass {

    abstract class NoAnonima1 {
        protected Long uuid;
        NoAnonima1(Long uuid){
            this.uuid=uuid;
        }
        public abstract void sayHello();
    }

    public static void main(String[] args) {
        new AnonimasConAbstactosInnerClass().test();
    }
    public void test() {
        NoAnonima1 z1 = new NoAnonima1(1L){
            @Override
            public void sayHello() {
                System.out.println("hola"+uuid);
            } //es un hijo no es Anonimo1

        };
        z1.sayHello();
        System.out.println(z1.getClass());
        System.out.println(z1 instanceof NoAnonima1);

        NoAnonima1 z2 = new NoAnonima1(2L){
            @Override
            public void sayHello() {
                System.out.println("hello"+uuid);
            }
        };
        z2.sayHello();
        System.out.println(z2.getClass());
        System.out.println(z2 instanceof NoAnonima1);
    }
}
