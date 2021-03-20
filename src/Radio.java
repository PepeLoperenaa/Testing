import javax.print.attribute.standard.Media;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class Radio {
    private boolean status;
    private int volume;
    private double frequency;
    private HashSet<RadioStation> radioStations;
    private String staticSound;

    public Radio() {
        this.status = false;
        this.volume = 0;
        this.frequency = frequency;
        this.radioStations = new HashSet<>();
        this.staticSound = "static.wav";
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
        if (volume > 20){
            System.out.println("sorry you have reached the maximum volume");
        } else {
            this.volume = volume;
        }
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
        return staticSound; //name of the file or what file it is.
    }

    public void setStaticSound(String staticSound) {
        staticSound = staticSound; //fOpen static sound.
    }

    public void playStatic(){
        try{
            File staticFile = new File("resources/static.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(staticFile);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.setFramePosition(0);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength()/1000);
        } catch (InterruptedException exc) {} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e){
            e.printStackTrace();
        }

    }

    public boolean turnOnOff(){
        if (isStatus()){ //does this way actually works or does it need to be changed?
            setStatus(false);
        } else if (!isStatus()){
            setStatus(true);
        }

        return isStatus();
    }
}
