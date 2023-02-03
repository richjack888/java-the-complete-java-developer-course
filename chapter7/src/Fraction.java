public class Fraction {
    int numerator;
    int denominator;
    int integerPart;

    public Fraction(int numerator, int denominator) {
        this.denominator = denominator;
        this.integerPart = numerator / denominator;
        this.numerator = numerator % denominator;
        if (gcd(numerator, denominator) > 1) {
            int gcd = gcd(numerator, denominator);
            this.numerator = this.numerator / gcd;
            this.denominator = this.denominator / gcd;
        }
    }

    public Fraction add(Fraction f) {
        int newDenominator = this.denominator * f.denominator;
        int newNumerator = (this.integerPart + f.integerPart) * newDenominator + this.numerator * f.denominator + f.numerator * this.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // greatest common divisor
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }


    @Override
    public String toString() {
        return "整數=" + integerPart + "，分子=" + numerator + "，分母=" + denominator;

    }
}

class Test {
    public static void main(String[] args) {
//        Fraction fraction1 = new Fraction(15, 8);
//        Fraction fraction2 = new Fraction(5, 6);
//        Fraction result = fraction1.add(fraction2);
//        System.out.println(result);
//
//        Fraction fraction3 = new Fraction(1, 5);
//        Fraction fraction4 = new Fraction(2, 5);
//        Fraction result2 = fraction3.add(fraction4);
//        System.out.println(result2);

//        System.out.println(4%8);
        System.out.println(Fraction.gcd(4, 8));



    }
}