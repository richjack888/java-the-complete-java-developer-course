package nonBlockingIO.path.copyExamples;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
            Path sourceFile = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples", "file1.txt");
            Path copyFile = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples", "file1copy.txt");
            Files.copy(sourceFile, copyFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
