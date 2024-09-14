package BusTicketManagementSystem.Entities;
import java.util.HashMap;

import BusTicketManagementSystem.customExceptions.seatsNotAvailable;

public class Bus{
    private int id;
    private int seatsLeft=50;
    private String start;
    private String destination;
    private int ticketPrice;
    private HashMap<User,Boolean> passengerList= new HashMap<>();
    

    public Bus(int id,String start,String destination,int ticketPrice){
        this.id=id;
        this.start=start;
        this.destination=destination;
        this.ticketPrice=ticketPrice;
    }

    public void addPassenger(User p) throws seatsNotAvailable{
        if (this.seatsLeft>0){
            this.passengerList.put(p,true);
            this.seatsLeft--;
        }
        else{
            throw new seatsNotAvailable();
        }

    }

    public void removePassenger(User p){
        if(this.passengerList.containsKey(p)){
            passengerList.remove(p);
            this.seatsLeft++;
        }
    }

    public int getID(){
        return this.id;
    }
    public void setID(int id){
        this.id=id;
    }
    public int getSeatsLeft(){
        return seatsLeft;
    }

    public String getStart(){
        return this.start;
    }
    public void setStart(String start){
        this.start=start;
    }

    public String getDestination(){
        return this.destination;
    }
    public void setDestination(String destination){
        this.destination=destination;
    }

    public int getTicketPrice(){
        return this.ticketPrice;
    }
    public void setTicketPrice(int ticketPrice)
    {
        this.ticketPrice=ticketPrice;
    }

    public String toString()
    {
        return String.format("Bus ID:%d %s---->%s",this.id,this.start,this.destination);
    }


}
