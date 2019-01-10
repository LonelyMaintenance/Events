/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package web;

import gc.SQLException_Exception;
import java.sql.SQLException;

/**
 *
 * @author nikolaj
 */
public class WSTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException_Exception, SQLException {
        // TODO code application logic here
        // System.out.println("Course days " + getWeekDays("DA374A"));
        System.out.println(getAccountValue("nikolaj.mansson@gmail.com"));
        //  System.out.println(pay1("nikolaj.mansson@gmail.com", "100"));
        // System.out.println(pay("nikolaj.mansson@gmail.com", "100"));

    }

    private static float getAccountValue(java.lang.String name) {
        gc.GiftCardWebService_Service service = new gc.GiftCardWebService_Service();
        gc.GiftCardWebService port = service.getGiftCardWebServicePort();
        return port.getAccountValue(name);
    }

    private static Boolean pay(java.lang.String arg0, java.lang.String arg1) throws SQLException_Exception {
        gc.GiftCardWebService_Service service = new gc.GiftCardWebService_Service();
        gc.GiftCardWebService port = service.getGiftCardWebServicePort();
        return port.pay(arg0, arg1);
    }

}
