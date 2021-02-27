public class MainBank_TimVersion {

    public static void main(String[] args) {
        Bank_TimVersion bank = new Bank_TimVersion("City Bank");
        bank.addBranch("New York");

        bank.addCustomer("New York", "Tim", 500.05);
        if (!bank.addCustomer("New York", "Tim", 500)) {
            System.out.println("Already had");
        }
        bank.addCustomer("New York", "Tim", 500);
        bank.addCustomer("New York", "Jemmy", 170.56);
        bank.addCustomer("New York", "Zic", 320.22);

        bank.addBranch("Los Angel");
        bank.addCustomer("Los Angel", "Bonny", 126.54);

        bank.addCustomerTransaction("New York", "Tim", 36.66);
        bank.addCustomerTransaction("Los Angel", "Bonny", 36.66);

        bank.listCustomer("Los Angel", true);
        bank.listCustomer("New York", false);

        if (!bank.addCustomer("Sydney", "Brian", 6.66)) {
            System.out.println("Error Sydney branch doesn't exist");
        }


    }


}
