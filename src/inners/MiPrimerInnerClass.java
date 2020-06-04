package inners;

public class MiPrimerInnerClass {


    public HijoProtectedInner construirPortected() {
        return new HijoProtectedInner();
    }
    /* no es viable pq es static el metodo y la inner class
    public static HijoProtectedInner construirPortectedStatic() {
        return new HijoProtectedInner();
    }

     */

    class HijoDefaultInner{}
    private class HijoPrivateInner{}
    protected class HijoProtectedInner {}
    public class HijoPublicInner {}
    public static class HijoStaticInner {}

    public MiPrimerInnerClass(){
        new HijoPrivateInner();
        new HijoDefaultInner();
        new HijoProtectedInner();
        new HijoPublicInner();
    }

    public void miMetodoNoStatic(){
        MiPrimerInnerClass m =new MiPrimerInnerClass();
        //no es valido new m.Hijo0Inner();

        MiPrimerInnerClass.HijoDefaultInner m0 =new HijoDefaultInner();
    }

    public static void main(String[] args) {
        /* por ser static
        new MiPrimerInnerClass.HijoDefaultInner();
        new HijoDefaultInner();
        new HijoProtectedInner();
        new HijoPublicInner();
         */
        new HijoStaticInner();

    }
}

 class OutClass{}
