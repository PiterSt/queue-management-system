
package trainstation;

import java.io.*;

/**
 * @author piotrstanny
 */
public class PassengerQueue {
    private static Passenger[] queueArray = new Passenger[TrainStation.TRAIN_CAPACITY];
    private int first = 0;
    private int last = 0;
    private int maxStayInQueue = 0; // The longest time someone waited in the queue 
    private int maxQueueLength = 0;
    
    // Required methods:
    public void add(Passenger next){
        //check for circular queue
        queueArray[last] = next;
            last++;
            System.out.println("\n...DONE.\nPassenger added!");
            if (maxQueueLength < last - first) {
                maxQueueLength = last - first;
            }
            System.out.println(maxQueueLength);
    }
    public void remove(){
        if (isEmpty()){
            System.out.println("...\nSorry, the queue is already empty!");
        } else {
            Passenger removedPassenger = queueArray[first];
            first++;
            System.out.println("\n...DONE.\nPassenger " + removedPassenger.getName() + " boarded the train!");
        }
    }
    public boolean isFull(){
        return last == queueArray.length;
    }
    public boolean isEmpty(){
        return first == last;
    }
    public void display(){
        if (isEmpty()){
            System.out.println("...\nSorry, there is no one in the queue at the moment!");
        } else {
            for (int i=first; i < last; i++) {
            queueArray[i].display();
            }
        }
    }
    
    //public int getLength()
    
    //public int getMaxStay()
    
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
}
