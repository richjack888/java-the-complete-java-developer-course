public class Main {
    public static void main(String[] args) {

        ParentClass eldest = new ParentClass();
        eldest.myPolymorphicMethod();
        eldest.myPrivateMethod();
        ChildClass youngest = new ChildClass();
        youngest.myPolymorphicMethod();
        ParentClass middle = new ChildClass();
        middle.myPolymorphicMethod();
        middle.myPrivateMethod();


    }

    static class ParentClass {
        private void myPrivateMethod() {
            System.out.println("Parents private method.");
        }

        void myPolymorphicMethod() {
            System.out.println("Calling parent class's method.");
        }
    }

    static class ChildClass extends ParentClass {
        void myPolymorphicMethod() {
            System.out.println("Calling child class's method.");
        }
    }
}

