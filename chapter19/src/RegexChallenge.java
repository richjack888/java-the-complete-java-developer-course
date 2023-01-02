package src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChallenge {
    public static void main(String[] args) {
        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));

        String challenge2 = "I want a bike.";
        String challenge3 = "I want a ball.";
        System.out.println(challenge2.matches("I want a b.{3}."));
        System.out.println(challenge3.matches("I want a b.{3}."));
        System.out.println(challenge2.matches("I want a \\w+."));
        System.out.println(challenge3.matches("I want a \\w+."));

        Pattern pattern = Pattern.compile("I want a \\w+.");
        Matcher matcher1 = pattern.matcher("I want a bike.");
        System.out.println(matcher1.matches());
        Matcher matcher2 = pattern.matcher("I want a ball.");
        System.out.println(matcher2.matches());

        String challenge4 = "Replace all blanks with       underscores.";
        System.out.println(challenge4.replaceAll("\\s", "_"));
        System.out.println(challenge4.replaceAll(" ", "_"));

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("\\w+"));
        System.out.println(challenge5.matches("[a-g]+"));
        System.out.println(challenge5.matches("^a*g$"));

        // entire exactly string
        String challenge6 = "aaabccccccccdddefffg";
        System.out.println(challenge6.matches("^aaabccccccccdddefffg$"));
        System.out.println(challenge6.matches("^a{3}bc{8}d{3}ef{3}g$"));

        // starts with series of letters and must be floowed by a period
        // after period must be a series of digits
        String challenge7 = "abcd.123";
        System.out.println(challenge7.matches("^[a-zA-Z]+[.]\\d+$"));
        String challenge8 = "kjisl.22";
        System.out.println(challenge8.matches("^[a-zA-Z]+[.]\\d+$"));
        String challenge9 = "f5.12a";
        System.out.println(challenge9.matches("^[a-zA-Z]+[.]\\d+$"));


    }
}
