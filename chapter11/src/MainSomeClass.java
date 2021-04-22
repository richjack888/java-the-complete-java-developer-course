public class MainSomeClass {
    public static void main(String[] args) {
        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

//        one.instanceNumber = 4; // Cannot assign a value to final variable 'instanceNumber'
        System.out.println(Math.PI);
//        Math math = new Math(); // 'Math()' has private access in 'java.lang.Math'
    }
}
