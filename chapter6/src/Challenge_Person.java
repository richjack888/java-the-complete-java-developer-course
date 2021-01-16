public class Challenge_Person {

    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = (age > 0) && (age <= 100) ? age : 0;
    }

    public boolean isTeen() {
        return (age > 12) && (age < 20);
    }

    public String getFullName() {

        if (firstName.isEmpty()) {
            return getLastName();
        } else if (lastName.isEmpty()) {
            return getFirstName();
        } else if (firstName.isEmpty() && lastName.isEmpty()) {
            return "";
        }
        return getFirstName() + " " + getLastName();

    }


}
