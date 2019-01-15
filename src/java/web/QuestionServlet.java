/*
Hämtar uppgifter om kundfråga från jsp och skickar vidare till MailService,
som för vidare till kundtjänst e-postadd
 */
package web;

import bean.LoginBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "QuestionServlet", urlPatterns = {"/QuestionServlet"})
public class QuestionServlet extends HttpServlet {

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

            String question = null;
            question = request.getParameter("question");
            String email = null;
            email = request.getParameter("email");
            String username = null;
            username = request.getParameter("username");
            String pass = null;
            pass = request.getParameter("pass");

            if ((question != null && !question.isEmpty()) && (email != null && !email.isEmpty())) {
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                MailService ms = new MailService();
                ms.setUSER_NAME(username);
                ms.setPASSWORD(pass);
                ms.setSender(email);
                ms.setBody(question);
                ms.sendReceipt();

                request.setAttribute("message", "Your question sent");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("contactservice.jsp");
                request.setAttribute("message", "Please insert question and email");

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

    private boolean checkGivenPassword(String email, String password) {

        LoginBean lb = new LoginBean(); 
        lb.init();
        boolean check = lb.checkPassword(email, password);
        lb.closeConnection();

        return check;
    }
}
