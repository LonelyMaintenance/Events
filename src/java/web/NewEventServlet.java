/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package web;

import bean.AdminEventBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
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
@WebServlet(name = "NewEventServlet", urlPatterns = {"/NewEventServlet"})
public class NewEventServlet extends HttpServlet {

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
            String eventName = null;
            String date = null;
            String location = null;
            String price = null;
            String seats = null;

            eventName = request.getParameter("eventName");
            date = request.getParameter("date");
            location = request.getParameter("location");
            price = request.getParameter("price");
            seats = request.getParameter("seats");

            if ((eventName != null && !eventName.isEmpty()) && (date != null && !date.isEmpty())) {

                callAdminCreateEventBean(eventName, date, location, price, seats);
                
                RequestDispatcher rd = request.getRequestDispatcher("eventcreated.jsp");

                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("newEvent.jsp");
                request.setAttribute("message", "Please insert all values");
                //request.setAttribute("login", login);
                rd.forward(request, response);
            }
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

    private void callAdminCreateEventBean(String eventName, String date, String location, String price, String seats) {
        AdminEventBean adb = new AdminEventBean(); //(TeacherInforRemRemote) Naming.lookup ("ava:global/CourseEJB/beans/TeacherInfoRem");
        adb.init();
        adb.insertStatement(eventName, date, location, Float.valueOf(price), Integer.valueOf(seats));
        //adb.closeConnection();
    }
}
