/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import bean.AdminEventBean;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nikolaj
 */
public class EventAdmin {
    Connection con;
    PreparedStatement stmt;
    Scanner s;

   
    public static void main(String[] args) throws SQLException{
     EventAdmin ea = new EventAdmin();
     //ea.callAdminCreateEventBean();
      ea.getEventList();
    }
   private void callAdminCreateEventBean(){
        s = new Scanner(System.in);
        AdminEventBean adb = new AdminEventBean(); //(TeacherInforRemRemote) Naming.lookup ("ava:global/CourseEJB/beans/TeacherInfoRem");
        adb.init();  
        System.out.println("Enter event name");
        String eventName = s.nextLine();
        System.out.println("Enter date");
        String date = s.nextLine();
        System.out.println("Enter location");
        String location = s.nextLine();
        System.out.println("Enter price");
        float price = Float.valueOf(s.nextLine());
        System.out.println("Enter number of seats");
        int seats = Integer.valueOf(s.nextLine());
        adb.insertStatement(eventName, date, location, price, seats);
        adb.closeConnection();
    }
   
   public void getEventList() throws SQLException{
        AdminEventBean adb = new AdminEventBean(); //(TeacherInforRemRemote) Naming.lookup ("ava:global/CourseEJB/beans/TeacherInfoRem");
        adb.init();  
        ArrayList<EventList> eventList = adb.getEventsStatement();
        for(int i = 0; i < eventList.size(); i++){
            System.out.println(eventList.get(i).getEventName());
        }
        adb.closeConnection();
       
   }
}
