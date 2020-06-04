package exceptions;

public class Cobrador {
    public static void main(String[] args) {
        HaciendaAPI api = new HaciendaAPI();
        String ct ="334242342";
        try {
            api.cobrar(ct,10d);
        } catch (SaldoInsuficienteException e) {
            //enviar carta reclmando la operacion
            try {
                api.cobrar(ct, e.getSaldo());
            } catch (SaldoInsuficienteException s) {
                //llamar a laegales
            }
        }
    }
}
