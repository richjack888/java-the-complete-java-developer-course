package nonBlockingIO.path.copyExamples;

import java.io.IOException;
import java.nio.file.*;

public class ReadDirectory {
    public static void main(String[] args) {
        Path directory = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples/Dir2");
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory)) {
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }
    }
}
