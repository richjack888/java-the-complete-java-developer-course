package nonBlockingIO.path;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("src/nonBlockingIO/path/workingDirectory.txt");
        printFile(path);
//        Path filePath = FileSystems.getDefault().getPath("src/nonBlockingIO/path/files","files.txt");
        Path filePath = FileSystems.getDefault().getPath("src/nonBlockingIO/path/files/files.txt");
        printFile(filePath);

        filePath = Paths.get("C:\\software\\JetBrains\\IdeaProjects\\java-the-complete-java-developer-course\\outFileFromChapter14.txt");
        printFile(filePath);
    }

    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
