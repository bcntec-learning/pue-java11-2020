package exam1;

public class AuthrInfoCases {

}

// nivel meotodo no clase @AuthInfo(date = "1-1-2020", comments = {null})  //null no es K
class HelloA{
    public void f(){};
}

class HelloB{
    @AuthInfo(date = "1-1-2020")
    public void f(){};
}

class HelloC{
  //no tiene date  @AuthInfo
    public void f(){};
}

//error @AuthInfo(date = "1-1-2020")
class Hellod{
    public void f(){};
}
class HelloE{
    @AuthInfo(date = "1-1-2020", author = "gandhi", comments = "world")  //es array pero permite un solo elemneto
    public void f(){};
}

