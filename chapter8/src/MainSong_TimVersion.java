import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MainSong_TimVersion {

    private static ArrayList<Album_TimVersion> albums = new ArrayList<Album_TimVersion>();

    public static void main(String[] args) {

        Album_TimVersion album = new Album_TimVersion("Alphabet song", "Elementary Bang");
        album.addSong("AAA", 111);
        album.addSong("BBB", 222);
        album.addSong("CCC", 333);
        album.addSong("DDD", 444);
        album.addSong("EEE", 555);
        albums.add(album);

        album = new Album_TimVersion("Number song", "Kindergarten Bang");
        album.addSong("111", 666);
        album.addSong("222", 777);
        album.addSong("333", 888);
        album.addSong("444", 999);
        album.addSong("555", 1000);
        albums.add(album);

        LinkedList<Song_TimVersion> playlist = new LinkedList<Song_TimVersion>();
        albums.get(0).addToPlaylist(1, playlist);
        albums.get(0).addToPlaylist(6, playlist); // not exist
        albums.get(0).addToPlaylist("BBB", playlist);
        albums.get(0).addToPlaylist("FFF", playlist); // not exist

        albums.get(1).addToPlaylist(1, playlist);
        albums.get(1).addToPlaylist(6, playlist); // not exist
        albums.get(1).addToPlaylist("222", playlist);
        albums.get(1).addToPlaylist("666", playlist); // not exist

        play(playlist);

    }

    private static void play(LinkedList<Song_TimVersion> playlist) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song_TimVersion> listIterator = playlist.listIterator();
        if (playlist.size() > 0) {
            System.out.println("Now playing " + listIterator.next().toString());
        } else {
            System.out.println("No songs in play list.");
        }

        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("System out!");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We are reached the end of play list.");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of play list.");
                        forward = true;
                    }
                    break;
                case 3:
                    break;
                case 4:
//                    printList(playList);
                    break;
                case 5:
//                    printMenu();
                    break;
            }

        }
    }


}
