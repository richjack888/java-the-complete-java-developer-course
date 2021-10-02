package introduceIo.randomAccessFile;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        try (RandomAccessFile raf = new RandomAccessFile("src/introduceIo/randomAccessFile/locations_raf.dat", "rwd")) {
            raf.writeInt(locations.size());
            int indexSize = locations.size() * 3 * Integer.BYTES;
            int locationStart = (int) (indexSize + raf.getFilePointer() + Integer.BYTES);
            raf.writeInt(locationStart);

            long indexStart = raf.getFilePointer();

            int startPointer = locationStart;
            raf.seek(startPointer);

            for (Location location : locations.values()) {
                raf.writeInt(location.getLocationID());
                raf.writeUTF(location.getDescription());
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

                IndexRecord record = new IndexRecord(startPointer, (int) (raf.getFilePointer() - startPointer));
                index.put(location.getLocationID(), record);

                startPointer = (int) raf.getFilePointer();

            }

            raf.seek(indexStart);
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
                    System.out.println("EOF exception " + e.getMessage());
                }
            }

        } catch (InvalidClassException e) {
            System.out.println("InvalidClassException " + e.getMessage());
        } catch (IOException io) {
            System.out.println("IO exception " + io.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e.getMessage());
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
