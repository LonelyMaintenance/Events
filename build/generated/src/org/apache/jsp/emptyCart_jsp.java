package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class emptyCart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("                <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n");
      out.write("\n");
      out.write("                <ul>\n");
      out.write("            <ul><a href=\"logout.jsp\">Log out</a></ul>\n");
      out.write("        </ul>\n");
      out.write("        <title>Empty cart</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <header>\n");
      out.write("            <h1>Your cart is empty!</h1>\n");
      out.write("        ");

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().contains("id")) {
                        Cookie eventCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        eventCookie.setMaxAge(0);
                        response.addCookie(eventCookie);

                    }
                    if (cookie.getName().contains("tickets")) {
                        
                        Cookie ticketCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        ticketCookie.setMaxAge(0);
                        response.addCookie(ticketCookie);

                    }
                        if (cookie.getName().contains("eventName")) {

                        Cookie eventNameCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        eventNameCookie.setMaxAge(0);
                        response.addCookie(eventNameCookie);

                    }
                    if (cookie.getName().contains("price")) {

                        Cookie priceCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        priceCookie.setMaxAge(0);
                        response.addCookie(priceCookie);

                    }
                    if (cookie.getName().contains("date")) {

                        Cookie dateCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        dateCookie.setMaxAge(0);
                        response.addCookie(dateCookie);

                    }
                }
            }
        
      out.write("\n");
      out.write("        <a href=\"eventlist.jsp\">Back to eventlist</a>\n");
      out.write("        </header>\n");
      out.write("        \n");
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
