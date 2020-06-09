package equals;


import java.util.*;

public class TestList {


    public static void main(String[] args) {
        Circle y1 = new Circle(1,1,1);
        Circle z1 = new Circle(1,2,3);
        Circle z2 = new Circle(2,1,2);
        Circle z3 = new Circle(1,1,1);

        Circle w1 = z1;

        List<Circle> list = new ArrayList<>();
        System.out.println(list.add(y1));
        System.out.println(list.add(z1));
        System.out.println(list.add(z1));
        System.out.println(list.add(w1));
        System.out.println(list.add(z2));
        System.out.println(list.add(z3));
        System.out.println("set="+list.size());

        System.out.println(list);

        list.sort(new Comparator<Circle>() {
            @Override
            public int compare(Circle o1, Circle o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);

        list.sort(new Comparator<Circle>() {
            @Override
            public int compare(Circle o1, Circle o2) {
                return o1.hashCode()-o2.hashCode();
            }
        });
        System.out.println(list);

        list.sort(new Comparator<Circle>() {
            @Override
            public int compare(Circle o1, Circle o2) {
                return o1.radius-o2.radius;
            }
        });
        System.out.println("Por Radio ");
        System.out.println(list);

        Collections.sort(list, (o1, o2) -> o1.xPos-o2.xPos);

        System.out.println("Por Collections x ");
        System.out.println(list);


        Collections.sort(list, Comparator.comparingInt(o -> o.yPos));
        System.out.println("Por Collections y");
        System.out.println(list);
    }

}
