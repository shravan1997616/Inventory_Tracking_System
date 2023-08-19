
package com.nitc.lab.servelet;

import com.nitc.lab.dao.LabInchargeDao;
import com.nitc.lab.entities.LabIncharge;
import com.nitc.lab.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class labInchReg extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String mail = request.getParameter("mail");
            
            String l = request.getParameter("lab");
            
            String reg = request.getParameter("reg");
            String pass = request.getParameter("pass");
            
            // creat student and set all data to that object;
            LabIncharge lab=new LabIncharge(reg,pass,name,mail,l);
            
            // create a studentDao object.
            //out.println(ConnectionProvider.getConnection());
            LabInchargeDao dao = new LabInchargeDao(ConnectionProvider.getConnection());
            if(dao.saveLabIncharge(lab)){
                //save....
                out.println("done");
            }else{
                out.println("error");
            }
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
