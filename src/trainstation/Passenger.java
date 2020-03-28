
package trainstation;
/**
 * @author piotrstanny
 */
public class Passenger {
    private String firstName, surname;
    private int secondsInQueue;
    
    Passenger(String firstName, String surname){
        this.firstName = firstName;
        this.surname = surname;
        this.secondsInQueue = 0;
    }
    
    public String getName(){
        return firstName + " " + surname;
    }
    public void setName(String firstName, String surname){
        this.firstName = firstName;
        this.surname = surname;
    }
    public int getSeconds(){
        return secondsInQueue;
    }
    public void setSecondsInQueue(int seconds){
        this.secondsInQueue = seconds;
    }
    
    public void display(){
        System.out.println("Passenger details: " + firstName + " " + surname + " - seconds spent in a queue: " + secondsInQueue);
    }
}
