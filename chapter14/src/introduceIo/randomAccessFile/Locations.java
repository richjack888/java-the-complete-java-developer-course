package introduceIo.randomAccessFile;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile raIn;

    public static void main(String[] args) throws IOException {

        try (RandomAccessFile raOut = new RandomAccessFile("src/introduceIo/randomAccessFile/locations_raf.dat", "rwd")) {

            // The whole contents were consisted of  A part, B part, C part, data of locations.
            // A part 0 ~ 3 byte
            // B part 4 ~ 7 byte
            // C part 8 ~ 1699 bytes
            // data of locations 1700 ~ end

            // A part - total number of locations which is 141
            raOut.writeInt(locations.size());

            // B part - start place of location's data, which is after A + B + C part
            int indexSize = locations.size() * 3 * Integer.BYTES; // length of C part
            int locationStart = (int) (indexSize + raOut.getFilePointer() + Integer.BYTES); // length of A + B + C part
            System.out.println("locationStart: " + locationStart + ", which is the place of location's data start.");
            raOut.writeInt(locationStart);

            // record place of C part start
            long indexStart = raOut.getFilePointer();
            System.out.println("indexStart " + indexStart + ", which is the place of C part start.");

            // measure every location's length and write all location's data
            int startPointer = locationStart;
            raOut.seek(startPointer); // jump to place of location's data start

            for (Location location : locations.values()) {
                raOut.writeInt(location.getLocationID());
                raOut.writeUTF(location.getDescription());

                // retrieve Map of exits data (Map<String, Integer> exits)
                StringBuilder stringBuilder = new StringBuilder();
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        stringBuilder.append(direction); // get exits key
                        stringBuilder.append(",");
                        stringBuilder.append(location.getExits().get(direction)); // get exits value
                        stringBuilder.append(",");
                        // would like W,2,E,3,S,1,....
                    }
                }
                raOut.writeUTF(stringBuilder.toString());

                // calculate each of location length
                int length = (int) (raOut.getFilePointer() - startPointer); // end of location - start of location
                IndexRecord record = new IndexRecord(startPointer, length);

                index.put(location.getLocationID(), record);  // put result to index map, so later C part could use it
                startPointer = (int) raOut.getFilePointer(); // when current location was recorded, move pointer to the end of current location
            }

            // C part - index of location
            raOut.seek(indexStart); // back to C part start
            for (Integer locationID : index.keySet()) {
                raOut.writeInt(locationID);
                raOut.writeInt(index.get(locationID).getStartByte());
                raOut.writeInt(index.get(locationID).getLength());
            }
        }
    }

    static {
        try {
            raIn = new RandomAccessFile("src/introduceIo/randomAccessFile/locations_raf.dat", "rwd");
            int numLocations = raIn.readInt();
            long locationStart = raIn.readInt();

            while (raIn.getFilePointer() < locationStart) {
                int locationID = raIn.readInt();
                int locationsStart = raIn.readInt();
                int locationsLength = raIn.readInt();

                IndexRecord record = new IndexRecord(locationsStart, locationsLength);
                index.put(locationID, record);
            }


        } catch (IOException e) {
            System.out.println("IOException in static initializer " + e.getMessage());
        }

    }

    public Location getLocation(int locationID) throws IOException {
        IndexRecord record = index.get(locationID);
        raIn.seek(record.getStartByte());
        int id = raIn.readInt();
        String description = raIn.readUTF();
        String exits = raIn.readUTF();
        String[] exitPart = exits.split(",");

        Location location = new Location(id, description, null);

        if (locationID != 0) {
            for (int i = 0; i < exitPart.length; i++) {
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }
        return location;
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

    public void close() throws IOException {
        raIn.close();
    }

}
