public class Song_TimVersion {

    private String title;
    private int duration;

    public Song_TimVersion(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public static Song_TimVersion CreateSong(String title, int duration) {
        return new Song_TimVersion(title, duration);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        int hour = duration / 60 / 60;
        int min = (duration - (hour * 60)) / 60;
        int sec = duration - (min * 60);
        return "song title is : '" + title + "' , and duration is " + hour + " H : " + min + " M : " + sec + " S";
    }


}
