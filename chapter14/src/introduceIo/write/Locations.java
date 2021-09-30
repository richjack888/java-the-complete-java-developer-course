package introduceIo.write;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {

        try (FileWriter file = new FileWriter("src/introduceIo/write/locations.txt");
             FileWriter dirFile = new FileWriter("src/introduceIo/write/directions.txt")) {
            for (Location location : locations.values()) {
                file.write(location.getLocationID() + ", " + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }

        }

    }

    static {

//         read locations.txt
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new FileReader("src/introduceIo/write/locations.txt"));
//            scanner.useDelimiter(",");
//            while (scanner.hasNext()) {
//                int locInt = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(locInt, new Location(locInt, description, tempExit));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (scanner != null) {
//                scanner.close();
//            }
//        }

//      try-with-resources
        try (Scanner scanner = new Scanner(new FileReader("src/introduceIo/write/locations.txt"))) {
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                int locInt = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(locInt, new Location(locInt, description, tempExit));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//         read directions.txt

//        Scanner dirScanner = null;
//        try {
//            dirScanner = new Scanner(new FileReader("src/introduceIo/write/directions.txt"));
//            dirScanner.useDelimiter(",");
//            while (dirScanner.hasNext()) {
//                int dirInt = dirScanner.nextInt();
//                dirScanner.skip(dirScanner.delimiter());
//                String dirDescription = dirScanner.next();
//                dirScanner.skip(dirScanner.delimiter());
//                String locationIdStr = dirScanner.nextLine();
//                int locationIdInt = Integer.parseInt(locationIdStr);
//                locations.get(dirInt).addExit(dirDescription,locationIdInt );
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (dirScanner != null) {
//                dirScanner.close();
//                ;
//            }
//        }

        // tyr-with-resources.
        try (Scanner scanner = new Scanner(new FileReader("src/introduceIo/write/directions.txt"));
        ) {
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                int dirInt = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String dirDescription = scanner.next();
                scanner.skip(scanner.delimiter());
                String locationIdStr = scanner.nextLine();
                int locationIdInt = Integer.parseInt(locationIdStr);
                locations.get(dirInt).addExit(dirDescription, locationIdInt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//      //  before FileWriter
//        Map<String, Integer> tempExit = new HashMap<String, Integer>();
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", null));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 5);
//        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("S", 1);
//        tempExit.put("W", 2);
//        locations.put(5, new Location(5, "You are in the forest", tempExit));

    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
