package exam1;

public class Test12 {
    private static class Greet{
        private void print(){
            System.out.println("Hello World");
        }
    }

    public static void main(String[] args) {
        Test12.Greet i = new Greet();
        i.print();
    }

}
