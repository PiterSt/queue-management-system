
package trainstation;
/**
 * @author piotrstanny
 */
public class Passenger {
    String firstName, surname;
    int secondsInQueue;
    
    Passenger(String firstName, String surname){
        this.firstName = firstName;
        this.surname = surname;
        secondsInQueue = 0;
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
        System.out.println("Passenger details: " + firstName + " " + surname + "Seconds in a queue: " + secondsInQueue);
    }
}
