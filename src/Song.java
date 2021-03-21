import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Song {
    private String songName;
    private String fileDirectory;

    /**
     * The song that user wants to play has to be a .wav file and must be inside songs directory
     * @param songName name of the song
     */
    public Song(String songName) {
        this.songName = songName;

    }

    public void playSong(){
        try {
            File soundFile = new File("songs/"+this.songName+".wav");

            //Getting AudioInputStream
            //Can be thrown IOException и UnsupportedAudioFileException
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);

            //Getting realization of interface Clip
            //Can be thrown LineUnavailableException
            Clip clip = AudioSystem.getClip();

            //Uploading sound to sound stream Clip
            //Can be thrown IOException и LineUnavailableException
            clip.open(ais);

            clip.setFramePosition(0); //Setting pointer on start
//            FloatControl gainControl =
//                    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
//            gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.

            clip.start();

            Thread.sleep(clip.getMicrosecondLength()/1000);
        }
        catch (InterruptedException exc) {} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }
    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}
