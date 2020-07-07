package functional;

public class Tipos {

    interface FuncInt1 {
        abstract void get();
    }

    interface FuncInt2 {

        static void get() {
            return;
        }
    }
    interface FuncInt3 {

        //no final void get() {}
    }
}
