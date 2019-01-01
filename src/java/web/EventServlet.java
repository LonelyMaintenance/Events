/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nikolaj
 */
@WebServlet(name = "EventServlet", urlPatterns = {"/EventServlet"})
public class EventServlet extends HttpServlet {
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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String chosen = (String) request.getAttribute("item");

       
                    EventsBean e;
        try {
            e = new EventsBean();
            List<EventList> list = e.getData();
                    String s=request.getParameter("item");
                 String t = (String)request.getParameter("tickets");
                                  String u = (String)request.getParameter("user");

                                 //this.login = (String)request.getAttribute("login");
             

                if (s !=null)
                {
                       RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
              request.setAttribute("item", s);
                     int indexE = Integer.valueOf(s);
                     EventList eL= list.get(indexE);
                     int numberOfTickets = Integer.valueOf(t);
                     System.out.println(indexE);
                     System.out.println(u);
                     float account = getAccountValue(u);
                     float costOfBuy = numberOfTickets*Float.valueOf(eL.price);
                     if(costOfBuy<=account){
                        boolean success = pay(u, eL.price);
                        AdminEventBean aeb = new AdminEventBean();
                        aeb.init();
                        aeb.buyStatement(u, eL.id, t);
                       // aeb.closeConnection();
                      
                           // request.setAttribute("login", login);
                           if(success){
            request.setAttribute("message", "Your buy went through");
                           }else{
                    request.setAttribute("message", "You did not have enough money");           
                           }
            rd.forward(request, response);
                     }else{
       request.setAttribute("message", "You did not have enough money");           
                           
            rd.forward(request, response);
                     }
              //      out.println("Selected Event is : "+list.get(Integer.valueOf(s)).getName());
                    
                }
        } catch (SQLException ex) {
            Logger.getLogger(EventServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException_Exception ex) {
            Logger.getLogger(EventServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

            /* TODO output your page here. You may use following sample code. */
        
                
               
             //   out.println(t);
              //  out.println(login);
                

        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
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
