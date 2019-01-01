/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //In the real world, this method should have madtoe a call to database objects to query data
   
    public void init(){
         try {    
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost/eventDb?autoReconnect=true&useSSL=false", "root", "root");
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }
    public void buyStatement(String email, String eventId, String seats){
        try {
            int s = Integer.valueOf(seats);
            for(int i = 0; i < s; i++){
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
        }
    }
    public void insertStatement(String eventName, String date, String location, float price, int seats){
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
        }
    }
    
        public ArrayList<EventList> getEventsStatement() throws SQLException{
                   ArrayList<EventList> eventList = new ArrayList<>();
                                      ArrayList<String> stringList = new ArrayList<>();

        try{
           this.stmt = con.createStatement();
           ResultSet resultSet = stmt.executeQuery("SELECT idEvent,eventName,price,availableSeats FROM event;");
           String id = "test";
           String eventName="test";
           String price = "test";
           String availableSeats = "test";
                 
         while (resultSet.next()){
              if(resultSet != null){
                  id = resultSet.getString(1);
           eventName = resultSet.getString(2);
           price = resultSet.getString(3);
           availableSeats = resultSet.getString(4);
            EventList evList = new EventList(id, eventName, price, availableSeats);
            stringList.add(eventName);
            eventList.add(evList);
                  }
         }
      }catch (SQLException ex) { 
         System.err.println(new java.util.Date()+" : "+ex.getMessage()); 
      }
        
        return eventList;
    }
    
    
    
    public void closeConnection(){
        try {
            stmt.close();
            con.close();
        } catch (SQLException ex) {
        }
    }
}
