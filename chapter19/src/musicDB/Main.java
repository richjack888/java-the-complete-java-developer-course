package musicDB;


import musicDB.model.Artist;
import musicDB.model.Datasource;

import javax.swing.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Datasource dataSource = new Datasource();
        if (!dataSource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        List<Artist> artists = dataSource.queryArtists(Datasource.SortOrder.ORDER_BY_ASC);
        if (artists == null) {
            System.out.println("No artists!");
            return;
        }

        for (Artist artist : artists) {
//            System.out.println(artist);
        }

        List<String> albumsForArtist = dataSource.queryAlbumsForArtist("Iron Maiden", Datasource.SortOrder.ORDER_BY_ASC);

        for (String album : albumsForArtist) {
            System.out.println(album);
        }

        dataSource.close();


    }
}
