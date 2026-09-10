import javax.swing.text.AbstractWriter;
import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FishMaker {

    public FishMaker() {

    }

    public void makeFish() {
        Scanner input = new Scanner(System.in);

        System.out.println("What would you like to name your fish?");
        System.out.print("> ");
        String FishName = input.nextLine().trim();

        System.out.println("What is your fish's speed?");
        System.out.print("> ");
        String FishSpeedString = input.nextLine().trim();
        int FishSpeed = Integer.parseInt(FishSpeedString);

        System.out.println("What does your fish look like? It should be facing to the right!");
        System.out.print(" ");
        String FishSymbol = input.nextLine().trim();

        Random random = new Random();
        int randomPos = random.nextInt(1,Aquarium.TANK_WIDTH+1);

        StringBuilder fishLine = new StringBuilder();
        fishLine.append("CustomFish, ");
        fishLine.append(FishName+", ");
        fishLine.append(randomPos+", ");
        fishLine.append(FishSpeed+", ");
        fishLine.append("1, ");
        fishLine.append(FishSymbol);



        SeaCreature[] oldTank = AquariumApp.tank;
        SeaCreature[] newTank = new SeaCreature[AquariumApp.tank.length+1];
        for (int i = 0; i < oldTank.length; i++) {
            newTank[i] = AquariumApp.tank[i];
        }

        try {
            newTank[newTank.length-1] = new CustomFish(FishName, randomPos, FishSpeed, 1, FishSymbol);
        } catch (InvalidCreatureException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        AquariumApp.tank = newTank;

        try {
//           File file = new File("creatures.txt");
           // Credits to "Kip" on StackOverflow for the PrintWriter documentation
           // Credits to "axtavt" fir FileOutputStream documentation
           FileWriter fileWriter = new FileWriter(AquariumApp.fileName, true);
           BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
           PrintWriter printWriter = new PrintWriter(bufferedWriter);

           printWriter.append("\n").append(String.valueOf(fishLine));

           printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return;
    }
}
