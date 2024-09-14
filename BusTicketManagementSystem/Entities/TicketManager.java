package BusTicketManagementSystem.Entities;
import java.util.HashMap;

import BusTicketManagementSystem.customExceptions.invalidBusId;
import BusTicketManagementSystem.customExceptions.invalidTicketId;
import BusTicketManagementSystem.customExceptions.invalidUserId;
import BusTicketManagementSystem.misc.TicketIdGenerator;

public class TicketManager {
    private HashMap<Integer,Bus> busList= new HashMap<>();
    private HashMap<Integer,Ticket>ticketList=new HashMap<>();
    private HashMap<Integer,User> userList= new HashMap<>();

    public TicketManager(){
        Bus b1= new Bus(1,"A","B",70);
        Bus b2= new Bus(2,"C","D",80);
        Bus b3=new Bus(3,"D","E", 100);

        this.busList.put(b1.getID(),b1);
        this.busList.put(b2.getID(),b2);
        this.busList.put(b3.getID(),b3);
    }

    public void addUser(User u){
        this.userList.put(u.getUserId(),u);

    }

    public Ticket issueTicket(int busId, int userId) throws invalidBusId,invalidUserId
    {
        if(!userList.containsKey(userId))
        {
            throw new invalidUserId();

        }
        User u= userList.get(userId);

        int ticketId= TicketIdGenerator.generate();
        if(!this.busList.containsKey(busId))
        {
            throw new invalidBusId();
        }
        Bus bus= this.busList.get(busId);
        int price= bus.getTicketPrice();
        Ticket ticket= new Ticket(ticketId,price,u,busId);
        try{
            bus.addPassenger(u);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        ticket.setBus(bus);
        ticketList.put(ticketId,ticket);
        u.addTicket(ticket);
        return ticket;
    }

    public void cancelTicket(int ticketId) throws invalidTicketId
    {

        if(!this.ticketList.containsKey(ticketId))
        {
            throw new invalidTicketId();
        }
        Ticket t= this.ticketList.get(ticketId);
        int busId= t.getBusId();
        Bus bus= busList.get(busId);
        
        User passenger= t.getPassenger();
        ticketList.remove(ticketId);
        passenger.removeTicket(t);
        bus.removePassenger(passenger);
    }    

    public void showBuses(){
        for(Bus i: this.busList.values())
        {
            System.out.println(i);
        }
    }

    public void showTickets(int userId){
        User u= userList.get(userId);

        for(Ticket t: u.getTickets().values()){
            System.out.println(t);
        }
    }
    
}
