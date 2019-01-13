/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kat
 */
@WebServlet(name = "ChosenEventServlet", urlPatterns = {"/ChosenEventServlet"})
public class ChosenEventServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChosenEventServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChosenEventServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        String i = request.getParameter("id");
        String t = request.getParameter("tickets");
        String e = request.getParameter("eventName");
        String p = request.getParameter("price");

        Cookie eventCookie = new Cookie(("id"), i);
        //setting cookie to expiry in 30 mins
        eventCookie.setMaxAge(30 * 60);
        response.addCookie(eventCookie);

        Cookie ticketCookie = new Cookie(("tickets" + i), t);
        //setting cookie to expiry in 30 mins
        ticketCookie.setMaxAge(30 * 60);
        response.addCookie(ticketCookie);

        Cookie eventNameCookie = new Cookie(("eventName" + i), e);
        //setting cookie to expiry in 30 mins
        eventNameCookie.setMaxAge(30 * 60);
        response.addCookie(eventNameCookie);

        Cookie priceCookie = new Cookie(("price" + i), p);
        //setting cookie to expiry in 30 mins
        priceCookie.setMaxAge(30 * 60);
        response.addCookie(priceCookie);
                
        RequestDispatcher rd = request.getRequestDispatcher("eventlist.jsp");
        rd.forward(request, response);

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

}
