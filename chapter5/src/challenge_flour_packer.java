public class challenge_flour_packer {

    public static void main(String[] args) {

        System.out.println(canPack(1, 0, 4));
        System.out.println(canPack(1, 0, 5));
        System.out.println(canPack(0, 5, 4));
        System.out.println(canPack(2, 2, 11));
        System.out.println(canPack(-3, 2, 12));
        System.out.println(canPack(5, 3, 24));
        System.out.println(canPack(4, 18, 19));

    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {

        if ((bigCount >= 0) && (smallCount >= 0) && (goal >= 0) && ((bigCount * 5) + smallCount >= goal)) {
            for (int x = 0; x <= bigCount; x++) {
                for (int y = 0; y <= smallCount; y++) {
                    if ((x * 5) + y == goal) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
