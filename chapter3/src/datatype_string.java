public class datatype_string {

    public static void main(String[] args) {

        String myString = "A(This part is a string of variables)";
        System.out.println("B(This part isn't) " + myString);
        myString = myString + ", C(and this is more.)";
        System.out.println("D(This part isn't too)" + myString);
        myString = myString + "E(\u00A9 2020/12)";
        System.out.println("F(This part isn't too)" + myString);
        String numberString = "123.234";
        numberString = numberString + "345";
        System.out.println(numberString);
        String lastString = "A(10)";
        int MyInt = 20;
        lastString = lastString + MyInt;
        System.out.println("B(String)" + lastString);
        double doubleNumber = 30.456d;
        lastString = lastString + doubleNumber;
        System.out.println("C(String)" + lastString);

    }
}
