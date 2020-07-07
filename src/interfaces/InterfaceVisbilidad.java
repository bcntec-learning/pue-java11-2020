package interfaces;

public interface InterfaceVisbilidad {
    public abstract void noRequired();  //public es la vidiblidad por defecto
}


class Impl implements  InterfaceVisbilidad{

    @Override
    public void noRequired() {

    }
}

//invalid private interface D {}