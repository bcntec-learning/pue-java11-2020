package exam1;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Employee31 {
    private String name;
    private double salary ;

    public Employee31(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        List<Employee31> list = List.of(
                new Employee31("John", 80000.0),
                new Employee31("Scott", 90000.0),
                new Employee31("Francisco", 2000000.0)
        );
        double starts= 0.0;
        double ratio= 1.0;

        BinaryOperator<Double> bo = (a,b) -> a+b;

        Optional<Double> optionalTotalSalaru = list.stream().map(e->e.getSalary()*ratio).reduce(bo);

        double totalSalaru = list.stream()
                .map(e->e.getSalary()*ratio) //trasnforma
                .reduce(starts, bo);  //acumula


        //no compila double totalSalaruA = list.stream().map(e->e.getSalary()*ratio).reduce( bo).ifPresent(p->p.doubleValue());
        //double totalSalaruB = list.stream().mapToDouble(e->e.getSalary()*ratio).sum;  mapToDouble transforma el flujo a DoubleStrean, sum es un metodo, no una variable


        double totalSalaruC = list.stream().map(e->e.getSalary()*ratio).reduce(bo).orElse(0.0);

        //double totalSalaruD  = list.stream().mapToDouble(e->e.getSalary()*ratio).reduce( starts, bo);
        //mapToDouble transforma el flujo a DoubleStean, para reducir un DoubleStream necessitamos un DoubleBinaryOperator para garnatizar el tipo y las operaciones

        System.out.println("total salary "+totalSalaru);

        double salaryT = 0.0;
        for (Employee31 employee31 : list) {
            salaryT += employee31.getSalary()*ratio;
        }

    }
}
