
package trainstation;
/**
 * @author piotrstanny
 */
public class PassengerQueue {
    private static Passenger[] queueArray = new Passenger[TrainStation.TRAIN_CAPACITY];
    private int first = 0;
    private int last = 0;
    private int maxStayInQueue = 0; // The longest time someone waited in the queue 
    private int maxQueueLength = 0; // The maximum length the queue reached
    
    public void add(Passenger next){
        //check for circular queue
        if (isFull()){
            System.out.println("Sorry, the queue is already full!");
        } else {
            queueArray[last] = next;
            last++;
            //check length of queue
        }
    }
    public Passenger remove(){
        if (isEmpty()){
            System.out.println("Sorry, the queue is already empty!");
            return null;
        } else {
            Passenger removedPassenger = queueArray[first];
            first++;
            return removedPassenger;
        }
    }
    public boolean isFull(){
        return last == queueArray.length;
    }
    public boolean isEmpty(){
        return first == last;
    }
    public void display(){
        for (int i=first; i < last; i++) {
            queueArray[i].display();
        }
    }
}
