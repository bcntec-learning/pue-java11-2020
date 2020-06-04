package interfaces;

public class ThirdClass extends SecondClass
        implements FirstInterface{
    @Override
    public void sayHello() {
        System.out.println(lang());
    }
}
