package BusTicketManagementSystem.misc;

public class userIdGenerator {

    private static int id=0;
    public static int generate()
    {
        id++;
        return id;
    }
    
}


