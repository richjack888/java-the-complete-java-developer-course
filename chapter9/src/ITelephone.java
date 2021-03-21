public interface ITelephone {
    void powerOn();
    void dial(int phoneNumber);
    void answer();
    boolean callPhone(int phoneNumber);
    boolean isRinging();
    default void dancing(){
        System.out.println("Let's dance!");
    }


}
