package nonBlockingIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class test {
    public static void main(String[] args) {

        Path targetFile = Paths.get("Google.html");

        URI uri = URI.create("https://google.com");

        try (InputStream inputStream = uri.toURL().openStream()) {
            Files.copy(inputStream, targetFile);
        } catch (IOException ex) {
            System.err.format("I/O Error when copying file");
        }
    }
}
