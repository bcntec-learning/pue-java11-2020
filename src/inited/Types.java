package inited;

import java.lang.reflect.Type;

public class  Types {
    int l;
    public void v(){
        int t;
        //reuieres init t++;
        l++;
    }
    private class A {
    }

    public static void someMethod(){}


}
final class B extends Types{
    {
        Types.someMethod();
    }
    public static void someMethod(){}
}

