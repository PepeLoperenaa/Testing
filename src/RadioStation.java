import java.util.HashSet;

public class RadioStation {
    private String name;
    private double frequency;
    private HashSet<Song> songs;

    public RadioStation(String name, double frequency) {
        this.name = name;
        this.frequency = frequency;
        this.songs = new HashSet<>();
    }

    public boolean addSong(Song song) {
        if (song != null) {
            if (!getSongs().contains(song)) {
                getSongs().add(song);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public HashSet<Song> getSongs() {
        return songs;
    }

    public void playSongs() {
        for (Song song :
                this.songs) {
            System.out.println("Now playing " + song.getSongName());
            song.playSong();
        }
    }
}
