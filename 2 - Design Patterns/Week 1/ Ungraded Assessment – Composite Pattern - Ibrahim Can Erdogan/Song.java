public class Song implements IComponent {

    public String songName;
    public String songArtist;
    public float songSpeed;

    public Song(String songName, String songArtist, float songSpeed) {
        this.songName = songName;
        this.songArtist = songArtist;
        this.songSpeed =  songSpeed;
    }

    public void setPlaybackSpeed(float speed) {
        this.songSpeed = speed;
    }

    public String getName() {
        return this.songName;
    }

    public String getArtist() {
        return this.songArtist;
    }

    public void play() {
        // Play Song
    }
}
