package nonBlockingIO.path.copyExamples;

import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class SeparatorsAndTemp {

    public static void main(String[] args) {

//        String separator = File.separator;
//        System.out.println(separator);
//
//        separator = FileSystems.getDefault().getSeparator();
//        System.out.println(separator);
//
//        try {
//            Path tempFile = Files.createTempFile("myapp", "appext");
//            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store : stores) {
            System.out.println("Volume name / Drive letter = " + store);
            System.out.println("file store = " + store.name());
        }

        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for(Path path:rootPaths){
            System.out.println(path);
        }


    }


}
