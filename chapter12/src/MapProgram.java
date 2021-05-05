import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        if (languages.containsKey("Java")) {
            System.out.println("Java already exists");
        } else {
            languages.put("Java", " a compiled high level, object-oriented, platform independent language.");
            System.out.println("Java added successfully");
        }
        languages.put("Python", " an interpreted, object-oriented, high-level programming language.");
        languages.put("Algol", " an algorithmic language");
        languages.put("BASIC", " Beginners All Purposes Symbolic Instruction Code.");
        languages.put("Lisp", " Therein lies madness");

        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the map.");
        } else {
            System.out.println(languages.put("Java", " this course is about Java"));
        }

    }
}
