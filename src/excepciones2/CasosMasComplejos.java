package excepciones2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CasosMasComplejos {

    FileInputStream abriFicheros() throws Checked1{return null;}
    void cerarFicheros(FileInputStream f) throws Checked1{}
    void leerDatos(FileInputStream f) throws Checked1{}

    void abrirVarios1(){
        FileInputStream a = null;
        FileInputStream b = null;
        FileInputStream c = null;
        try {
            a= abriFicheros();
            b = abriFicheros();
            c = abriFicheros();
        } catch (Checked1 e){
            e.printStackTrace();
        }  finally {
           if(a!=null){
               try {
                   a.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if(b!=null){
               try {
                   b.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if(c!=null){
               try {
                   c.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
    }

    void abrirVarios2(){ //usando Try-With-Resources  ->> Los objetos deben ser AutoClosable
        try (
        //String s = new String(); no es autoclosable
        FileInputStream a = abriFicheros();
        FileInputStream b = abriFicheros();
        FileInputStream d = abriFicheros()){
            try(FileInputStream r = abriFicheros()){
                //cuando necesites a r
                // si da error usnado a, b, d o r
            }
            try {

            }finally {

            }
            //en caso de exception no se ejecutara pq no hay catch
        } catch (Checked1 checked1) {
            checked1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //no hace falta declarar el finally con el cierre de los ficheros
        }
    }

    void usandoMiMetodos() throws IOException {
        FileInputStream f =null;
        try {
            f = abriFicheros(); //si falla? 1
            leerDatos(f);  // si falla 2?
            cerarFicheros(f); //si falla 3?
        } catch (Checked1 checked) {
            //cas1 no debo hacer nada pq no pue abrir el fichero

            //caso 2 el ficehro esta abierto, pero en finally se cerrar
            //caso 3
        } finally {
            //aqui cierro recuros
            //try {
                if(f!=null) {
                    f.close();
                }
            //} catch (IOException e) {
            //    e.printStackTrace();
           // }
        }
    }

}
