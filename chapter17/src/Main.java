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
        String silly = anotherClass.doSomething();
        System.out.println(silly);

        int n = 0;
        System.out.println(n);
        




    }

    public static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}


class AnotherClass {

    public static final double PI = 3.141592653589793;

    public double radius;
    public double xPos;
    public double yPos;
    public double zPos;

    AnotherClass() {
    }

    void Sphere(double x, double y, double z, double r) {
        radius = r;
        xPos = x;
        yPos = y;
        zPos = z;
    }
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
        final int[] i = {0};
        {
            UpperConcat uc = new UpperConcat() {
                @Override
                public String upperAndConcat(String s1, String s2) {
                    i[0]++;
                    System.out.println("inside anonymous: " + i[0]);
                    return s1.toUpperCase() + s2.toUpperCase();
                }
            };
//            i++;
            System.out.println(i[0]);
            return Main.doStringStuff(uc, "String1", "String2");
        }
    }
}

