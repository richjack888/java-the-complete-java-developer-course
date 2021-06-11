import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Cookie> hashSet = new HashSet<>();
        HashMap<String, Cookie> hashMap = new HashMap<>();
//        hashSet.add(new Cookie());
//        hashMap.put("gingerbread man", new Cookie());
        HashMap<Cookie, String> anotherHashMap = new HashMap<>();
        //anotherHashMap.put(new Cookie(), "gingerbread man");
    }
}

class Cookie {
    @Override
    public int hashCode() {
        System.out.println("hashCode() called.");
        return super.hashCode();
    }
}