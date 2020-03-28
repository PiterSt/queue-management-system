
package trainstation;
/**
 * @author piotrstanny
 */
import java.util.Scanner;

public class TrainStation {
    
    static final int TRAIN_CAPACITY = 30;
    private static Passenger[] waitingRoom = new Passenger[TRAIN_CAPACITY];
    private static PassengerQueue trainQueue = new PassengerQueue();

    // Main method:
    public static void main(String[] args) {
        System.out.println(
            "Welcome to the Polish National Trains!\nThis is a Passenger Management System.");
        // Initialising waiting room data
        initialise(waitingRoom);
        
        // Loading main menu:
        String menuChoice = menuList(); 
        
        while (!"q".equals(menuChoice)) {
            switch(menuChoice) {
                case "v":
                    System.out.println("\nList of all passengers in the queue:\n---------------------");
                    viewTrainQueue(Train);
                    menuChoice = menuList();
                    break;
                case "a":
                    System.out.println("\nAdd passenger to the queue:\n---------------------");
                    addPassengerToTrainQueue(Train);
                    menuChoice = menuList();
                    break;
                case "d":
                    System.out.println("\nRemove passenger from the queue:\n---------------------");
                    deletePassengerFromTrainQueue(Train);
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
                default:
                    System.out.println("\nInvalid input!");
                    menuChoice = menuList();
            }
        }
        // Closing the program:
        System.out.println("\nYour session has ended. Goodbye!");
    }
    
    // Other methods:
    private static void initialise(Passenger[] waitingRoom){
        for (int i=0; i<waitingRoom.length; i++){
            Passenger passenger = new Passenger("Mariusz", "Cebula");
            waitingRoom[i] = passenger;
        }
        System.out.println("Loading Waiting Room data...\n");
    }
    
    private static String menuList() {
        System.out.println(
                  "\nTo continue, choose from the list of menu options:\n"
                + "---------------------------\n"
                + "Q:\t Quit program\n"
                + "V:\t View the train queue\n"
                + "A:\t Add passenger to the queue\n"
                + "D:\t Delete passenger from the queue\n"
                + "S:\t Store queue data in to file\n"
                + "L:\t Load queue data from file");
        Scanner in = new Scanner(System.in);
        String menuChoice = in.nextLine().toLowerCase();
        return menuChoice;
    }
    
    private static void viewTrainQueue() {
        
    };
    
    private static void addPassengerToTrainQueue() {
        Passenger pass1 = new Passenger("Piotr","Stanny");
        trainQueue.add(pass1);
        trainQueue.display();
    };
    
    private static void deletePassengerFromTrainQueue() {
        
    };
    
    private static void storeTrainQueueToFile() {
        
    };
    
    private static void loadTrainQueueFromFile() {
        
    };
}
