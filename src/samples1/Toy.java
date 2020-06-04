package samples1;

import java.util.ArrayList;
import java.util.List;

class Toy {
    double price;
    String color;

    Toy(String color,
        double price) {
        this.color = color;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        List<Toy> toys = new ArrayList<>();
        toys.add(new Toy("red", 10));
        toys.add(new Toy("yellow", 10));
        toys.add(new Toy("red", 10));

        //toys.stream().forEach(t-> System.out.println(t.getColor()));

        double totalPrice = toys.stream() //creamos un flujo Stream<Toy>
                .filter(e -> e.getColor() == "red")
                /* Line n1 */
                //.flatMap(e -> e.getPrice()) //interface funcional
                .mapToDouble(e -> e.getPrice()) //el flujo cambia a DoubleStream
                //.map(e -> e.getPrice()) //el flujo cambia a Stream<Double>
                //.peek(e -> e.getPrice())
                .sum(); //es una operacion de acumulacion que forma parte de DoubleStream

        System.out.println("Total Price of Red Toys:" + totalPrice);
        /*Which code fragment can be inserted at Line n1 to enable the code to print Total Price of Red Toys:20.0 ?
                A) .flatMap(e -> e.getPrice())
                B) .mapToDouble(e -> e.getPrice())
                C) .map(e -> e.getPrice())
                D) .peek(e -> e.getPrice())

         */
    }
}