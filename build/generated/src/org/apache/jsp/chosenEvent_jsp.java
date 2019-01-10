package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.io.PrintWriter;

public final class chosenEvent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("                <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Montserrat\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles.css\">\n");
      out.write("\n");
      out.write("        <title>Chosen Event</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("                <div class=\"w3-top\">\n");
      out.write("        <div class=\"w3-bar w3-red w3-card w3-left-align w3-large\">\n");
      out.write("            <a class=\"w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red\" href=\"javascript:void(0);\" onclick=\"myFunction()\" title=\"Toggle Navigation Menu\"><i class=\"fa fa-bars\"></i></a>\n");
      out.write("            <a href=\"logout.jsp\" class=\"w3-bar-item w3-button w3-right w3-padding-large w3-white\">Log out</a>\n");
      out.write("       ");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("        <header class=\"w3-container w3-red w3-center\" style=\"padding:128px 16px\">\n");
      out.write("            <h1 class=\"w3-margin w3-jumbo\">Chosen event</h1>\n");
      out.write("        </header>\n");
      out.write("    \n");
      out.write("        <form method=\"post\" action=\"ChosenEventServlet\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Chosen Event</td>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");

                        String id = request.getParameter("id");
                        String eventName = request.getParameter("eventName");
                        String price = request.getParameter("price");

                        
                        if (id != null&&eventName != null) {
                            out.println("<h1>Chosen number at " + id + "</h1");
                            out.println("<td><input name=\"id\" value=\"" + id + "\" ></input></td>");
                            out.println("<td><input name=\"eventName\" value=\"" + eventName + "\" ></input></td>");
                            out.println("<td><input name=\"price\" value=\"" + price + "\" ></input></td>");
                            

                        }


                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <td>Number of tickets:</td>\n");
      out.write("                    <td><input name=\"tickets\" value=\"1\"/></td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <td><input type=\"submit\" value=\"Add\" /></td>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <a href=\"cartView.jsp\">View cart</a>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
