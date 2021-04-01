import java.io.Console;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FrequencyOutOfScopeException {
        Radio r1 = new Radio();
        Song car = new Song("car");
        Song cantina = new Song("CantinaBand60");
        Song example = new Song("example");
        Song fanfare = new Song("Fanfare60");
        Song panther = new Song("PinkPanther30");
        RadioStation rmfFm = new RadioStation("RmfFm", 86.75);
        RadioStation zet = new RadioStation("Zet", 90.00);
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
        System.out.println("To turn radio on, type in: on");
        System.out.println("To see all possible commands type in: help");
        input = con.nextLine();
        if (input.equals("on")) {
            r1.turnOnOff();
            System.out.println("The radio is turned on");
            while (r1.isStatus()) {
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
                    System.out.println("You can change radioStation only after song is finished");
                    System.out.println("Radio frequency ranges between 85.0 to 105.0 \n Type a double number:");
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

                }  else if (input.equals("off")) {
                    if(r1.isStatus()){
                        System.out.println("The radio has turned off. Goodbye!");
                        r1.turnOnOff();
                    }else{
                        System.out.println("The radio is already off.");
                    }
                }else if(input.equals("on")){
                    if(r1.isStatus()){
                        System.out.println("The radio is already on");
                    }else{
                        System.out.println("The radio is turned on");
                        r1.turnOnOff();
                    }
                }else if(input.equals("list")){
                    for (RadioStation radioStation:r1.getRadioStations()){
                        System.out.println(radioStation.getName()+" frequency:"+radioStation.getFrequency());
                    }
                }
                else if (input.equals("help")) {
                    System.out.println("To turn off radio type in: off ");
                    System.out.println("To turn on radio type in: on ");
                    System.out.println("To increase volume type : +");
                    System.out.println("To decrease volume type : -");
                    System.out.println("To turn off the Radio, type in off");
                    System.out.println("To see the list of radioStations, type in: list");
                    System.out.println("To change radioStation type 'change'" +
                            "Radio frequency ranges between 85.0 to 105.0");
                }else{
                    System.out.println("Unknown command");
                }
            }
        }else{
            System.out.println("Unknown command");
        }
    }
}

