package musicDB;


import musicDB.model.Artist;
import musicDB.model.Datasource;
import musicDB.model.SongArtist;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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
//
//        for (Artist artist : artists) {
//            System.out.println(artist);
//        }
//
//        List<String> albumsForArtist = dataSource.queryAlbumsForArtist("Carole King", Datasource.SortOrder.ORDER_BY_ASC);
//
//        for (String album : albumsForArtist) {
//            System.out.println(album);
//        }
//
//        List<SongArtist> songArtists = dataSource.queryArtistsForSong("go Your Own Way", Datasource.SortOrder.ORDER_BY_ASC);
//
//        if (songArtists == null) {
//            System.out.println("Couldn't find the artist for the song");
//            return;
//        }
//
//        for (SongArtist artist : songArtists) {
//            System.out.println(artist);
//        }
//
//        dataSource.querySongsMetadata();
//        int count = dataSource.getCount(Datasource.TABLE_SONGS);
//        System.out.println("Number of songs is: " + count);
//
//        dataSource.createViewForSongArtists();

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a song title to search: ");
//        String title = scanner.nextLine();
//
//        List<SongArtist> songArtists2 = dataSource.querySongInfoView(title);
//        if (songArtists2.isEmpty()) {
//            System.out.println("Couldn't find the artist for the song");
//            return;
//        }
//
//        for (SongArtist artist : songArtists2) {
//            System.out.println("FROM VIEW - " + artist);
//        }

        dataSource.insertSong("Bird Dog", "Everyly Brothers", "All-Time Greatest Hits", 7);
        dataSource.close();

    }
}
