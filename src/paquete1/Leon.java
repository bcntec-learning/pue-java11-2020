package paquete1;

public class Leon extends Mamifero implements Vacunable {

    @Override
    //no se puede private void mamar() {
    public void mamar() {
        super.mamar(); //llama al padre para ejecute el mismo meotdo u otro
        dormir(); //puede poner lo que quiera
    }
    //sobrecarga y no tiene q ver con
    public void mamar(int litros){

    }
    private void dormir(){}

}
