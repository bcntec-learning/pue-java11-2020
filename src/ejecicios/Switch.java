package ejecicios;

public class Switch {
    enum P{A,B,C}

    Switch(){


        char c  = 55;
        switch (c){
            case 1:
            case 2:
            case 3:
        }


        int c2  = 55;
        switch (c2){
            case 1:
            case 2:
            case 3:
        }

        Integer i  = 55;
        switch (i){
            case 1:
            case -2:
            case 3:
        }
        P p  = P.A;
        switch (p){
            case A:
            case B:
            case C:
        }

        String z="HOLA";

        switch (z){
            case "A":
            case "B":
            default:
        }
        Boolean b = true;
//        switch (b){

//        }
        Long r = 5L;
//        switch (r){
//            case 7L:
//        }

    }
}
