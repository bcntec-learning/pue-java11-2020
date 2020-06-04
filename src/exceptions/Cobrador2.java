package exceptions;

public class Cobrador2 {
    public static void main(String[] args) {
        HaciendaAPI2 api = new HaciendaAPI2();
        String ct ="334242342";
        try {
            api.cobrar(ct,10d);
            //cerrar causa
        } catch (SaldoInsuficienteException e) {
            //grabar que el saldo no alcanzo
            //volverr  a notificar
        }
    }
}
