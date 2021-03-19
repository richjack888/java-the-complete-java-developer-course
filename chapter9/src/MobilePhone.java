public class MobilePhone implements ITelephone {

    int myNumber;
    boolean isRinging;
    boolean isOn = false;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("Mobile phone power on!");
        isOn = true;
    }

    @Override
    public void dial(int phoneNumber) {
        if(isOn){
            System.out.println("Now ringing " + phoneNumber + " on mobile phone.");
        }else {
            System.out.println("Phone is switched off.");
        }
    }

    @Override
    public void answer() {
        if (isRinging) {
            System.out.println("Answering the mobile phone.");
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == myNumber && isOn) {
            isRinging = true;
            System.out.println("Mobile phone ring ring");
        } else {
            isRinging = false;
            System.out.println("Mobile phone not on.");
        }
        return false;
    }

    @Override
    public boolean isRinging() {
        return false;
    }
}
