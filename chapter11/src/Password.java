public class Password {
    private static final int key = 987654321;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password);
        System.out.println(this.encryptedPassword);
    }

    private int encryptDecrypt(int password) {
        return password ^ key;
    }

    public void storePassword() {
        System.out.println("Saving password as " + this.encryptedPassword);
    }

    public boolean letMeIn(int password) {
        if (encryptDecrypt(password) == this.encryptedPassword) {
            System.out.println("Welcome!");
            return true;
        } else {
            System.out.println("Not Correct!");
            return false;
        }
    }
}
