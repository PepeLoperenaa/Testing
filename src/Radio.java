import javax.print.attribute.standard.Media;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class Radio {
    private boolean status;
    private int volume;
    private HashSet<RadioStation> radioStations;
    private final String staticSound = "example.wav";

    public Radio() {
        this.status = false;
        this.volume = 0;
        this.radioStations = new HashSet<>();
    }

    /**
     * Sets the frequency of the radio. Used to change between stations
     * @param freq cannot be lower than 80 an cannot be higher than 120
     */
    public void setFrequency(double freq) {
        if ((freq <= 80.0 || freq >= 120) && isStatus()) {
            System.out.println("The frequency cannot be found");
            playStatic();
        } else {
            if (this.radioStations.size() <= 0) {
                System.out.println("No radioStations were added to hashSet");
                playStatic();
            } else {
                int count=0;
                for (RadioStation radioStation :
                        getRadioStations()) {
                    if (radioStation.getFrequency() == freq) {
                        radioStation.playSongs();
                        count++;
                    }
                }
                if(count==0){
                    System.out.println("No radio station found on that frequency");
                    playStatic();
                }
            }

        }
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
        if (volume > 20) {
            System.out.println("sorry you have reached the maximum volume");
        } else {
            this.volume = volume;

        }
    }

    public void addRadioStations(RadioStation r) {
        this.radioStations.add(r);
    }

    public HashSet<RadioStation> getRadioStations() {
        return radioStations;
    }

    public String getStaticSound() {
        return staticSound; //name of the file or what file it is.
    }

    public void addRadioStation(RadioStation r) {
        radioStations.add(r);
    }

    public void playStatic() {
        try {
            File staticFile = new File("songs/example.wav"); //need a static file if a frequency cant be found.
            AudioInputStream ais = AudioSystem.getAudioInputStream(staticFile);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.setFramePosition(0);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (InterruptedException exc) {
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

    }

    public boolean turnOnOff() {
        if (isStatus()) { //does this way actually works or does it need to be changed?
            setStatus(false);
        } else if (!isStatus()) {
            setStatus(true);
        }
        return isStatus();
    }
}
