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

    public void addsSongs(Song s){
        this.songs.add(s);
    }

    public void playSongs(){
        //play a file song.
        //Same issue as playing the static i cannot make it work
    }
}
