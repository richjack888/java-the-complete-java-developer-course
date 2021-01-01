public class practiceD_barking_dog {

    public static void main(String[] args) {


        System.out.println(shouldWakeUp(true, 1));
        System.out.println(shouldWakeUp(false, 2));
        System.out.println(shouldWakeUp(true, 8));
        System.out.println(shouldWakeUp(true, -1));
        System.out.println(shouldWakeUp(true, 0));
        System.out.println(shouldWakeUp(true, 24));

    }

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {

        if (barking) {
            return (hourOfDay < 8 && hourOfDay >= 0) || hourOfDay == 23;
        }
        return false;
    }
}