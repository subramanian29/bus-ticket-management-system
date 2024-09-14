package BusTicketManagementSystem.Entities;

import java.util.HashMap;

public class User {

    private String name;
    private String gender;
    private int age;
    private int userId;

    private HashMap<Integer,Ticket> tickets= new HashMap<>();

    public User(String name, String gender, int age,int userId){
        this.name=name;
        this.gender=gender;
        this.age=age;
        this.userId=userId;
    }

    public String getName(){
        return this.name;
    }


    public void setUserId(int userId){
        this.userId=userId;
    }
    public int getUserId(){
        return this.userId;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getGender(){
        return this.gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }

    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age=age;
    }    

    public void addTicket(Ticket t){
        this.tickets.put(t.getId(),t);
    }

    public HashMap<Integer,Ticket> getTickets(){
        return tickets;
    }
    public void removeTicket(Ticket t)
    {
        this.tickets.remove(t.getId());
    }

}


