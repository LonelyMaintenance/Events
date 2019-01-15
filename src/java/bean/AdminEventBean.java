/*
Order till db gällande event. Se beskrivning över varje metod för detaljer
 */
package bean;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import web.EventList;

/**
 *
 * @author nikolaj
 */
@Stateless
public class AdminEventBean {

    Connection con;
    PreparedStatement preStmt;
    Statement stmt;

//Initierar jdbc-driver
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost/eventDb?autoReconnect=true&useSSL=false", "root", "root");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    //Skickar order till db om att registrera köp av biljett
    public void buyStatement(String email, String eventId, String seats) {
        try {
            int s = Integer.valueOf(seats);
            for (int i = 0; i < s; i++) {
                this.preStmt = (PreparedStatement) con.prepareStatement("INSERT INTO ticket(user_email, event_idEvent)VALUES(?,?);");
                preStmt.setString(1, email);
                preStmt.setInt(2, Integer.valueOf(eventId));
                preStmt.executeUpdate();
            }
            this.preStmt = (PreparedStatement) con.prepareStatement("UPDATE event SET availableSeats=availableSeats-? WHERE idEvent=?;");
            preStmt.setInt(1, Integer.valueOf(seats));
            preStmt.setInt(2, Integer.valueOf(eventId));
            preStmt.executeUpdate();
            preStmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    //Skickar order till db om att lägga till nytt event
    public void insertStatement(String eventName, String date, String location, float price, int seats) {
        try {
            this.preStmt = (PreparedStatement) con.prepareStatement("INSERT INTO event(eventName, date, location, price, availableSeats)VALUES(?, ?, ?, ?, ?);");
            preStmt.setString(1, eventName);
            preStmt.setString(2, date);
            preStmt.setString(3, location);
            preStmt.setFloat(4, price);
            preStmt.setInt(5, seats);
            preStmt.executeUpdate();
            preStmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
    
    //Skickar meddelande till db om att registrera event som inställt
    public void cancelEventStatement(String eventName) {
        try {
            this.preStmt = (PreparedStatement) con.prepareStatement("UPDATE event SET isCancelled=1 WHERE eventName=?;");
            preStmt.setString(1, eventName);
            preStmt.executeUpdate();
            preStmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    
//Hämtar alla event på sidan från db
   public ArrayList<EventList> getEventsStatement() throws SQLException {
        ArrayList<EventList> eventList = new ArrayList<>();

        try {
            this.stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT idEvent,eventName,price,availableSeats,date,isCancelled FROM event;");
            String id = "test";
            String eventName = "test";
            String price = "test";
            String availableSeats = "test";
            String date = "test";
            boolean event = false;

            while (resultSet.next()) {
                if (resultSet != null) {
                    id = resultSet.getString(1);
                    eventName = resultSet.getString(2);
                    price = resultSet.getString(3);
                    availableSeats = resultSet.getString(4);
                    date = resultSet.getString(5);
                    event = resultSet.getBoolean(6);
                    EventList evList = new EventList(id, eventName, price, availableSeats, date, event);
                    eventList.add(evList);
                }
            }
        } catch (SQLException ex) {
            System.err.println(new java.util.Date() + " : " + ex.getMessage());
        }

        return eventList;
    }

   //Hämtar köphistorik från db
    public ArrayList<String> getPurchaseHistory(String email) throws SQLException {
        ArrayList<String> ticketList = new ArrayList<>();

        try {
            this.stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT event.date, event.eventName, event.price, ticket.user_email FROM event INNER JOIN ticket ON event.idEvent=ticket.event_idEvent WHERE user_email='"+email+"';");
            String date = "test";
            String eventName = "test";
            String price = "test";

            while (resultSet.next()) {
                if (resultSet != null) {
                    date = resultSet.getString(1);
                    eventName = resultSet.getString(2);
                    price = resultSet.getString(3);
                    ticketList.add(String.format("Date: %s<br>Event: %s<br>Price: %s<br>", date, eventName,price));
                   
                }
            }
        } catch (SQLException ex) {
            System.err.println(new java.util.Date() + " : " + ex.getMessage());
        }

        return ticketList;
    }
    //Stänger uppkoppling till db
    public void closeConnection() {
        try {
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }
}
