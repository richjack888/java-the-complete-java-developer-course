public class traditionSwitchChallenge {
    public static void main(String[] args) {
        char charValue = 'A';
        switch (charValue) {
            case 'A': {
                System.out.println("A is for Able");
                break;
            }
            case 'B': {
                System.out.println("B is for Baker");
                break;
            }
            case 'C': {
                System.out.println("C is for Charlie");
                break;
            }
            case 'D': {
                System.out.println("D is for Dog");
                break;
            }
            case 'E': {
                System.out.println("E is for Easy");
                break;
            }
            default: {
                System.out.println("Letter" + charValue + " was not found in the switch!");
                break;


            }
        }
    }
}