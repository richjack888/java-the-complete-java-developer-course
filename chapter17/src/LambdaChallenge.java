import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;


public class LambdaChallenge {
    public static void main(String[] args) {

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                String myString = " Let's split this up into an array";
//                String[] parts = myString.split(" ");
//                for (String part : parts) {
//                    System.out.println(part);
//                }
//            }
//        };

//        // rewrite line4 to lambda
//        Runnable runnable = () -> {
//            String myString = " Let's split this up into an array";
//            String[] parts = myString.split(" ");
//            for (String part : parts) {
//                System.out.println(part);
//            }
//        };


//        // rewrite method everySecondChar to lambda
//        UnaryOperator<String> lambdaStringFunction = (String s) -> {
//            StringBuilder returnValue = new StringBuilder();
//            for (int i = 0; i < s.length(); i++) {
//                if (i % 2 == 1) {
//                    returnValue.append(s.charAt(i));
//                }
//            }
//            return returnValue.toString();
//        };
//        System.out.println(lambdaStringFunction.apply("1234567890"));
//        System.out.println(everySecondCharacter(lambdaStringFunction,"1234567890"));

//        Supplier<String> iLoveJava = () -> "I love Java!!";
//        String supplierResult = iLoveJava.get();
//        System.out.println(supplierResult);

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

//        List<String> firstUpperCaseList = new ArrayList<>();
//        topNames2015.forEach((String s) ->
//                firstUpperCaseList.add(s.substring(0, 1).toUpperCase().concat(s.substring(1))));
////        firstUpperCaseList.sort((String s1, String s2) -> s1.compareTo(s2));
//        firstUpperCaseList.sort(String::compareTo);
////        firstUpperCaseList.forEach((String s) -> System.out.println(s));
//        firstUpperCaseList.forEach(System.out::println);

//        topNames2015.stream()
//                .map((String s) -> s.substring(0, 1).toUpperCase().concat(s.substring(1)))
//                .sorted()
//                .forEach((String name) -> System.out.println(name));

//        long nameBeginWithA =
//                topNames2015.stream()
//                        .map((String s) -> s.substring(0, 1).toUpperCase().concat(s.substring(1)))
//                        .filter((String s) -> s.startsWith("A"))
//                        .peek(System.out::println)
//                        .count();
//        System.out.println("Number of names begin with A is :" + nameBeginWithA);

//        List<String> newList =
//                topNames2015.stream()
//                        .map((String s) -> s.substring(0, 1).toUpperCase().concat(s.substring(1)))
//                        .filter((String s) -> s.startsWith("A"))
//                        .peek(System.out::println)
//                        .collect(Collectors.toList());
//        newList.forEach(System.out::println);

        ;


    }

    public static String everySecondChar(String source) {
        StringBuilder returnValue = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnValue.append(source.charAt(i));
            }
        }
        return returnValue.toString();
    }

    public static String everySecondCharacter(UnaryOperator<String> unaryOperator, String text) {
        return unaryOperator.apply(text);
    }

}
