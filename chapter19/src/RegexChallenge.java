package src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChallenge {
    public static void main(String[] args) {
//        String challenge1 = "I want a bike.";
//        System.out.println(challenge1.matches("I want a bike."));
//
//        String challenge2 = "I want a bike.";
//        String challenge3 = "I want a ball.";
//        System.out.println(challenge2.matches("I want a b.{3}."));
//        System.out.println(challenge3.matches("I want a b.{3}."));
//        System.out.println(challenge2.matches("I want a \\w+."));
//        System.out.println(challenge3.matches("I want a \\w+."));
//
//        Pattern pattern = Pattern.compile("I want a \\w+.");
//        Matcher matcher1 = pattern.matcher("I want a bike.");
//        System.out.println(matcher1.matches());
//        Matcher matcher2 = pattern.matcher("I want a ball.");
//        System.out.println(matcher2.matches());
//
//        String challenge4 = "Replace all blanks with       underscores.";
//        System.out.println(challenge4.replaceAll("\\s", "_"));
//        System.out.println(challenge4.replaceAll(" ", "_"));
//
//        String challenge5 = "aaabccccccccdddefffg";
//        System.out.println(challenge5.matches("\\w+"));
//        System.out.println(challenge5.matches("[a-g]+"));
//        System.out.println(challenge5.matches("^a*g$"));
//
//        // entire exactly string
//        String challenge6 = "aaabccccccccdddefffg";
//        System.out.println(challenge6.matches("^aaabccccccccdddefffg$"));
//        System.out.println(challenge6.matches("^a{3}bc{8}d{3}ef{3}g$"));
//
//        // starts with series of letters and must be flowed by a period
//        // after period must be a series of digits
//        String challenge7 = "abcd.123";
//        System.out.println(challenge7.matches("^[a-zA-Z]+[.]\\d+$"));
//        String challenge7_1 = "kjisl.22";
//        System.out.println(challenge7_1.matches("^[a-zA-Z]+[.]\\d+$"));
//        String challenge7_2 = "f5.12a";
//        System.out.println(challenge7_2.matches("^[a-zA-Z]+[.]\\d+$"));

////         extract all part of digits from string
//        String challenge8 = "abcd.135uvqz.7tzik.999";
//        Pattern pattern8 = Pattern.compile("(\\d+)");
//        Matcher matcher8 = pattern8.matcher(challenge8);
//        while (matcher8.find()) {
//            System.out.println("Occurrence: " + matcher8.group(1));
//        }

//        // extract all part of digits from string
//        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
//        Pattern pattern9 = Pattern.compile("(\\d+)");
//        Matcher matcher9 = pattern9.matcher(challenge9);
//        while (matcher9.find()) {
//            System.out.println("Occurrence: " + matcher9.group(1));
//        }

//        // extract all part of digits and point out the indices from string
//        String challenge10 = "abcd.135\tuvqz.7\ttzik.999\n";
//        Pattern pattern10 = Pattern.compile("(\\d+)");
//        Matcher matcher10 = pattern10.matcher(challenge10);
//        while (matcher10.find()) {
//            System.out.println("Occurrence: " + matcher10.group(1) + ", start: " + matcher10.start() + ", end: " + (matcher10.end() - 1));
//        }

//        // extract what in curly braces
//        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
//        Pattern pattern11 = Pattern.compile("\\{(.*?)\\}");
//        Pattern pattern11a = Pattern.compile("\\{(\\d+, \\d+)\\}");
//        Matcher matcher11 = pattern11.matcher(challenge11);
//        while (matcher11.find()) {
//            System.out.println("Occurrence: " + matcher11.group(1));
//        }

//        // match a 5-digit US zip code
//        String challenge12 = "11111";
//        System.out.println(challenge12.matches("^\\d{5}$"));
//        String challenge12a = "111211";
//        System.out.println(challenge12a.matches("^\\d{5}$"));

//        String challenge13 = "11111-1111";
//        System.out.println(challenge13.matches("^\\d{5}-\\d{4}$"));
//        String challenge13a = "11111-11112";
//        System.out.println(challenge13a.matches("^\\d{5}-\\d{4}$"));

        // 5-digit US zip code and optional 4 digits preceded by a dash
        String challenge14 = "11111";
        System.out.println(challenge14.matches("\\d{5}(-\\d{4})?"));
        String challenge14a = "11111-1111";
        System.out.println(challenge14a.matches("\\d{5}(-\\d{4})?"));





    }
}
