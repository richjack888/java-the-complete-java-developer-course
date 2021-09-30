package introduceIo.loadBigLocation;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {

        try (BufferedWriter file = new BufferedWriter(new FileWriter("src/introduceIo/loadBigLocation/locations_big.txt"));
             BufferedWriter dirFile = new BufferedWriter(new FileWriter("src/introduceIo/loadBigLocation/directions_big.txt"))) {
            for (Location location : locations.values()) {
                file.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                    if (!direction.equalsIgnoreCase("Q")) {
                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                    }
                }
            }
        }
    }

    static {

//         read locations.txt
//        version 2 with try-with-resources
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/introduceIo/loadBigLocation/locations_big.txt")))) {
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
//        try {
//            scanner = new Scanner(new BufferedReader(new FileReader("src/introduceIo/directions.txt")));
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String direction = scanner.next();
//                scanner.skip(scanner.delimiter());
//                String dest = scanner.next();
//                int destination = Integer.parseInt(dest);
//                System.out.println(loc + ": " + direction + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (scanner != null) {
//                scanner.close();
//            }
//        }

//         // version3
//        Scanner scanner = null;
//        try {
////            scanner = new Scanner(new BufferedReader(new FileReader("src/introduceIo/directions.txt")));
//            scanner = new Scanner(new BufferedReader(new FileReader("src/introduceIo/loadBigLocation/directions_big.txt")));
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//                String input = scanner.nextLine();
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (scanner != null) {
//                scanner.close();
//            }
//        }

////         version 4 with try-with-resources
//        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/introduceIo/loadBigLocation/directions_big.txt")))) {
//            while (scanner.hasNextLine()) {
//                String input = scanner.nextLine();
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
////                location.addExit("Q", 0);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        version 4-2 try-with-resources
        try (BufferedReader dirFile = new BufferedReader(new FileReader("src/introduceIo/loadBigLocation/directions_big.txt"))) {
            String input;
            while ((input = dirFile.readLine())!=null) {
                String[] data = input.split(",");

                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);

                Location location = locations.get(loc);
                location.addExit(direction, destination);
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
