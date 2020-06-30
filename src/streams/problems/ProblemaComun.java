package streams.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProblemaComun {


    public static final Function<String, Optional<Integer>> secureParse = (s) -> {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
        }

        return Optional.empty();
    };


    public static void main(String[] args) {

        List<String> integers = Arrays.asList("234", "76", "35647", "hola");
        integers.forEach(s -> {
            try {
                System.out.println(Integer.parseInt(s));
            } catch (NumberFormatException e) {
            }
        });


        integers.forEach((SecureConsumer<String>) s -> {
            System.out.println(Integer.parseInt(s));
        });

        integers.forEach((Consumer<String>) s -> {
            System.out.println(Integer.parseInt(s));
        });

        SecureConsumer<String> secureConsumer = (s) -> {
            System.out.println(Integer.parseInt(s));
        };

        integers.forEach(secureConsumer);
        integers.forEach(secureConsumer);


        integers.stream().map(secureParse).forEach(System.out::println);

        integers.stream().filter(ProblemaComun::isNumber).forEach(s -> System.out.println(Integer.parseInt(s)));


        Map<Boolean, List<Dato>> partitioned = integers.stream().map(Dato::new)
                .collect(Collectors.partitioningBy(Dato::isOk));

        System.out.println("FALSE ==============");
        partitioned.get(Boolean.FALSE).stream().map(Dato::getStr).forEach(System.out::println);
        System.out.println("TRUE  ==============");
        partitioned.get(Boolean.TRUE).stream().mapToInt(Dato::getVal).forEach(System.out::println);


    }

    public static boolean isNumber(String arg) {
        try {
            Double.parseDouble(arg);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;

    }

    @FunctionalInterface
    public interface SecureConsumer<T> extends Consumer<T> {
        default void accept(T t) {
            try {
                acceptWithException(t);
            } catch (Exception e) {
                //gestionar el error
            }
        }

        void acceptWithException(T t);
    }


    @FunctionalInterface
    public interface SecureFunction<T, R> extends Function<T, R> {
        default R apply(T t) {
            try {
                return applyWithException(t);
            } catch (Exception e) {
                //gestionar el error
            }
            return null;
        }

        R applyWithException(T t);
    }

    static class Dato {
        String str;
        Integer val;

        public Dato(String str) {
            this.str = str;
            try {
                this.val = Integer.parseInt(str);
            } catch (NumberFormatException e) {
            }

        }

        public String getStr() {
            return str;
        }

        public Integer getVal() {
            return val;
        }

        public boolean isOk() {
            return val != null;
        }
    }

}
