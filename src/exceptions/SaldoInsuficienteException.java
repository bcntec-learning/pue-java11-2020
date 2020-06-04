package exceptions;

public class SaldoInsuficienteException extends Exception{
    private Double saldo;
    public SaldoInsuficienteException(Double saldo) {
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return saldo;
    }
}
