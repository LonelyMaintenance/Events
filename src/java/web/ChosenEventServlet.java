/*
Vid köp av vara så sparas här vara i cookies, till kundvagn (se metod doPost)
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
 * @author nikolaj
 */
@WebServlet(name = "ChosenEventServlet", urlPatterns = {"/ChosenEventServlet"})
public class ChosenEventServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
        String d = request.getParameter("date");

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

        Cookie dateCookie = new Cookie(("date" + i), d);
        //setting cookie to expiry in 30 min
        dateCookie.setMaxAge(30 * 60);
        response.addCookie(dateCookie);
        
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
