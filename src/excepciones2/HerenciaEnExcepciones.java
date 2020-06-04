package excepciones2;

public class HerenciaEnExcepciones {

    void lanza1() throws Checked1 {
        throw new Checked1();
    }
    void lanza2() throws Checked2 {
        throw new Checked2();
    }
    void lanzaTodos() throws Checked1, Checked2 { //checked2 ISA checked1, entonces no es necesario
        lanza1();
        lanza2();
    }
    void ejecutaLanzaTodos(){
        try {
            lanzaTodos();
        } catch (Checked1 checked1) {
            checked1.printStackTrace();
        }
    }

    void lanzaTodos2() throws Exception { //checked2 y checked1 son Exception, entonces no es necesario
        lanza1();
        lanza2();
    }
    void lanzaTodos3() throws Throwable { //checked2 y checked1 son throwable, entonces no es necesario
        lanza1();
        lanza2();
    }

    void lanzaUnchecked(){ //no hace falta declararlo con thorws
        throw new AnotherException();
    }

    void catchTodos() {
        try {
            lanza1(); //Lanza Checked1
            lanza2();  //Lanza Checked2
        } catch (Checked2 checked) { //si descometo esta ok,
        } catch (Checked1 checked) {
            checked.printStackTrace();
        //} catch (Checked2 checked) { // si descometo no esta ok  NO COMPILA ya esta capturada  unreached
        }
    }

    void usandoUnchecked(){
        lanzaUnchecked();
    }

    void usandoUnchecked2(){
        try {
            lanzaUnchecked();
        }catch (AnotherException e){}
    }
    void usandoUnchecked3(){
        try {
            lanzaUnchecked();
        }catch (RuntimeException e){}
    }

    void usandoUnchecked4(){
        try {
            lanzaUnchecked();
        }catch (Throwable e){}
    }

    void usandCombinadas() throws Checked1 {

        lanza1(); //otro caso de negocio ante Checked1
        try {
            lanza2();
        } catch (AnotherException checked2) {
            //un caso de negocio ante la AnotherException

        } catch (Checked2 checked2) {
            checked2.printStackTrace(); //caso de negocio Checked2
        } finally {
            //siempre pasaras pr aqui
            // ejemplo de cerrar recurso
        }
    }

    void lanzaSoloException() throws Exception{
        lanza1();
        lanza2();
    }
    void ejecutarSoloException(){
        try {
            lanzaSoloException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
