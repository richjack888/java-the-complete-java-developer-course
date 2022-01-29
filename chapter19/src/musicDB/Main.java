package musicDB;


import musicDB.model.Artist;
import musicDB.model.Datasource;
import musicDB.model.SongArtist;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Datasource dataSource = new Datasource();
        if (!dataSource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

//        List<Artist> artists = dataSource.queryArtists(Datasource.SortOrder.ORDER_BY_ASC);
//        if (artists == null) {
//            System.out.println("No artists!");
//            return;
//        }

//        for (Artist artist : artists) {
//            System.out.println(artist);
//        }

//        List<String> albumsForArtist = dataSource.queryAlbumsForArtist("Carole King", Datasource.SortOrder.ORDER_BY_ASC);

//        for (String album : albumsForArtist) {
//            System.out.println(album);
//        }

        List<SongArtist> songArtists = dataSource.queryArtistsForSong("Heartless", Datasource.SortOrder.ORDER_BY_ASC);

        if (songArtists == null) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for (SongArtist artist : songArtists) {
            System.out.println(artist);
        }

        dataSource.close();


    }
}
