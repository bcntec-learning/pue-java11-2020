package exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main39 {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Input: ");
            String string = in.readLine();
            System.out.println("Echo: "+string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
