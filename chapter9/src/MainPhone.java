public class MainPhone {
    public static void main(String[] args) {
        ITelephone timsPhone;
        timsPhone = new DeskPhone(123456);
        timsPhone.powerOn();
        timsPhone.callPhone(123456);
        timsPhone.answer();

        timsPhone = new MobilePhone(987654);
        timsPhone.powerOn();
        timsPhone.callPhone(987654);
        timsPhone.answer();
        timsPhone.dancing();

    }
}
