

public class test {
    public static void main(String[] args) {
        Age oj1 = new Age() {
            @Override
            public void getAge() {
                // printing  age
                System.out.print("Age is " + x);
            }
        };
        oj1.getAge();

    }

    //Java program to demonstrate Anonymous inner class
    interface Age {
        int x = 21;

        void getAge();
    }
}
