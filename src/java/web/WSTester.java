/*
Test-fil för att prova koppling till webbtjänst MyGift
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

        System.out.println(getAccountValue("nikolaj.mansson@gmail.com"));


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
