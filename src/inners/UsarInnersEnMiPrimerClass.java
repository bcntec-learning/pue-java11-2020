package inners;

public class UsarInnersEnMiPrimerClass {
    private MiPrimerInnerClass.HijoStaticInner staticInner
            = new MiPrimerInnerClass.HijoStaticInner();

    /*
    private MiPrimerInnerClass.HijoProtectedInner protectedInner
            = new MiPrimerInnerClass.HijoProtectedInner(); no es static
    */
    private MiPrimerInnerClass.HijoProtectedInner protectedInner
            = new MiPrimerInnerClass().construirPortected();
    //=  MiPrimerInnerClass.construirPortectedStatic();


    private SegundaInnerClass.HijoStaticInner static2Inner;

}
