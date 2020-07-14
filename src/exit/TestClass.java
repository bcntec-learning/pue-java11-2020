package exit;

public class TestClass{

  public static void main(String[] args){

     try{
         new Thread(()->{
             try {
                 Thread.sleep(3000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }

         }).start();

         Thread.sleep(1000);
         System.out.println("antes del extit");
        System.exit(0);
     } catch (InterruptedException e) {
     } finally{
         System.out.println("finally is always executed!");
     }
  }
}