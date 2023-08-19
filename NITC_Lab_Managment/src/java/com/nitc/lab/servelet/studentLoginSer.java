
package com.nitc.lab.servelet;

import com.nitc.lab.dao.StudentDao;
import com.nitc.lab.entities.Message;
import com.nitc.lab.entities.Student;
import com.nitc.lab.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shrav
 */
public class studentLoginSer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet studentLoginSer</title>");            
            out.println("</head>");
            out.println("<body>");
           
            //fetch user name and password
            String id = request.getParameter("reg");
            String pass = request.getParameter("pass");
            
            StudentDao dao = new StudentDao(ConnectionProvider.getConnection());
            Student student = dao.getStudentIdAndPassword(id, pass);
            
            
            if (student == null) {
                //login.................
//                error///
//                out.println("Invalid Details..try again");
                Message msg = new Message("Invalid Details ! try with another", "error", "alert-danger");
                HttpSession s = request.getSession();
                s.setAttribute("msg", msg);

                response.sendRedirect("studentLogin.jsp");
            } else {
                //......
//                login success
                HttpSession s = request.getSession();
                s.setAttribute("currentUser", student);
                response.sendRedirect("Studentwork.jsp");

            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
