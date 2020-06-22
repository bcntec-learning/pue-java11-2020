package exam1;

public enum Alphabet {
    A,B,C;
     static String getFirstLetter() { return A.toString(); }
    //final String getFirstLetter() { return A.toString(); }
    //static String getFirstLetter() { return Alphabet.values()[1].toString();}
}
