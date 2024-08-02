package org.apache.jsp.home;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class displaycontact_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<head>\n");
      out.write("    <title>Contact List</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Contact List</h1>\n");
      out.write("    <table>\n");
      out.write("        <tr>\n");
      out.write("            <th>ID</th>\n");
      out.write("            <th>Name</th>\n");
      out.write("            <th>Email</th>\n");
      out.write("            <th>Message</th>\n");
      out.write("        </tr>\n");
      out.write("        ");
 
        String DB_URL = "jdbc:mysql://localhost:3306/ksc";
    String DB_USER = "root";
     String DB_PASSWORD = "";
// Replace with your actual MySQL password

        try {  Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            
            Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT `id`, `name`, `email`, `message` FROM `contact`"); 

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String message = resultSet.getString("message");
        
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( id );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( name );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( email );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( message );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("        ");
 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
      out.write("\n");
      out.write("    </table>\n");
      out.write("</body>\n");
      out.write("</html>");
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
