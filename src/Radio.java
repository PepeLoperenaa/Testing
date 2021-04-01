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
        this.volume = 10;
        this.radioStations = new HashSet<>();
    }

    /**
     * Sets the frequency of the radio. Used to change between stations
     *
     * @param freq cannot be lower than 80 an cannot be higher than 120
     */
    public void setFrequency(double freq) throws FrequencyOutOfScopeException {
        if (isStatus()) {
            if ((freq <= 80.0 || freq >= 120) && isStatus()) {
                throw new FrequencyOutOfScopeException();
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
        return this.volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int increaseVolume() {
        if (getVolume() > 0 && getVolume() < 20) {
            this.volume += 2;
        } else {
            System.out.println("The volume can't be increased.");
        }
        return getVolume();
    }

    public int decreaseVolume() {
        if (getVolume() > 0 && getVolume() < 20) {
            this.volume -= 2;
        } else {
            System.out.println("The volume can´t be decreased");
        }
        return getVolume();
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
            File staticFile = new File("songs/static.wav");
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
