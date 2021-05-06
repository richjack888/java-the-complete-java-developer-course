import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();

        languages.put("Java", " a compiled high level, object-oriented, platform independent language.");
        languages.put("Python", " an interpreted, object-oriented, high-level programming language.");
        languages.put("Algol", " an algorithmic language");
        languages.put("BASIC", " Beginners All Purposes Symbolic Instruction Code.");
        languages.put("Lisp", " Therein lies madness");

        if (languages.replace("Lisp", " Therein lies madness", "a functional programming language with imperative features.")) {
            System.out.println("List replace");
        } else {
            System.out.println("Lisp was not replaced");
        }

        for (String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }

    }
}
