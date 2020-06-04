package inners;

public class AnonimasConInterfacesInnerClass {

    interface SayHello {
          void sayHello();
    }

    public static void main(String[] args) {
        new AnonimasConInterfacesInnerClass().test();
    }
    public void test() {
        SayHello z1 = new SayHello(){
            @Override
            public void sayHello() {
                System.out.println("hola");
            }

        };
        z1.sayHello();
        System.out.println(z1.getClass());
        System.out.println(z1 instanceof SayHello);

        SayHello z2 = new SayHello(){
            @Override
            public void sayHello() {
                System.out.println("hello");
            }
        };
        z2.sayHello();
        System.out.println(z2.getClass());
        System.out.println(z2 instanceof SayHello);

    }
}
