public class parsing_values_from_string {

    public static void main(String[] args) {

        String numberOfString = "2021.567";
        double number = Double.parseDouble(numberOfString);

        numberOfString += 1;
        number += 1;

        System.out.println("numberOfString = " + numberOfString);
        System.out.println("number = " + number);


    }


}
