package me.salai.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Java beans and services import
import me.salai.practice.beans.User;
import me.salai.practice.dbservices.UserServices;
/**
 * SignUp 
 * Adds the user to the database if email id is not present
 * @author salaikumar
 */
public class SignUp extends HttpServlet {

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
        
        // Assuming validations completed and all expected fields are present.
        User newUser = new User(request.getParameter("first_name"),
                                request.getParameter("last_name"),
                                true,
                                request.getParameter("email"),
                                request.getParameter("password"));
       
         // Prepare response;
        response.setContentType("text/html;charset=UTF-8");
       
        // Connect to the database and store the values;
        UserServices.connectToDB();
        RequestDispatcher rs;
        if (!UserServices.isEmailPresent(newUser.getEmail())) {
            UserServices.createUser(newUser);
            rs = request.getRequestDispatcher("home.jsp");
            rs.forward(request, response);
        }else{
            rs = request.getRequestDispatcher("index.jsp");
            request.setAttribute("errormessage", "Email Id already exists");
            rs.include(request, response);
        }
        
        
        
        
        
        
        
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SignUp</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SignUp at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        
        
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
        return "Sign Up the user for the website";
    }// </editor-fold>

}
