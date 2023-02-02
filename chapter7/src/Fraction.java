public class Fraction {

    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(5, 8);
        Fraction fraction2 = new Fraction(5, 6);
        Fraction result = fraction1.add(fraction2);
        System.out.println(result);

//        Fraction fraction3 = new Fraction(1, 5);
//        Fraction fraction4 = new Fraction(2, 5);
//        Fraction result2 = fraction3.add(fraction4);
//        System.out.println(result2);

    }

    int numerator;
    int denominator;
    int integerPart;

    public Fraction(int numerator, int denominator) {
        this.denominator = denominator;
        this.integerPart = numerator / denominator;
        this.numerator = numerator % denominator;
    }

    public Fraction add(Fraction f) {
        int newNumerator = (this.integerPart + f.integerPart) * this.denominator + this.numerator * f.denominator + f.numerator * this.denominator;
        int newDenominator = this.denominator * f.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    @Override
    public String toString() {
        return integerPart + (numerator != 0 ? " " + numerator + "/" + denominator : "");
    }
}