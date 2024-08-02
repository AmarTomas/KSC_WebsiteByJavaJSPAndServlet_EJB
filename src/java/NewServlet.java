/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MC
 */
public class NewServlet extends HttpServlet {

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
             /* TODO output your page here. You may use following sample code. */
           Class.forName("com.mysql.jdbc.Driver");
            System.out.println("ssssssssssssss11111111111111111111111111111111");
     
            Connection conn=getConnection();
            if(conn!=null){
            System.out.println("ssssssssssssssssssssssssssssssssssssssssssss");}
            else{
                 out.println("slllllllllllllpp11111111111111111111111111111111");
            }
        } catch (ClassNotFoundException ex) {
            out.println("sspppppppppppp11111111111111111111111111111111");
           ex.printStackTrace(out);
        } catch (SQLException ex) {
            out.println("rrrrrrrrrrrrrrrr11111111111111111111111111111111");
         
        ex.printStackTrace();
        }        }
        
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

private Connection getConnection() throws SQLException
        {
             String url = "jdbc:mysql://localhost:3306/ksc?zeroDateTimeBehavior=convertToNull";
    String username = "root";
    String password = "";
            return DriverManager.getConnection(url, username, password);
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
        processRequest(request, response);
//        PrintWriter out=response.getWriter();
//        try {
//            Connection conn=getConnection();
//            System.out.println("ssssssssssssssssssssssssssssssssssssssssssss");
//        } catch (SQLException ex) {
//                 System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrreeeeeee");
//                 ex.printStackTrace(out);
//        }
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
