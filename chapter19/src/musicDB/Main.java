package musicDB;


import musicDB.model.Artist;
import musicDB.model.Datasource;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Datasource dataSource = new Datasource();
        if (!dataSource.open()) {
            System.out.println("Can't open datasource");
            return;
        }
        List<Artist> artists = dataSource.queryArtists();
        if (artists == null) {
            System.out.println("No artists!");
            return;
        }

        for (Artist artist : artists) {
            System.out.println(artist);
        }

        dataSource.close();


    }
}
