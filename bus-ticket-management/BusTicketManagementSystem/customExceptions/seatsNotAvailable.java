package BusTicketManagementSystem.customExceptions;

public class seatsNotAvailable extends Exception{
    public seatsNotAvailable(){
        super("Bus seats full!");

    }
    
}
