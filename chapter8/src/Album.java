import java.util.ArrayList;

public class Album {
    private String name;
    private ArrayList<Song> albums;

    public Album(String name) {
        this.name = name;
        albums = new ArrayList<Song>();
    }

    public static Album createAlbum(String name) {
        return new Album(name);
    }

    public String getName() {
        return name;
    }

    public void addSong(String title, String duration) {
        albums.add(Song.createSong(title, duration));
    }

    public void printSongs() {
        System.out.println("The song of Album: ");
        for (Song s : albums) {
            System.out.println("No." + (albums.indexOf(s) + 1) + " song is " + s.getTitle() + " duration is " + s.getDuration());
        }
    }

    public void printAlbums(boolean b) {
    }
}
