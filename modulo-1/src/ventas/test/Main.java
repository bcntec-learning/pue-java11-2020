package ventas.test;

import java.net.URL;

public class Main {
    public static void main(String[] args) {
        URL url = Main.class.getResource("/config.properties");
        System.out.println(url);
    }
}
