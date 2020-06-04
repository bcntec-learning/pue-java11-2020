package functional;

import java.util.function.Function;

public class ProbandoMiPrimeraFunctional {

    MiPrimeraFunctional anonimaPudeTenerEstados = new MiPrimeraFunctional() { //inner annonimous class
        private String lastHello;
        @Override
        public void sayHello(String hello) {
            System.out.println(uppercase(hello));
            lastHello=hello;
        }


    };

    {
        anonimaPudeTenerEstados.sayHello("aaaaaaaaaalllllloooooooo");

        Integer y; //implicitamente final
        y=0;
        //y++;
        MiPrimeraFunctional refeNoPuedeTenerEstados = (hello)->{  //lamda expression
            //System.err.println(uppercase(hello));  no va
            System.err.println(hello);
            System.err.println(y.byteValue());
        };



        //y++; deja de ser efectivamtne final
        refeNoPuedeTenerEstados.uppercase("alooo");

        refeNoPuedeTenerEstados.sayHello("aaaaaaaaaalllllloooooooo");

        anonimaPudeTenerEstados.sayHello("khfkajh");
        anonimaPudeTenerEstados.uppercase("khfkajh");

        Function<String,String> uppercase = (s)->s.toUpperCase();

        //if(premium) uppercase= (s)->superPremium(s)

        String s = uppercase.apply("juan");



    }

    public static void main(String[] args) {
        new ProbandoMiPrimeraFunctional();
    }
}
