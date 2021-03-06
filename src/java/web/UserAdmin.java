/*
Test-fil för att prova metoder gällande hantering av konto i db (via bean)
 */
package web;

import bean.AdminEventBean;
import bean.AdminUserBean;
import bean.LoginBean;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nikolaj
 */
public class UserAdmin {

    Connection con;
    PreparedStatement stmt;
    Scanner s;

    public static void main(String[] args) {
        UserAdmin ea = new UserAdmin();


        ea.checkGivenPassword("jonas@gmail.com", "1234");
    }

    private void callAdminCreateCustomerBean() {
        s = new Scanner(System.in);
        AdminUserBean adb = new AdminUserBean(); 
        adb.init();
        System.out.println("Enter first name");
        String firstName = s.nextLine();
        System.out.println("Enter last name");
        String lastName = s.nextLine();
        System.out.println("Enter email");
        String email = s.nextLine();
        System.out.println("Enter password");
        String password = s.nextLine();

        adb.insertStatement(firstName, lastName, email, password, false, false);
        adb.closeConnection();
    }

    private void callAdminCreateAdminBean() {
        s = new Scanner(System.in);
        AdminUserBean adb = new AdminUserBean(); 
        adb.init();
        System.out.println("Enter first name");
        String firstName = s.nextLine();
        System.out.println("Enter last name");
        String lastName = s.nextLine();
        System.out.println("Enter email");
        String email = s.nextLine();
        System.out.println("Enter password");
        String password = s.nextLine();

        adb.insertStatement(firstName, lastName, email, password, true, false);
        adb.closeConnection();
    }

    private void checkGivenPassword(String email, String password) {

        LoginBean lb = new LoginBean();
        lb.init();
        boolean check = lb.checkPassword(email, password);
        if (check == true) {
            System.out.println("You are logged in");
        } else {
            System.out.println("Wrong password!");
        }
        lb.closeConnection();
    }
}
