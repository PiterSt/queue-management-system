
package trainstation;
import java.io.*;
import java.util.*;

/**
 * @author piotrstanny
 */
public class PassengerQueue {
    private static Passenger[] queueArray = new Passenger[TrainStation.TRAIN_CAPACITY];
    private int first = 0;
    private int last = 0;
    private int maxStayInQueue = 0;
    private int minStayInQueue = 100;
    private int maxQueueLength = 0;
    
    // Required methods:
    public void add(Passenger next){
        queueArray[last % queueArray.length] = next;
        if (maxQueueLength < last - first) {
            maxQueueLength = last - first;
        }
        last++;
    }
    
    public void remove(){
        if (isEmpty()){
            System.out.println("...\nSorry, the queue is already empty!");
        } else {
            Passenger removedPassenger = queueArray[first % queueArray.length];
            if (maxStayInQueue < removedPassenger.getSeconds()) {
                maxStayInQueue = removedPassenger.getSeconds();
            }
            if (minStayInQueue > removedPassenger.getSeconds()) {
                minStayInQueue = removedPassenger.getSeconds();
            }
            first++;
            System.out.println("Passenger " + removedPassenger.getName() + " boarded the train!");
        }
    }
    
    public boolean isFull(){
        return last - first == queueArray.length;
    }
    
    public boolean isEmpty(){
        return first == last;
    }
    
    public void display(){
        if (isEmpty()){
            System.out.println("...\nSorry, there is no one in the queue at the moment!");
        } else {
            int counter = 1;
            int arrSize = queueArray.length;
            if (last < arrSize) {
                for (int i=first; i < last; i++) {
                System.out.print(counter + ". ");
                queueArray[i].display();
                counter++;
                }
            } else if (last%arrSize > first%arrSize) {
                for (int i=first%arrSize; i < last%arrSize; i++) {
                System.out.print(counter + ". ");
                queueArray[i].display();
                counter++;
                }
            } else {
                for (int i=first; i < arrSize; i++) {
                System.out.print(counter + ". ");
                queueArray[i].display();
                counter++;
                }
                for (int i=0; i < last%arrSize; i++) {
                System.out.print(counter + ". ");
                queueArray[i].display();
                counter++;
                }
            }
        }
    }
    
    public int getLength(){
        return maxQueueLength;
    }
    
    public int getMaxStay(){
        return maxStayInQueue;
    }
    
    public int getMinStay(){
        return minStayInQueue;
    }
    
    // Other methods:
    private boolean isInteger(String name) {
        try {
            int integer = Integer.parseInt(name); 
            return true;
        }
        catch(NumberFormatException error) {
            return false;
        }
    }
    
    public boolean nameValidationFailed(String name) {
        if (name.equals("")) {
            System.out.print("Name cannot be empty!\nTry again: ");
            return true;
        }
        if (isInteger(name)) {
            System.out.print("Name cannot be a number!\nTry again: ");
            return true;
        }
        return false;
    }
    
    public void storeQueueToFile(){
        try {
            File file = new File("." + File.separator + "passengers_in_queue.txt");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
        
            for (int i=first; i<last; i++) {
                String name = queueArray[i].getName();
                writer.write(name + "\n");
            }
            writer.close();
            System.out.println("...\nData has been saved to the file!");
        }
        catch (Exception error) {
            System.out.println("Exception error:\n" + error);
        }
    }
    
    public void loadQueueFromFile(){
        try {
            String path = System.getProperty("user.dir");
            Scanner readFile = new Scanner(new BufferedReader(new FileReader(path + File.separator + "passengers_in_queue.txt")));
            String fileLine;
            first = 0;
            last = 0;
            while (readFile.hasNext()) { 
                fileLine = readFile.nextLine();
                String[] nameSplitArray = fileLine.split(" ");
                Passenger passenger = new Passenger(nameSplitArray[0], nameSplitArray[1]);
                add(passenger);
            }
            readFile.close();
            System.out.println("...Resetting the queue\nData has been loaded!\nChoose 'V' to see the queue.");
        }
        catch (FileNotFoundException error) {
            System.out.println("Exception error:\nNo data to load!\nAdd and store data in to file first to load it later.");
        }
    }
    
    public void setSeconds(int seconds) {
        for (int i=first; i < last; i++) {
                queueArray[i].setSecondsInQueue(seconds);
            }
    }
    
    public void resetQueue() {
        first = 0;
        last = 0;
        maxStayInQueue = 0;
        minStayInQueue = 100;
        maxQueueLength = 0;
        System.out.println("Resetting the queue...");
    }
}
