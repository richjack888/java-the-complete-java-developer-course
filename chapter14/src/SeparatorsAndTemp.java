import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

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

//        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
//        for (FileStore store : stores) {
//            System.out.println("Volume name / Drive letter = " + store);
//            System.out.println("file store = " + store.name());
//        }
//
//        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
//        for(Path path:rootPaths){
//            System.out.println(path);
//        }

//        System.out.println("------ Walking Tree for Dir2 ------");
////        Path dir2Path = FileSystems.getDefault().getPath(
////                "src" + File.separator +
////                "nonBlockingIO" + File.separator +
////                "path" + File.separator +
////                "copyExamples" + File.separator +
////                "Dir2");
//
//        // version 2
//        Path dir2Path = FileSystems.getDefault().getPath(String.join(File.separator, "src", "nonBlockingIO", "path", "copyExamples", "Dir2"));
//
//        try {
//            Files.walkFileTree(dir2Path, new PrintNames());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }


//        System.out.println("--- Copy Dir2 to Dir4 / Dir2Copy ---");
////        Path copyPath =  Paths.get(String.join(File.separator, "src", "nonBlockingIO", "path", "copyExamples", "Dir4","Dir2Copy"));
//        Path copyPath = FileSystems.getDefault().getPath(String.join(File.separator, "src", "nonBlockingIO", "path", "copyExamples", "Dir4","Dir2Copy"));
//        // FileTree/Dir4/Dir2Copy
////        Path dir2Path =  Paths.get(String.join(File.separator, "src", "nonBlockingIO", "path", "copyExamples", "Dir2"));
//        Path dir2Path = FileSystems.getDefault().getPath(String.join(File.separator, "src", "nonBlockingIO", "path", "copyExamples", "Dir2"));
//        try{
//            Files.walkFileTree(dir2Path,new CopyFiles(dir2Path,copyPath) );
//        }catch (IOException e){
//            System.out.println(e.getMessage());
//        }


        File file = new File("/Examples/file.txt"); // C:\\Examples\file.txt
        Path convertedPath = file.toPath();
        System.out.println("converted path = " + convertedPath);

        File parent = new File("/Examples");    // C:\\Examples
        File resolvedFile = new File(parent, "dir/file.txt");   // dir\\file.txt
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("/Examples", "dir/file.txt");   // C;\\Examples  dir\\file.txt
        System.out.println(resolvedFile);

        Path parentPath = Paths.get("/Examples");   // C:\\Examples
        Path childRelativePath = Paths.get("dir/file.txt"); // dir\\file.txt
        System.out.println(parentPath.resolve(childRelativePath));

    }


}
