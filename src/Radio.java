import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class Radio {
    private boolean status;
    private int volume;
    private HashSet<RadioStation> radioStations;

    public Radio() {
        this.status = false;
        this.volume = 0;
        this.radioStations = new HashSet<>();
    }

    /**
     * Sets the frequency of the radio. Used to change between stations
     *
     * @param freq cannot be lower than 80 an cannot be higher than 120
     */
    public void setFrequency(double freq) {
        if (isStatus()) {
            if ((freq <= 80.0 || freq >= 120) && isStatus()) {
                System.out.println("The frequency cannot be found");
                playStatic();
            } else {
                if (this.radioStations.size() <= 0) {
                    System.out.println("No radioStations were added to hashSet");
                    playStatic();
                } else {
                    int count = 0;
                    for (RadioStation radioStation :
                            getRadioStations()) {
                        if (radioStation.getFrequency() == freq) {
                            radioStation.playSongs();
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("No radio station found on that frequency");
                        playStatic();
                    }
                }

            }
        } else {
            System.out.println("Radio is off");
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

    /**
     * Sets the volume of the radio. Range can only be between 0 and 20.
     * @param volume volume of the radio
     */
    public void setVolume(int volume) {
        if (isStatus()) {
            if (volume > 20) {
                System.out.println("sorry you have reached the maximum volume");
            } else {
                this.volume = volume;
            }
        } else {
            System.out.println("Radio is off");
        }
    }

    public void addRadioStations(RadioStation r) {
        this.radioStations.add(r);
    }

    public HashSet<RadioStation> getRadioStations() {
        return radioStations;
    }

    public void addRadioStation(RadioStation r) {
        radioStations.add(r);
    }

    /**
     * Method which plays static sound. Helping method for other methods.
     */
    public void playStatic() {
        try {
            File staticFile = new File("songs/static.wav"); //need a static file if a frequency cant be found.
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
        System.out.println("static sound");
    }

    /**
     * Turns On or Off the radio depending on the status it is in.
     */
    public void turnOnOff() {
        if (isStatus()) {
            setStatus(false);
        } else if (!isStatus()) {
            setStatus(true);
        }
    }
}
