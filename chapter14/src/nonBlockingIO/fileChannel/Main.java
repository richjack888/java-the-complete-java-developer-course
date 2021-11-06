package nonBlockingIO.fileChannel;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.channels.Pipe.SinkChannel;

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


//        try (FileOutputStream binFile = new FileOutputStream("src/nonBlockingIO/data.dat");
//             FileChannel binChannel = binFile.getChannel()) {
//            byte[] outputBytes = "Hello World!".getBytes();
////            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            buffer.put(outputBytes);
//            buffer.flip();
//            int numBytes = binChannel.write(buffer);
//            System.out.println("numBytes written was: " + numBytes);
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(123);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("numBytes written was: " + numBytes);
//
//            intBuffer.flip();
//            intBuffer.putInt(-789);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("numBytes written was: " + numBytes);
//
//            // read from IO
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


//            // read from NIO
//            RandomAccessFile randomAccessFile = new RandomAccessFile("src/nonBlockingIO/data.dat", "rwd");
//            FileChannel channel = randomAccessFile.getChannel();
//            outputBytes[0] = 'a';
//            outputBytes[1] = 'b';
//            buffer.flip();
//            long numBytesRead = channel.read(buffer);
//            if (buffer.hasArray()) {
//                System.out.println("outputBytes = " + new String(buffer.array()));
//            }

//            // Relative read
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());

//            // Absolute read
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt(0));
//            System.out.println(intBuffer.getInt());
//
//            channel.close();
//            randomAccessFile.close();

//        // write part
//        try (FileOutputStream binFile = new FileOutputStream("src/nonBlockingIO/data.dat");
//             FileChannel binChannel = binFile.getChannel()) {
//            ByteBuffer buffer = ByteBuffer.allocate(100);

//            // unchain
//            byte[] outputBytes = "Hello World!".getBytes();
//            buffer.put(outputBytes);
//            buffer.putInt(111);
//            buffer.putInt(-222);
//            byte[] outputByte2 = "Go away!".getBytes();
//            buffer.put(outputByte2);
//            buffer.putInt(666);
//            buffer.putInt(-777);
//            buffer.flip();
//            binChannel.write(buffer);

//            // chain
//            byte[] outputBytes = "Hello World!".getBytes();
//            byte[] outputByte2 = "Go away!".getBytes();
//            buffer.put(outputBytes).putInt(111).putInt(-222).put(outputByte2).putInt(666).putInt(-777);
//            buffer.flip();
//            binChannel.write(buffer);


//            byte[] outputBytes = "Hello World!".getBytes();
//            buffer.put(outputBytes);
//            long int1Pos = outputBytes.length;
//            buffer.putInt(111);
//            long int2Pos = int1Pos + Integer.BYTES;
//            buffer.putInt(-222);
//            byte[] outputByte2 = "Go away!".getBytes();
//            buffer.put(outputByte2);
//            long int3Pos = int2Pos + Integer.BYTES + outputByte2.length;
//            buffer.putInt(666);
//            buffer.flip();
//            binChannel.write(buffer);
//
//
//            // read part
//            RandomAccessFile ra = new RandomAccessFile("src/nonBlockingIO/data.dat", "rwd");
//            FileChannel channel = ra.getChannel();

//            // normal sequence
//            ByteBuffer readBuffer = ByteBuffer.allocate(100);
//            channel.read(readBuffer);
//            readBuffer.flip();
//
//            byte[] inputString = new byte[outputBytes.length];
//            readBuffer.get(inputString);
//            System.out.println("inputString = " + new String(inputString));
//            System.out.println("int1 = " + readBuffer.getInt());
//            System.out.println("int2 = " + readBuffer.getInt());
//            byte[] inputString2 = new byte[outputByte2.length];
//            readBuffer.get(inputString2);
//            System.out.println("inputString2 = " + new String(inputString2));
//            System.out.println("int3 = " + readBuffer.getInt());

//            // backward sequence
//
//            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
//            channel.position(int3Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int3 = " + readBuffer.getInt());
//
//            readBuffer.flip();
//            channel.position(int2Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int2 = " + readBuffer.getInt());
//
//            readBuffer.flip();
//            channel.position(int1Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            System.out.println("int1 = " + readBuffer.getInt());
//
//            RandomAccessFile copyFile = new RandomAccessFile("src/nonBlockingIO/dataCopy.dat", "rw");
//            FileChannel copyChannel = copyFile.getChannel();
////            channel.position(0);
////            long numTransferred = copyChannel.transferFrom(channel, 0, channel.size());
//            long numTransferred = copyChannel.transferTo(0, channel.size(), copyChannel);
//            System.out.println("Num transferred = " + numTransferred);
//
//            channel.close();
//            ra.close();
//            copyChannel.close();


//            // write int first, then string
//            byte[] outputString = "Hello World!".getBytes();
//            long str1Pos = 0;
//            long newInt1Pos = outputString.length;
//            long newInt2Pos = newInt1Pos + Integer.BYTES;
//            byte[] outputString2 = "Go away!".getBytes();
//            long str2Pos = newInt2Pos + Integer.BYTES;
//            long newInt3Pos = str2Pos + outputString2.length;
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(222);
//            intBuffer.flip();
//            binChannel.position(newInt1Pos);
//            binChannel.write(intBuffer);
//
//            intBuffer.flip();
//            intBuffer.putInt(-987);
//            intBuffer.flip();
//            binChannel.position(newInt2Pos);
//            binChannel.write(intBuffer);
//
//            intBuffer.flip();
//            intBuffer.putInt(10000);
//            intBuffer.flip();
//            binChannel.position(newInt3Pos);
//            binChannel.write(intBuffer);
//
//            binChannel.position(str1Pos);
//            binChannel.write(ByteBuffer.wrap(outputString));
//            binChannel.position(str2Pos);
//            binChannel.write(ByteBuffer.wrap(outputString2));


//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // introduce pipe

        try {
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            String currentTime = "The time is: " + System.currentTimeMillis();

                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while (buffer.hasRemaining()) {
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i = 0; i < 10; i++) {
                            int byteRead = sourceChannel.read(buffer);
                            ;
                            byte[] timeString = new byte[byteRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader Thread: " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}