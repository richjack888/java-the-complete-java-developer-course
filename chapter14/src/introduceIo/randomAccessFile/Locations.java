package introduceIo.randomAccessFile;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        try (RandomAccessFile raf = new RandomAccessFile("src/introduceIo/randomAccessFile/locations_raf.dat", "rwd")) {

            // The whole contents were made of  A part, B part, C part, data of locations.
            // A part 0 ~ 3 byte
            // B part 4 ~ 7 byte
            // C part 8 ~ 1699 bytes
            // data of locations 1700 ~ end

            // A part - total number of locations which is 141
            raf.writeInt(locations.size());

            // B part - start place of location data, which is after A + B + C part
            int indexSize = locations.size() * 3 * Integer.BYTES; // length of C part
            int locationStart = (int) (indexSize + raf.getFilePointer() + Integer.BYTES); // length of A + B + C part
            raf.writeInt(locationStart);

            // record place of C part start
            long indexStart = raf.getFilePointer();
            System.out.println("index Start: "  + indexStart + ", which is the place of C part start.");

            // measure every location's length and write all data of locations
            int startPointer = locationStart;
            System.out.println("start pointer: " + startPointer + ", which is the place of location data start.");
            raf.seek(startPointer); // jump to place of location data start

            for (Location location : locations.values()) {
                raf.writeInt(location.getLocationID());
                raf.writeUTF(location.getDescription());

                // retrieve Map of exits data (Map<String, Integer> exits)
                StringBuilder stringBuilder = new StringBuilder();
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        stringBuilder.append(direction);
                        stringBuilder.append(",");
                        stringBuilder.append(location.getExits().get(direction));
                        stringBuilder.append(",");
                    }
                }
                raf.writeUTF(stringBuilder.toString());

                // calculate each of location length
                int length = (int) (raf.getFilePointer() - startPointer);
                IndexRecord record = new IndexRecord(startPointer, length);

                index.put(location.getLocationID(), record);  // put result to index map, so later C part could use it
                startPointer = (int) raf.getFilePointer(); // when current location was recorded, move pointer to the end
            }

            // C part - index of location
            raf.seek(indexStart); // back to C part start
            for (Integer locationID : index.keySet()) {
                raf.writeInt(locationID);
                raf.writeInt(index.get(locationID).getStartByte());
                raf.writeInt(index.get(locationID).getLength());
            }
        }
    }

    static {

        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/introduceIo/randomAccessFile/locations.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
                    System.out.println("Found " + location.getExits().size() + " exits");

                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                    System.out.println("EOF exception: " + e.getMessage());
                }
            }

        } catch (InvalidClassException e) {
            System.out.println("InvalidClassException: " + e.getMessage());
        } catch (IOException io) {
            System.out.println("IO exception: " + io.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
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
