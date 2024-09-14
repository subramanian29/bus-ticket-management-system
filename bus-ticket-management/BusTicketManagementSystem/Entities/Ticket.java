package BusTicketManagementSystem.Entities;

public class Ticket {
    private int id;
    private int price;
    private User passenger;
    private int busId;
    private Bus bus;

    public Ticket(int id,int price,User passenger, int busId){
        this.id=id;
        this.price=price;
        this.busId= busId;
        this.passenger=passenger;
    }

    public void setBus(Bus b)
    {
        this.bus=b;
    }


    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getPrice(){
        return this.price;
    }
    public void setPrice(int price){
        this.price=price;
    }

    public int getBusId(){
        return this.busId;
    }

    public void setBusId(int busId){
        this.busId=busId;
    }

    public User getPassenger(){
        return this.passenger;
    }

    public void setPassenger(User passenger){
        this.passenger=passenger;
    }

    public String toString()
    {
        return String.format(
            "Ticket ID: %d\nStart: %s -----> Destination:%s\nPassenger name: %s\nPassenger ID:%d\nPrice:%d",
            this.id,this.bus.getStart(),this.bus.getDestination(),
            this.passenger.getName(),this.passenger.getUserId(),this.bus.getTicketPrice());
    }

}
