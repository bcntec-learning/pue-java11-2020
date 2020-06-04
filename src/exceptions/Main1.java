package exceptions;

public class Main1 {

    public void test1(){

        //checked1();
        checked2();
        try {
            checked1();
        }catch(CheckedException e){
            //este error no pasa nda
        }

        uuyuyuUnchecked();
        try {
            //algo que lance o no eception Unchecked
            uuyuyuUnchecked();
        }catch(UncheckedException e){
            e.printStackTrace();
        }
    }

    public void checked1() throws CheckedException {
        throw new CheckedException();
    }


    public void checked2(){
        try{
            checked1();
        }catch (CheckedException w){
            w.printStackTrace();
        }
    }
    public void checked3() throws CheckedException{
            checked1();
    }
    public void uuyuyuUnchecked(){
        throw new UncheckedException();
    }
}
