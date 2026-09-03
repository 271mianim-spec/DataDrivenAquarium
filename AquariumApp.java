import java.util.Scanner;

public class AquariumApp {

    static final int MAX_FISH = 8;
    static SeaCreature[] tank = new SeaCreature[MAX_FISH];

    public static void main(String[] args) {

        try{
            tank[0] = new Fish("Nemo", 4, 3, 1, "><>");
            tank[1] = new Fish("Dory", 30, 2, -1, "><((('>");
            tank[2] = new Jellyfish("Bob", 10, 5, -1, "==>( )");
            tank[3] = new Crab("Shelly", 22, 2, 1);
        } catch (InvalidCreatureException e) {
            System.out.println(e.getMessage());
        }

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

    private static void printMenu() {
        System.out.println();
        System.out.println("1. View Aquarium");
        System.out.println("2. Advance One Turn");
        System.out.println("3. Add Custom Fish");
        System.out.println("4. View Creature Details");
        System.out.println("5. Quit");
    }
}
