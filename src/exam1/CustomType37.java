package exam1;


public class CustomType37<T> {
    public <T> int count(T[] anArray, T elemant){
        int count =0;
        for(T e: anArray){
            if(e.equals(elemant)){
              ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = {"banana", "orange","apple","lemon"};
        Integer[] numbers = {1,2,3,4,5};
        CustomType37 type = new CustomType37();
        CustomType37<String> stringType = new CustomType37();

        System.out.println(stringType.count(words,"apple"));
        System.out.println(type.count(words,"apple"));
        System.out.println(type.count(numbers, 3));
    }
}
