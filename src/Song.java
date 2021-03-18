public class Song {
    private String songName;
    private String fileDirectory;

    public Song(String songName) {
        this.songName = songName;
        this.fileDirectory = fileDirectory;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getFileDirectory() {
        return fileDirectory;
    }

    public void setFileDirectory(String fileDirectory) {
        this.fileDirectory = fileDirectory;
    }
}
