/*
Terminal för adminanvändare - se kommentar över metoder för närmare uppgift
 */
package web;

import bean.AdminEventBean;
import bean.AdminUserBean;
import bean.EventsBean;
import bean.LoginBean;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author nikolaj
 */
public class AdminTerminal {

//Meny
    public static void main(String[] args) throws SQLException {
        while(true){
        AdminTerminal a = new AdminTerminal();
        Scanner s = new Scanner(System.in);
        System.out.println("To check user transaction, enter your details");
        System.out.println("Enter email");
        String e = s.nextLine();
        System.out.println("Enter password");
        String p = s.nextLine();
        boolean checkPass = a.checkGivenPassword(e,p);
        boolean checkAdmin = a.checkIfAdmin(e);
        if(checkPass==true&&checkAdmin==true){
        
                System.out.println("To view a list of all users, press 1 followed by enter");
                System.out.println("To view a list of all events, press 2 followed by enter");
                System.out.println("To cancel an event, press 3 followed by enter");
                System.out.println("To unregister a user, press 4 followed by enter");
                System.out.println("To add a new event with seats, press 5 followed by enter");
                System.out.println("To logout again, press space followed by enter");
        String l = s.nextLine();
        if(l.equals("1")){
                    AdminUserBean aub = new AdminUserBean();
        aub.init();
        ArrayList<String> list = aub.getUserListStatement();
    
            for(int i = 0; i < list.size(); i++){
                System.out.println(list.get(i));
            }
        }
        else if(l.equals("2")){
            
            ArrayList<EventList> eventList = a.getEventList();
            for(int i = 0; i < eventList.size(); i++){
                System.out.println(eventList.get(i).getDate() + ": " + eventList.get(i).getEventName());
            }

        }
        else if(l.equals("3")){
            System.out.println("Enter name of event");
            String event = s.nextLine();
           a.cancelEvent(event);
        } 
        else if(l.equals("4")){
            System.out.println("Enter email of user");
            String userEmail = s.nextLine();
           a.unregisterUser(userEmail);
        }
        else if(l.equals("5")){
            System.out.println("Enter name of event");
            String eventName = s.nextLine();
            System.out.println("Enter date of event");
            String date = s.nextLine();
            System.out.println("Enter location of event");
            String location = s.nextLine();
            System.out.println("Enter price of event");
            String price = s.nextLine();
            System.out.println("Enter number of seats at event");
            String seats = s.nextLine();
            a.callAdminCreateEventBean(eventName, date, location, price, seats);
             }        
        else if(l.equals(" ")){
            break;
        }
        }else{
            System.out.println("Not a correct combination of email and password");
        }
        }

    }
//Kollar om lösenord stämmer överens med användarnamn (epost) i db
        private boolean checkGivenPassword(String email, String password) {

        LoginBean lb = new LoginBean(); 
        lb.init();
        boolean check = lb.checkPassword(email, password);
        lb.closeConnection();

        return check;
    }
    //Kontrollerar om användare med en viss epost är admin enligt uppgift i db
    private boolean checkIfAdmin(String email) {

        LoginBean lb = new LoginBean(); 
        lb.init();
        boolean admin = lb.checkIfAdmin(email);
        lb.closeConnection();

        return admin;
    }
//Hämtar lista över events i db
  private ArrayList<EventList> getEventList() throws SQLException {
        AdminEventBean adb = new AdminEventBean(); 
        adb.init();
        ArrayList<EventList> eventList = adb.getEventsStatement();
        for (int i = 0; i < eventList.size(); i++) {
            System.out.println(eventList.get(i));
        }
        adb.closeConnection();
        return eventList;

    }
  //Avregistrerar event i db
  private void cancelEvent(String eventName){
               AdminEventBean aeb = new AdminEventBean();
                aeb.init();
                aeb.cancelEventStatement(eventName);
       
  }
  //Avregistrerar användare i db
  private void unregisterUser(String emailOfUser){
                  AdminUserBean aub = new AdminUserBean();
            aub.init();
            aub.cancelUserStatement(emailOfUser);
  }
    //Skapar event i db
        private void callAdminCreateEventBean(String eventName, String date, String location, String price, String seats) {
        AdminEventBean adb = new AdminEventBean(); 
        adb.init();
        adb.insertStatement(eventName, date, location, Float.valueOf(price), Integer.valueOf(seats));

    }
}
