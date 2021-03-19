public class DeskPhone implements ITelephone{

    int myNumber;
    boolean isRinging;

    public DeskPhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("No action taken, desk phone does not have a power button.");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now ringing " + phoneNumber + " on desk phone.");
    }

    @Override
    public void answer() {
        if(isRinging){
            System.out.println("Answering the desk phone.");
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == myNumber){
            isRinging = true;
            System.out.println("Desk Phone ring ring");
        }else{
            isRinging = false;
        }
        return false;
    }

    @Override
    public boolean isRinging() {
        return false;
    }
}
