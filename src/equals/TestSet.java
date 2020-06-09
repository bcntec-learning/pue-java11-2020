package equals;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TestSet {


    public static void main(String[] args) {
        Circle y1 = new Circle(1,1,1);
        Circle z1 = new Circle(1,2,1);
        Circle z2 = new Circle(2,1,1);
        Circle z3 = new Circle(1,1,1);

        Circle w1 = z1;

        Set<Circle> set = new HashSet<>();
        System.out.println(set.add(y1));
        System.out.println(set.add(z1));
        System.out.println(set.add(z1));
        System.out.println(set.add(w1));
        System.out.println(set.add(z2));
        System.out.println(set.add(z3));
        System.out.println("set="+set.size());

    }

}
