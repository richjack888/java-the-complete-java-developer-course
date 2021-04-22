class MainPassword {
    public static void main(String[] args) {
        int pw = 123456;
        Password password = new Password(pw);
        password.storePassword();

        password.letMeIn(65);
        password.letMeIn(-65);
        password.letMeIn(6565);
        password.letMeIn(0);
        password.letMeIn(123456);

    }
}
