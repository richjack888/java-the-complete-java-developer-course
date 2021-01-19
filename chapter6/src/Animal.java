public class Animal {

    private String sex;
    private String size;
    private String weight;

    public Animal(String sex, String size, String weight) {
        this.sex = sex;
        this.size = size;
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public String getSize() {
        return size;
    }

    public String getWeight() {
        return weight;
    }

    public void eat() {
        System.out.println("Animal.eat() method");
    }

}
