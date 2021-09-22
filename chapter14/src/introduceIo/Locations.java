package introduceIo;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {

////        try (FileWriter file = new FileWriter("src/introduceIo/locations.txt");
//        try (FileWriter file = new FileWriter("src/introduceIo/locations_big.txt");
////             FileWriter dirFile = new FileWriter("src/introduceIo/directions.txt")) {
//             FileWriter dirFile = new FileWriter("src/introduceIo/directions_big.txt")) {
//            for (Location location : locations.values()) {
//                file.write(location.getLocationID() + ", " + location.getDescription() + "\n");
//                for (String direction : location.getExits().keySet()) {
//                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
//                }
//            }
//
//        }

        // version 2
        try (BufferedWriter file = new BufferedWriter(new FileWriter("src/introduceIo/locations_big.txt"));
             BufferedWriter dirFile = new BufferedWriter(new FileWriter("src/introduceIo/directions_big.txt"))) {
            for (Location location : locations.values()) {
                file.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for (String direction : location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
//                    if (!direction.equalsIgnoreCase("Q")) {
//                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
//                    }
                }
            }
        }


        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("src/introduceIo/locations.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription());
                System.out.println("Writing location " + location.getLocationID() + " : " + location.getDescription());
                ;
                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");
                locFile.writeInt(location.getExits().size() - 1);
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" + direction + "," + location.getExits().get(direction));
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }
    }

    static {

//         read locations.txt

////         version 1
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new FileReader("src/introduceIo/locations_big.txt"));
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
//        try (Scanner scanner = new Scanner(new FileReader("src/introduceIo/locations_big.txt"))) {
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
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/introduceIo/locations_big.txt")))) {
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

//        // version 1
//        Scanner dirScanner = null;
//        try {
//            dirScanner = new Scanner(new FileReader("src/introduceIo/directions.txt"));
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

        //        // version1 with tyr-with-resources.
//        try (Scanner scanner = new Scanner(new FileReader("src/introduceIo/directions_big.txt"));
//        ) {
//            scanner.useDelimiter(",");
//            while (scanner.hasNext()) {
//                int dirInt = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String dirDescription = scanner.next();
//                scanner.skip(scanner.delimiter());
//                String locationIdStr = scanner.nextLine();
//                int locationIdInt = Integer.parseInt(locationIdStr);
//                locations.get(dirInt).addExit(dirDescription, locationIdInt);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        // version2
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
//            scanner = new Scanner(new BufferedReader(new FileReader("src/introduceIo/directions_big.txt")));
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

//         version 4 with try-with-resources
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/introduceIo/directions_big.txt")))) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
//                location.addExit("Q", 0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

////        version 4-2 try-with-resources
//        try (BufferedReader dirFile = new BufferedReader(new FileReader("src/introduceIo/directions_big.txt"))) {
//            String input;
//            while ((input = dirFile.readLine())!=null) {
//                String[] data = input.split(",");
//
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


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
