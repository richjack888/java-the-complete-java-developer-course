package nonBlockingIO.path.copyExamples;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
//            Path sourceFile = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples", "file1copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

//            Path sourceFile = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples","Dir1");
//            Path copyFile = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples","Dir4");
//            Files.copy(

//            Path fileToMove = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples", "file1copy.txt");
//            Path destination = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples", "Dir1", "file1copy.txt");
//            Files.move(fileToMove, destination);

//            Path fileToMove = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples", "file1copy.txt");
//            Path destination = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples", "Dir1", "file1copy.txt");
//            Files.move(fileToMove, destination);

//            // rename
//            Path fileToMove = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples", "Dir1", "file1copy.txt");
//            Path destination = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples", "Dir1", "file1copyRename.txt");
//            Files.move(fileToMove, destination);

//            Path fileToDelete = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples", "Dir1", "file1copyRename.txt");
////            Files.delete(fileToDelete);
//            Files.deleteIfExists(fileToDelete);

//            Path fileToCreate = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples", "file2.txt");
//            Files.createFile(fileToCreate);

//            Path dirToCreate = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples", "Dir4");
//            Files.createDirectory(dirToCreate);

//            Path dirToCreate = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples", "Dir2/Dir3/Dir4/Dir5/Dir6");
//            Path dirToCreate = FileSystems.getDefault().getPath("src\\nonBlockingIO\\path\\copyExamples", "Dir2\\Dir3\\Dir4\\Dir5\\Dir6");
            Path dirToCreate = FileSystems.getDefault().getPath("src/nonBlockingIO/path/copyExamples/Dir2/Dir3/Dir4/Dir5/Dir6/Dir7");
            Files.createDirectories(dirToCreate);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
