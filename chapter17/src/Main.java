public class Main {
    public static void main(String[] args) {

//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        },"stupid","me");

//        String sillyString = doStringStuff(
//                (s1, s2) -> s1.toUpperCase() + s2.toUpperCase()
//                , "stupid"
//                , "me");
//
//
//        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
//        String silly = anotherClass.doSomething();
//        System.out.println(silly);
        anotherClass.printValue();





    }

    public static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}


class AnotherClass {

//    public String doSomething() {
//        System.out.println("The another class name is: " + this.getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class name is: " + this.getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1", "String2");
//    }

//    public String doSomething() {
//        return Main.doStringStuff((s1, s2) -> s1.toUpperCase() + s2.toUpperCase(), "String1", "String2");
//    }

//    public String doSomething() {
//        UpperConcat uc = (s1, s2) -> {
//            System.out.println("The lambda class name is: " + this.getClass().getSimpleName());
//            return s1.toUpperCase() + s2.toUpperCase();
//        };
//        System.out.println("The another class name is: " + this.getClass().getSimpleName());
//        return Main.doStringStuff(uc, "String1", "String2");
//    }


    public String doSomething() {



        UpperConcat upperConcat = (s1, s2) -> {
            String simpleName = this.getClass().getSimpleName();
            System.out.println("Lambda class name: " + (simpleName.equals("") ? "empty" : simpleName));
            return s1.toUpperCase() + s2.toUpperCase();

        };
        System.out.println("The another class: " + getClass().getSimpleName());
        return Main.doStringStuff(upperConcat, "Hi", "Yt");

    }

    public void printValue() {
        int number = 25;
        Runnable runnable = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The value is " + number);
            System.out.println("lambda done!");
        };

        new Thread(runnable).start();
        System.out.println("method done!");
    }
}



