import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

// produce by chatGPT
public class WebCrawler {
    public static void main(String[] args) throws IOException {
        // URL to crawl
//        String url = "https://example.org";
        String url = "https://www.nou.edu.tw/";
//        String url = "https://www.youtube.com/watch?v=21_MOqwsExw&list=PLX_DtVBp2wNJMW0H-JeWPk71Wl2AszFZs&index=109";

        // Connect to the website and get the HTML
        Document doc = Jsoup.connect(url).get();

        // Print the text of the webpage
//        System.out.println(doc.text());

        System.out.println(doc.text());
    }
}