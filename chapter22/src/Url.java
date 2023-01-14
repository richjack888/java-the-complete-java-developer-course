import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Url {
    public static void main(String[] args) {

        try {
            URL url = new URL("https://example.org");
//            URL url = new URL("https://example.org/somethin.html");
//            URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=cats");
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("User-Agent", "Chrome");
            httpConnection.setReadTimeout(30000);

            int responseCode = httpConnection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if (responseCode != 200) {
                System.out.println("Error reading web page: " + responseCode);
                System.out.println(httpConnection.getResponseMessage());
                return;
            }

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(httpConnection.getInputStream()));


            String line = "";
            while ((line = reader.readLine()) != null){
                line = reader.readLine();
                System.out.println(line);
            }

            reader.close();


        } catch (ProtocolException e) {
            System.out.println("Protocol error: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }


//        // version 1
//        try {
//            URL url = new URL("https://example.org");
//
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(url.openStream(), StandardCharsets.UTF_8)
//            );
//
//            String line = "";
//            while (line != null) {
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//
//            inputStream.close();
//
//        } catch (IOException e) {
//            System.out.println("IOException: " + e.getMessage());
//        }

    }
}
