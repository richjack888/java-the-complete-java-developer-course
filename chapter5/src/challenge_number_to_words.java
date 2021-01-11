public class challenge_number_to_words {

    public static void main(String[] args) {

//        System.out.println(reverse(-121));
//        System.out.println(reverse(1212));
//        System.out.println(reverse(1234));
//        System.out.println(reverse(100));

//        System.out.println(getDigitCount(0));
//        System.out.println(getDigitCount(123));
//        System.out.println(getDigitCount(-12));
//        System.out.println(getDigitCount(5200));

        numberToWords(123);
        numberToWords(1010);
        numberToWords(1000);
        numberToWords(-12);

    }

    public static void numberToWords(int number) {
        if (number < 0) System.out.println("Invalid Value");

        int reverse_number = reverse(number);
        String word = "";
        for (int i = 0; i < getDigitCount(number); i++) {
            int digit = reverse_number % 10;
            switch (digit) {
                case 0:
                    word += "Zero ";
                    break;
                case 1:
                    word += "One ";
                    break;
                case 2:
                    word += "Two ";
                    break;
                case 3:
                    word += "Three ";
                    break;
                case 4:
                    word += "Four ";
                    break;
                case 5:
                    word += "Five ";
                    break;
                case 6:
                    word += "Six ";
                    break;
                case 7:
                    word += "Seven ";
                    break;
                case 8:
                    word += "Eight ";
                    break;
                case 9:
                    word += "Nine ";
                    break;
            }
            reverse_number /= 10;
        }

        System.out.println(word);
    }


    public static int reverse(int number) {
        int value = 0;
        while (number != 0) {
            value = (value * 10) + (number % 10);
            number /= 10;
        }
        return value;
    }

    public static int getDigitCount(int number) {
        if (number < 0) return -1;
        int digit_count = 0;
        while (number != 0) {
            number /= 10;
            digit_count++;
        }
        return (digit_count != 0) ? digit_count : 1;

    }


}


