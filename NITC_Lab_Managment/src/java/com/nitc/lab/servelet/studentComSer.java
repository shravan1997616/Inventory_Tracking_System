/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitc.lab.servelet;



import com.nitc.lab.dao.StudentComplDao;
import com.nitc.lab.entities.Student;
import com.nitc.lab.entities.StudentCompl;
import com.nitc.lab.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@MultipartConfig
public class studentComSer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session=request.getSession();
            Student student = (Student) session.getAttribute("currentUser");
            String id = student.getId();
            String name = student.getName();
            
            String lab = request.getParameter("lab");
            String title = request.getParameter("title");
            String mess = request.getParameter("mess");
            
            Random rand = new Random(); //instance of random class
            int upperbound = 1999999;
            int int_random = rand.nextInt(upperbound);
            String cid=String.valueOf(int_random);
            
            String status="Approved/Deny";
            
            StudentCompl com = new StudentCompl(cid,id,name,lab,title,mess,null,status);
            StudentComplDao dao = new StudentComplDao(ConnectionProvider.getConnection());
            if(dao.saveComplain(com)){
                out.println("done");
            }else{
                out.println("error");
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

}
