package exam1;

import java.util.function.Consumer;

public class Test47 {
    public static void main(String[] args) {
        Consumer<String> consumer = (String a)-> System.out.print(a);
        Consumer consumerB = (var a)-> System.out.print(a);
    }
}
