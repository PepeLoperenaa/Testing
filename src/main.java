public class main {
    public static void main(String[] args) {
        Radio r1 = new Radio();
//        Song car = new Song("car");
        Song example = new Song("laPlacita");

        RadioStation rmfFm = new RadioStation("RmfFm", 86.75);

//        rmfFm.addSong(car);
        rmfFm.addSong(example);
        rmfFm.playSongs();

    }
}
