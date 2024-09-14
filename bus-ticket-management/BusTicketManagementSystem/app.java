package BusTicketManagementSystem;

import java.util.Scanner;

import BusTicketManagementSystem.misc.userIdGenerator;
import BusTicketManagementSystem.Entities.*;

public class app {
    public static void printMenu(){
        System.out.println("________MENU________\n");
        System.out.println("1.Create User\n2.Book Ticket!\n3.Cancel Ticket\n4.Display tickets of a user\n\n");
        System.out.print("Enter your choice: ");
    }


    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        String p="y";

        TicketManager tm= new TicketManager();
        while(p.equals("y")){
            printMenu();
            int choice= input.nextInt();
            if(choice==1)
            {

                System.out.print("Enter your name: ");
                String name=input.next();
                System.out.println();

                System.out.print("Enter your gender: ");
                String gender=input.next();
                System.err.println();

                System.err.print("Enter your age: ");
                int age=input.nextInt();
                System.out.println();

                int id =userIdGenerator.generate();
            
                User u= new User(name, gender, age, id);
                tm.addUser(u);

                System.out.printf("User Added! user id is: %d",id);
            }
            else if(choice==2)
            {
                tm.showBuses();
                System.out.print("\nEnter user ID: ");
                int uId= input.nextInt();
                System.out.print("\nEnter Bus ID: ");
                int bId=input.nextInt();
                try{
                    Ticket t=tm.issueTicket(bId, uId);
                    System.out.println("\nTicket Issued!!");
                    System.out.println(t);
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }

            }
            else if(choice==3)
            {
                System.out.print("Enter ticket id: ");
                int tId= input.nextInt();
                System.out.println();
                try{
                    tm.cancelTicket(tId);
                    System.out.println("Ticket Cancelled..");
                }
                catch(Exception e){
                    System.err.println(e.getMessage());
                }

            }
            else if(choice==4){
                System.out.print("Enter user id: ");
                int uId= input.nextInt();
                tm.showTickets(uId);
            }
            else{
                System.out.println("Invalid choice\n");
            }

            System.out.print("\nDo you want to continue(y/n): ");
            p=input.next();
        }
        input.close();
        
    }
    
}
