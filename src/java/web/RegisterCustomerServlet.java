/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package web;

import bean.AdminEventBean;
import bean.AdminUserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
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
@WebServlet(name = "RegisterCustomerServlet", urlPatterns = {"/RegisterCustomerServlet"})
public class RegisterCustomerServlet extends HttpServlet {

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
            String firstName = null;
            String lastName = null;
            String email = null;
            String password = null;

            firstName = request.getParameter("firstName");
            lastName = request.getParameter("lastName");
            email = request.getParameter("email");
            password = request.getParameter("password");

            if ((email != null && !email.isEmpty()) && (password != null && !password.isEmpty())) {
                // RequestDispatcher rd = request.getRequestDispatcher("touristbooking.jsp");
                // RequestDispatcher rdServlet = request.getRequestDispatcher("BookTripFormHandler");
                // request.setAttribute("message", "Exchange rate ");
                //  request.setAttribute("login", login);
                // rd.forward(request, response);           callAdminCreateEventBean(eventName, date, location, price, seats);

                callAdminCreateCustomerBean(firstName, lastName, email, password);
                RequestDispatcher rd = request.getRequestDispatcher("youareregistered.jsp");
                request.setAttribute("message", "You are registered");
                //request.setAttribute("login", login);
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("usernotregistered.jsp");
                //request.setAttribute("message", "Please insert all values");
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

    private void callAdminCreateCustomerBean(String firstName, String lastName, String email, String password) {

        AdminUserBean adb = new AdminUserBean(); //(TeacherInforRemRemote) Naming.lookup ("ava:global/CourseEJB/beans/TeacherInfoRem");
        adb.init();
        adb.insertStatement(firstName, lastName, email, password, false, false);
        adb.closeConnection();
    }
}
