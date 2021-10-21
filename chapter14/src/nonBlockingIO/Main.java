package nonBlockingIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {
    public static void main(String[] args) {

//        try {
//            Path dataPath = Paths.get("src/nonBlockingIO/data.txt");
//            Files.write(dataPath, "\nLine 4".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
//            List<String> lines = Files.readAllLines(dataPath);
//            for (String line : lines) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        try (FileOutputStream binFile = new FileOutputStream("src/nonBlockingIO/data.dat");
             FileChannel binChannel = binFile.getChannel()) {
            byte[] outputBytes = "Hello World!".getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            int numBytes = binChannel.write(buffer);
            System.out.println("numBytes written was: " + numBytes);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(123);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            intBuffer.flip();
            intBuffer.putInt(-789);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            // read from IO
//            RandomAccessFile randomAccessFile = new RandomAccessFile("src/nonBlockingIO/data.dat", "rwd");
//
//            byte[] b = new byte[outputBytes.length];
//            randomAccessFile.read(b);
//            System.out.println(new String(b));
//
//            long int1 = randomAccessFile.readInt();
//            long int2 = randomAccessFile.readInt();
//            System.out.println(int1);
//            System.out.println(int2);


            // read from NIO
            RandomAccessFile randomAccessFile = new RandomAccessFile("src/nonBlockingIO/data.dat", "rwd");
            FileChannel channel = randomAccessFile.getChannel();
            long numBytesRead = channel.read(buffer);
            outputBytes[0] = 'a';
            outputBytes[1] = 'b';
            System.out.println("outputBytes = " + new String(outputBytes));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
