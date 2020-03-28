# queue-management-system
Java coursework 2 - You are to be assessed on how well you know Classes, objects, and data structures (queues). 

You are to implement three classes for this coursework that will be used to simulate
passengers queuing at a boarding gate and boarding the Eurostar train. The three classes
and the relevant fields and methods are described in the Class diagram below. You may
include additional fields and methods as required to complete the solution.

 ## Passenger. 
 This class will contain the properties of a passenger that are relevant to our simulation.
 - Fields - firstName:String, surname:String, secondsInQueue:int
 - Methods - getters and setters (see class diagram).

 ## PassengerQueue. 
 This class will represent the queue at the boarding gate.
 - Fields queueArray: Array of Passenger, first:int, last:int, maxStayInQueue:int
 - Methods: add(), remove(), display(), getMaxStay(), isEmpty(), isFull().

 ## TrainStation: 
 This is the main class that will drive the program.
 - Fields: waitingRoom: Array of Passenger, trainQueue: PassengerQueue
 - Methods: main() and other methods you may implement. 

Create a menu system in the main() method of your
TrainStation class which allows the user to choose which operation they want the program to
perform. You should also create a Passenger class and note that the waitingRoom and
passengerQueue will hold Passenger objects. Each operation should be implemented as a
separate method and the menu should allow the following operations:

- ‘A’ to add a passenger to the trainQueue
- ‘V’ to view the trainQueue
- ‘D’: Delete passenger from the trainQueue
- ‘S’: Store trainQueue data into a plain text file
- ‘L’: Load data back from the file into the trainQueue
- ‘R’ : Run the simulation and produce report (see details below).
