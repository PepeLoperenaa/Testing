import java.util.HashSet;

public class Radio {
    private boolean status;
    private int volume;
    private double frequency;
    private HashSet<RadioStation> radioStations;
    private String StaticSound;

    public Radio() {
        this.status = false;
        this.volume = 0;
        this.frequency = frequency;
        this.radioStations = new HashSet<>();
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public void addRadioStations(RadioStation r){
        this.radioStations.add(r);
    }

    public HashSet<RadioStation> getRadioStations() {
        return radioStations;
    }

    public String getStaticSound() {
        return StaticSound; //name of the file or what file it is.
    }

    public void setStaticSound(String staticSound) {
        StaticSound = staticSound; //fOpen static sound.
    }

    public void playStatic(){
        //play the static sound. Method that helps others.
    }

    public boolean turnOnOff(){
        return true; //if statement.
    }
}
