import java.util.LinkedList;
import java.util.ListIterator;

public class PlayList {
    private String name;
    private LinkedList<Album> playLists;


    public PlayList(String name) {
        this.name = name;
        playLists = new LinkedList<Album>();

    }

    public static PlayList createPlayList(String name) {
        return new PlayList(name);
    }

    public String getName() {
        return name;
    }

    public LinkedList<Album> getPlayLists() {
        return playLists;
    }

    public void addAlbum(Album album) {
        ListIterator<Album> albumListIterator = playLists.listIterator();

        while (albumListIterator.hasNext()) {
            int comparison = albumListIterator.next().getName().compareTo(album.getName());
            if (comparison == 0) {
                System.out.println("Album - " + album.getName() + " - is already added in play lists");
                return;
            } else if (comparison > 0) {
                albumListIterator.previous();
                albumListIterator.add(album);
                return;
            }
        }
        albumListIterator.add(album);
    }

    public void printAlbums(boolean includesSong) {
        System.out.println("==============================================");
        System.out.println("The list of Album: ");
        for (Album s : playLists) {
            System.out.println("No." + (playLists.indexOf(s) + 1) + " Album is " + s.getName());
            if (includesSong) {
                s.printSongs();
            }
        }
        System.out.println("==============================================");
    }

}
