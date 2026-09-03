import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AquariumApp {

    static final int MAX_FISH = 8;
    static SeaCreature[] tank;

    static {
        try {
            tank = loadCreatures("creatures.txt");
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
    }

    public static void main(String[] args) {

//        try{
//            tank[0] = new Fish("Nemo", 4, 3, 1, "><>");
//            tank[1] = new Fish("Dory", 30, 2, -1, "><((('>");
//            tank[2] = new Jellyfish("Bob", 10, 5, -1, "==>( )");
//            tank[3] = new Crab("Shelly", 22, 2, 1);
//        } catch (InvalidCreatureException e) {
//            System.out.println(e.getMessage());
//        }

        Aquarium aquarium = new Aquarium(tank);
        Scanner input = new Scanner(System.in);

        boolean running = true;

        System.out.println("====================================");
        System.out.println("        JAVA TERMINAL AQUARIUM");
        System.out.println("====================================");

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    aquarium.display();
                    break;

                case "2":
                    aquarium.advanceTurn();
                    aquarium.display();
                    break;

                case "3":
                    System.out.println("This feature is a work in progress!");

                    int currentAmountOfFish = 0;

                    for (int i = 0; i < MAX_FISH; i++) {
                        if (tank[i] != null) {
                            currentAmountOfFish++;
                        } else {
                            break;
                        }
                    }

                    if (currentAmountOfFish >= MAX_FISH) {
                        System.out.println("The aquarium is full and new fish cannot be added");
                    } else {
                        FishMaker fishMaker = new FishMaker();
                        fishMaker.makeFish();
                        aquarium.display();
                    }

                    break;
                case "4":
                    aquarium.listCreatureDetails();
                    break;

                case "5":
                    running = false;
                    System.out.println("Aquarium closed. Goodbye!");
                    break;

                default:
                    aquarium.advanceTurn();
                    aquarium.display();
                    break;
            }
        }

        input.close();
    }

    private static SeaCreature[] loadCreatures(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        Scanner input = new Scanner(fileReader);

        int numberOfCreatures = input.nextInt();
        input.nextLine();

        tank = new SeaCreature[numberOfCreatures];

        for (int i = 0; i < numberOfCreatures; i++) {
            String line = input.nextLine();
            try{
                tank[i] = createCreature(line);
            } catch (InvalidCreatureException e) {
                System.out.println(e.getMessage());
            }

        }

        input.close();
        return tank;
    }

    private static SeaCreature createCreature(String line) throws InvalidCreatureException {
        System.out.println("Creature: " + line);

        Scanner input = new Scanner(line);
        input.useDelimiter(", ");

        String type = input.next();
        String name = input.next();

        int position = input.nextInt();
        int speed = input.nextInt();
        int direction = input.nextInt();

        if (type.equals("Fish")) {
            String symbol = input.next();
            return new Fish(
              name, position, speed, direction, symbol
            );
        } else if (type.equals("Crab")) {
            return new Crab(
                    name, position, speed, direction
            );
        } else if (type.equals("Jellyfish")) {
            String symbol = input.next();
            return new Jellyfish(
                    name, position, speed, direction, symbol
            );
        } else if (type.equals("CustomFish")) {
            String symbol = input.next();
            return new CustomFish(
                    name, position, speed, direction, symbol
            );
        }
        return null;
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. View Aquarium");
        System.out.println("2. Advance One Turn");
        System.out.println("3. Add Custom Fish");
        System.out.println("4. View Creature Details");
        System.out.println("5. Quit");
    }
}
