package exceptions;

public class HaciendaAPI2 {
    private static final String CUENTA_HACIENDA="1232312312";

    Integer cobrar(String cuenta, Double importe) throws SaldoInsuficienteException {
        //pregunto saldo
        Double saldo = calcularSaldo(cuenta);

        transferencia(cuenta, saldo, CUENTA_HACIENDA);
        if(saldo<importe){
            throw new SaldoInsuficienteException(saldo);
        }
        return 87;
    }

    private String transferencia(String cuenta, Double importe, String cuentaHacienda) {
    return "723896592836529";
    }

    private Double calcularSaldo(String cuenta) {
        return 7D;
    }
}
