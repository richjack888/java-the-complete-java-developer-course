public class Song {
    private String title;
    private String duration;

    public Song(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    public static Song createSong(String title, String duration) {
        return new Song(title, duration);
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }
}
