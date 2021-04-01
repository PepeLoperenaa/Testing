import java.io.Console;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FrequencyOutOfScopeException {
        Radio r1 = new Radio();
        Song car = new Song("car");
        Song cantina = new Song("cantinaBand60");
        Song example = new Song("example");
        Song fanfare = new Song("Fanfare");
        Song panther = new Song("PinkPanther30");
        RadioStation rmfFm = new RadioStation("RmfFm", 86.75);
        RadioStation zet = new RadioStation("zet", 90.00);
        rmfFm.addSong(car);
        rmfFm.addSong(cantina);
        rmfFm.addSong(example);
        zet.addSong(car);
        zet.addSong(fanfare);
        zet.addSong(panther);
        r1.addRadioStation(rmfFm);
        r1.addRadioStation(zet);


        //Console con = System.console();
        Scanner con = new Scanner(System.in);
        String input = "";
        System.out.println("To turn radio on radio input: on");
        input = con.nextLine();
        if (input.equals("on")) {
            r1.turnOnOff();
            while (r1.isStatus()) {
                System.out.println("The radio is turned on");
                System.out.println("To see all possible commands type in: help");
                input = con.nextLine();

                if (input.equals("+")) {
                    r1.increaseVolume();
                    System.out.println("Current volume: " + r1.getVolume());
                } else if (input.equals("-")) {
                    r1.decreaseVolume();
                    System.out.println("Current volume: " + r1.getVolume());
                } else if (input.equals("change")) {
                    double frequency = 0.0;
                    String radioStation = "";
                    System.out.println("Radio frequency ranges between 85.0 to 105.0 \n Type a double number:");
                    System.out.println("You can change radioStation only after song is finished");
                    try {
                        radioStation = con.nextLine();
                        frequency = Double.parseDouble(radioStation);
                        if (frequency < 85.00 && frequency > 105.0) {
                            throw new FrequencyOutOfScopeException();
                        }

                        r1.setFrequency(frequency);

                    } catch (NumberFormatException ignore) {
                        System.out.println("Invalid input");
                    }

                } else if (input.equals("exitApplication")) {
                    System.out.println("Application if off :)");
                    break;
                } else if (input.equals("off")) {
                    System.out.println("The radio has turned off. Goodbye!");
                } else if (input.equals("help")) {
                    System.out.println("To turn off radio type in: off ");
                    System.out.println("To turn on radio type in: on ");
                    System.out.println("To increase volume type : +");
                    System.out.println("To decrease volume type : -");
                    System.out.println("To turn off the RadioStation, press 'off'");
                    System.out.println("To change radioStation type 'change'" +
                            "Radio frequency ranges between 85.0 to 105.0");
                } else {
                    System.out.println("Volume has not changed");
                }
            }
        }
    }
}

