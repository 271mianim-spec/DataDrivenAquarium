import java.io.File;
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

        input.close();

//        int currentAmountOfFish = 0;
//        for (int i = 0; i < AquariumApp.MAX_FISH; i++) {
//            if (AquariumApp.tank[i] != null) {
//                currentAmountOfFish++;
//            } else {
//                break;
//            }
//        }

        Random random = new Random();
        int randomPos = random.nextInt(1,Aquarium.TANK_WIDTH+1);
        try {

            try {
               File file = new File("creatures.txt");
               // Credits to "Kip" on StackOverflow for the documentation!
//               Printer fileWriter = new Scanner(file);

//               fileWriter.();

//               AquariumApp.tank[currentAmountOfFish] = new CustomFish(FishName, randomPos, FishSpeed, 1, FishSymbol);
            } catch (Exception e) {

            }


        } catch (InvalidCreatureException e) {
            System.out.println("The fish you created is not valid!");
            System.out.println(e.getMessage());
        }
    }
}
