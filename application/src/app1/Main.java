package app1;

import facturacion.ServicioFacturacion;
import modulos.readers.LogoReader;
import ventas.ServicioVentas;

import java.net.URL;

public class Main {
    ServicioFacturacion servicioFacturacion = new ServicioFacturacion();
    ServicioVentas servicioVentas = new ServicioVentas();
    LogoReader logoReader;

    public static void main(String[] args) {
        URL url = Main.class.getResource("/config.properties");
        System.out.println(url);
    }
}
