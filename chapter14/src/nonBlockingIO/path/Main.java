package nonBlockingIO.path;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

//        Path path = FileSystems.getDefault().getPath("workingDirectory.txt");
//        printFile(path);
//
////      Path filePath = FileSystems.getDefault().getPath("src/nonBlockingIO/path/files","files.txt");
//        path = FileSystems.getDefault().getPath("src/nonBlockingIO/path/files/files.txt");
//        printFile(path);
//
//        path = Paths.get("C:\\software\\JetBrains\\IdeaProjects\\java-the-complete-java-developer-course\\outFileFromChapter14.txt");
//        printFile(path);

//        Path path = Paths.get("./src/nonBlockingIO/path","files", "files.txt");
//        printFile(path);

//        Path path2 = FileSystems.getDefault().getPath(".", "src", "nonBlockingIO", "path", "files", "..", "files", "files.txt");
//        System.out.println(path2.normalize().toAbsolutePath());
//        System.out.println(path2.toAbsolutePath());
//        printFile(path2);

        Path path3 = FileSystems.getDefault().getPath("thisfiledoesntexist.txt");
        System.out.println(path3.toAbsolutePath());

        Path path4 = Paths.get("Z:\\", "abc", "don", "thisfiledoesntexist.txt");
        System.out.println(path4.toAbsolutePath());

        System.out.println("path3 exits = " + Files.exists(path3));
        System.out.println("path4 exits = " + Files.exists(path4));


//        // check working directory path 1
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
//
//        // check working directory path 2
//        Path currentPath = Paths.get("");
//        System.out.println("Working Directory = " + currentPath.toAbsolutePath());


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
