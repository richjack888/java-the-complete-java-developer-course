package introduceIo.fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {

        try (FileWriter file = new FileWriter("src/introduceIo/fileReader/locations.txt");
             FileWriter dirFile = new FileWriter("src/introduceIo/fileReader/directions.txt")) {
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
////         version 1
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new FileReader("src/introduceIo/fileReader/locations.txt"));
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

////         version 1 try-with-resources
//        try (Scanner scanner = new Scanner(new FileReader("src/introduceIo/fileReader/locations.txt"))) {
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
//        }

//        version 2 with try-with-resources
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/introduceIo/fileReader/locations.txt")))) {
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
//        System.out.println("read directions");

//        // version 1
//        Scanner dirScanner = null;
//        try {
//            dirScanner = new Scanner(new FileReader("src/introduceIo/fileReader/directions.txt"));
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

                // version1 with tyr-with-resources.
        try (Scanner scanner = new Scanner(new FileReader("src/introduceIo/fileReader/directions.txt"));
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
