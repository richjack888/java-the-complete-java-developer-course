import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int REPEAT_TIMES = 10;
    private static final String REPEAT_CONTENT = "I'm test robot. ";
    private static final String FILE_NAME = "writeSpeedTest.txt";

    private static long startTime;
    private static long endTime;
    private static long writeTime;
    private static long writeBufferTime;

    public static void main(String[] args) throws IOException {

        List<String> texts = new ArrayList<>(REPEAT_TIMES);

        for (int i = 1; i <= REPEAT_TIMES; i++) {
            texts.add(i + ", " + REPEAT_CONTENT.repeat(6) + "\n");
        }

        for (int i = 1; i <= 3; i++) {
            System.out.println("Round " + i);
            write(texts);
            writeBuffered(texts);
            System.out.println();
        }

        resultPrint();

    }


    private static void write(List<String> texts) {

        startTime = System.currentTimeMillis();

        try (FileWriter fileWriter = new FileWriter(FILE_NAME)) {
            for (String text : texts) {
                fileWriter.write(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        endTime = System.currentTimeMillis();
        System.out.println("    write time: " + (endTime - startTime) / 1000f + " sec ");
        writeTime += (endTime - startTime);
    }


    private static void writeBuffered(List<String> texts) {

        startTime = System.currentTimeMillis();

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String text : texts) {
                fileWriter.write(text);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        endTime = System.currentTimeMillis();
        System.out.println("    writeBuffered time: " + (endTime - startTime) / 1000f + " sec ");
        writeBufferTime += (endTime - startTime);
    }


    private static void resultPrint() {

        File f = new File(FILE_NAME);
        long fileSize = f.length();
        System.out.format("The size of the texts file is %d MB.\n\n", (fileSize / 1000000));

        System.out.println("writeTime: " + writeTime / 1000f + " sec\nwriteBufferTime: " + writeBufferTime / 1000f + " sec");
        if (writeTime < writeBufferTime) {
            System.out.println("write is fast !");
        } else {
            System.out.println("writeBuffer is fast !!");
        }
    }
}






