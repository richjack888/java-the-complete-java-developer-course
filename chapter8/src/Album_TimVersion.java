import java.util.ArrayList;
import java.util.LinkedList;

public class Album_TimVersion {

    private String name;
    private String artist;
    private ArrayList<Song_TimVersion> songs;

    public Album_TimVersion(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<Song_TimVersion>();
    }

    public Boolean addSong(String title, int duration) {
        if (findSong(title) == null) {
            songs.add(Song_TimVersion.CreateSong(title, duration));
        }
        return true;
    }

    private Song_TimVersion findSong(String title) {
        for (Song_TimVersion checkSong : songs) {
            if (checkSong.getTitle().equals(title)) {
                return checkSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song_TimVersion> playlist) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index < songs.size())) {
            playlist.add(songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song_TimVersion> playlist) {
        Song_TimVersion song = findSong(title);
        if (song != null) {
            playlist.add(song);
            return true;

        }
        System.out.println("This album does not have song: " + title);
        return false;
    }


}
