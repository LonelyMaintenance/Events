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
public class AdminUserBean {

    Connection con;
    PreparedStatement stmt;
    Statement querystmt;
    ArrayList<String> userList;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    //In the real world, this method should have madtoe a call to database objects to query data
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost/eventDb?autoReconnect=true&useSSL=false", "root", "root");
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    public void insertStatement(String firstName, String lastName, String email, String password, boolean isAdmin, boolean isInactive) {
        try {
            this.stmt = (PreparedStatement) con.prepareStatement("INSERT INTO user(firstName, lastName, email, password, isAdmin, isInactive)VALUES(?, ?, ?, ?, ?, ?);");
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setBoolean(5, isAdmin);
            stmt.setBoolean(6, isInactive);
            stmt.executeUpdate();

        } catch (SQLException ex) {
        }
    }
    
        public void cancelUserStatement(String email) {
        try {
            this.stmt = (PreparedStatement) con.prepareStatement("UPDATE user SET isInactive=1 WHERE email=?;");
            stmt.setString(1, email);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
        }
        }


   public ArrayList<String> getUserListStatement() throws SQLException {
        ArrayList<String> userList = new ArrayList<>();

        try {
            this.querystmt = con.createStatement();
            ResultSet resultSet = querystmt.executeQuery("SELECT firstName,lastName,email FROM user;");
            String f = "test";
            String l = "test";
            String e = "test";


            while (resultSet.next()) {
                if (resultSet != null) {
                    f = resultSet.getString(1);
                    l = resultSet.getString(2);
                    e = resultSet.getString(3);
                    userList.add(e);
                }
            }
        } catch (SQLException ex) {
            System.err.println(new java.util.Date() + " : " + ex.getMessage());
        }

        return userList;
    }

    public void closeConnection() {
        try {
            stmt.close();
            con.close();
        } catch (SQLException ex) {
        }
    }
}
