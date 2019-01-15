/*
Genomför köp av biljetter.
Hämtar beställda biljetter från kundvagn (cookies).
Kollar att det finns pengar på presentkort under användarens epost- på MyGifts:webbtjänst.
Drar ifrån pengar i MyGifts databas, under användarens konto.
Skickar kvitto via mail till användare.
Tömmer kundvagn (cookies) från events.
 */
package web;

import bean.AdminEventBean;
import bean.EventsBean;
import gc.SQLException_Exception;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nikolaj
 */
@WebServlet(name = "EventServlet", urlPatterns = {"/EventServlet"})
public class EventServlet extends HttpServlet {
    private String s = null;
    private String t = null;
    private String u = null;
    private float price = 0;

    String login;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException_Exception, SQLException {
        response.setContentType("text/html;charset=UTF-8");

    }
    
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        EventsBean e;
        try {
            e = new EventsBean();
             List<EventList> list = e.getData();
            

               Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().contains("user")) {
                        this.u = cookie.getValue();

                    }
                
                    if (cookie.getName().contains("id")) {
                        this.s = cookie.getValue();

                    }                    
                    if (cookie.getName().contains("tickets")) {
                        this.t = cookie.getValue();

                    }
                    if (cookie.getName().contains("price")) {
                        this.price = price + (Integer.valueOf(t))*(Float.valueOf(cookie.getValue()));

                    }
                }
             
            if (s != null) {
                int indexE = Integer.valueOf(s);
                indexE= indexE-1;
                EventList eL = list.get(indexE);
                int numberOfTickets = Integer.valueOf(t);

                float account = getAccountValue(u);
                float costOfBuy = price;
                if (costOfBuy <= account) {
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");

                    boolean success = pay(u, eL.price);
                    AdminEventBean aeb = new AdminEventBean();
                    aeb.init();
                    aeb.buyStatement(u, eL.id, t);

                    if (success) {
                          MailService ms = new MailService();
                ms.setUSER_NAME("aneventapplication@gmail.com");
                ms.setPASSWORD("ab1234cd");
                ms.setRECIPIENT(u);
                ms.setSubject("Your receipt");
                ms.setBody("You bought tickets for a value of " +price + ". View details in buyers history at Events.com/ Best regards admin at Event.com");
                ms.sendReceipt();
                        cookies = request.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    	             if (cookie.getName().contains("user")) {
                        Cookie loginCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        loginCookie.setMaxAge(0);
                        response.addCookie(loginCookie);

                    }if (cookie.getName().contains("id")) {
                        Cookie idCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        idCookie.setMaxAge(0);
                        response.addCookie(idCookie);

                    }if (cookie.getName().contains("tickets")) {
                        Cookie ticketCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        ticketCookie.setMaxAge(0);
                        response.addCookie(ticketCookie);

                    }if (cookie.getName().contains("price")) {
                        Cookie priceCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        priceCookie.setMaxAge(0);
                        response.addCookie(priceCookie);

                    }if (cookie.getName().contains("eventName")) {
                        Cookie eventNameCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        eventNameCookie.setMaxAge(0);
                        response.addCookie(eventNameCookie);

                    }
                    if (cookie.getName().contains("date")) {
                        Cookie dateCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        dateCookie.setMaxAge(0);
                        response.addCookie(dateCookie);

                    }
                    
                    
       }
        }

                        request.setAttribute("message", "Your buy went through");
                        rd.forward(request, response);
                    } else {
                        RequestDispatcher rf = request.getRequestDispatcher("notenoughmoney.jsp");

                        rf.forward(request, response);
                    }
               
                } else {
                    RequestDispatcher rf = request.getRequestDispatcher("index.html");

                    
                    rf.forward(request, response);
                }

            }
        }

        } catch (SQLException ex) {
            Logger.getLogger(EventServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException_Exception ex) {
            Logger.getLogger(EventServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private static Boolean pay(String email, String eventCost) throws SQLException_Exception {
        gc.GiftCardWebService_Service service = new gc.GiftCardWebService_Service();
        gc.GiftCardWebService port = service.getGiftCardWebServicePort();
        return port.pay(email, eventCost);
    }

    private static float getAccountValue(java.lang.String email) {
        gc.GiftCardWebService_Service service = new gc.GiftCardWebService_Service();
        gc.GiftCardWebService port = service.getGiftCardWebServicePort();
        return port.getAccountValue(email);
    }
}
