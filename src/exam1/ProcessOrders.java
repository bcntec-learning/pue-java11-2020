package exam1;

import java.util.Arrays;

@AnotacionDeSergio(name ="SoloK")  //anotacion tiene un requerido/opcional que "value"
public class ProcessOrders {


    public void process(){
        //
    }

    public static void main(String[] args) {
        Arrays.asList(ProcessOrders.class.getAnnotation(AnotacionDeSergio.class))
                .forEach(System.out::println);
        Arrays.asList(ProcessOrders.class.getMethods())
                .forEach(System.out::println);
    }

}
