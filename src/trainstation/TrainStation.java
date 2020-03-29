
package trainstation;
/**
 * @author piotrstanny
 */
import java.io.*;
import java.util.*;

public class TrainStation {
    
    static final int TRAIN_CAPACITY = 30;
    private static Passenger[] waitingRoom = new Passenger[TRAIN_CAPACITY];
    private static PassengerQueue trainQueue = new PassengerQueue();

    // Main method:
    public static void main(String[] args) {
        System.out.println(
            "Welcome to the Polish National Trains!\nThis is a Passenger Management System.");
        
        // Loading main menu:
        String menuChoice = menuList(); 
        
        while (!"q".equals(menuChoice)) {
            switch(menuChoice) {
                case "v":
                    System.out.println("\nList of passengers in the queue:\n---------------------");
                    viewTrainQueue();
                    menuChoice = menuList();
                    break;
                case "a":
                    System.out.println("\nAdd passenger to the queue:\n---------------------");
                    addPassengerToTrainQueue();
                    menuChoice = menuList();
                    break;
                case "d":
                    System.out.println("\nDelete passenger from the queue:\n---------------------");
                    deletePassengerFromTrainQueue();
                    menuChoice = menuList();
                    break;
                case "s":
                    System.out.println("\nSave queue data into file:\n---------------------");
                    storeTrainQueueToFile(Train);
                    menuChoice = menuList();
                    break;
                case "l":
                    System.out.println("\nLoad queue data from file:\n---------------------");
                    loadTrainQueueFromFile(Train);
                    menuChoice = menuList();
                    break;
                case "r":
                    System.out.println("\nRun boarding simulation:\n---------------------");
                    runBoardingSimulation(waitingRoom);
                    menuChoice = menuList();
                    break;
                default:
                    System.out.println("\nInvalid input!");
                    menuChoice = menuList();
            }
        }
        // Closing the program:
        System.out.println("\nYour session has ended. Goodbye!");
    }
    
    // Other methods:
    private static void initialise(Passenger[] waitingRoom) {
        try {
            String path = System.getProperty("user.dir");
            Scanner readFile = new Scanner(new BufferedReader(new FileReader(path + File.separator + "passengers.dat")));
            String fileLine;
            int index = 0;
            while (readFile.hasNext()) {
                fileLine = readFile.nextLine();
                String[] nameSplitArray = fileLine.split(" ");
                Passenger passenger = new Passenger(nameSplitArray[0], nameSplitArray[1]);
                waitingRoom[index] = passenger;
                index++;
            }
            readFile.close();
            System.out.println("\nInitialising Waiting Room...\nDone.");
        }
        catch (FileNotFoundException error) {
            System.out.println("\nEXCEPTION ERROR:\nFile not found!\nMake sure 'passengers.dat' file is in the main directory.");
        }
    }
    
    private static String menuList() {
        System.out.println(
                  "\nTo continue, choose from the list of menu options:\n"
                + "---------------------------\n"
                + "Q:\t Quit program\n"
                + "V:\t View the train queue\n"
                + "A:\t Add passenger to the queue\n"
                + "D:\t Delete passenger from the queue (board the train)\n"
                + "S:\t Store queue data in to file\n"
                + "L:\t Load queue data from file\n"
                + "R:\t Run boarding simulation and produce report");
        Scanner input = new Scanner(System.in);
        String menuChoice = input.nextLine().toLowerCase();
        return menuChoice;
    }
    
    // Menu options methods:
    private static void viewTrainQueue() {
        trainQueue.display();
    }
    
    private static void addPassengerToTrainQueue() {
        if (trainQueue.isFull()){
            System.out.println("...\nSorry, the queue is already full!");
        } else {
            Scanner input = new Scanner(System.in);
            String firstName, surname;
            
            System.out.print("Enter passenger's first name: ");
            firstName = input.nextLine();
            while (trainQueue.nameValidationFailed(firstName)) {
                firstName = input.nextLine();
            }
            System.out.print("Enter passenger's surname: ");
            surname = input.nextLine();
            while (trainQueue.nameValidationFailed(surname)) {
                surname = input.nextLine();
            }
            Passenger passenger = new Passenger(firstName, surname);
            trainQueue.add(passenger);
        }
    }
    
    private static void deletePassengerFromTrainQueue() {
        trainQueue.remove();
    }
    
    private static void storeTrainQueueToFile() {
        
    }
    
    private static void loadTrainQueueFromFile() {
        
    }
    
    private static void runBoardingSimulation(Passenger[] waitingRoom) {
        // Initialising waiting room data
        initialise(waitingRoom);
        for (Passenger passenger : waitingRoom) {
            passenger.display();
            }
    }
}
