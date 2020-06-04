package exceptions;

public class HaciendaAPI {
    private static final String CUENTA_HACIENDA="1232312312";

    Integer cobrar(String cuenta, Double importe) throws SaldoInsuficienteException {
        //pregunto saldo
        Double saldo = calcularSaldo(cuenta);
        if(saldo<importe){
            throw new SaldoInsuficienteException(saldo);
        }
        transferencia(cuenta, importe, CUENTA_HACIENDA);
        //si la operacion es correcta
        return 87;
    }

    private String transferencia(String cuenta, Double importe, String cuentaHacienda) {
    return "723896592836529";
    }

    private Double calcularSaldo(String cuenta) {
        return 7D;
    }
}
