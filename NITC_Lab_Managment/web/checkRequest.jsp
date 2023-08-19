

<%@page import="com.nitc.lab.entities.LabinchargeRequest"%>
<%@page import="com.nitc.lab.dao.LabinchargeRequestDao"%>
<%@page import="java.util.List"%>
<%@page import="com.nitc.lab.entities.StudentCompl"%>
<%@page import="com.nitc.lab.dao.StudentComplDao"%>
<%@page import="com.nitc.lab.helper.ConnectionProvider"%>
<%@page import="com.nitc.lab.entities.LabIncharge"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error_page.jsp" %>



<%
   LabIncharge labincharge = (LabIncharge)session.getAttribute("currentUser");
   if(labincharge == null){
       response.sendRedirect("labInchargeLogin.jsp");
       
   }    
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student page</title>
        
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            .banner-background{
             clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 91%, 63% 100%, 22% 91%, 0 99%, 0 0);
            }
            body{
                background-image: url(images/nitc1.jpg);
                background-size: cover;
                height:100vh;
                background-position:center;
                font-family: sans-serif;
            }
        </style>
    </head>
    <body>
        
<!--        navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark primary-background">
    <a class="navbar-brand" href="index.jsp"> <span class="fa fa-asterisk"></span> HOME</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="newSystemAdd.jsp"> <span class="fa fa-address-card-o"></span> Register System</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="systemStatus.jsp"> <span class="fa fa-address-card-o"></span> System Status</a>
            </li>
            
            <li class="nav-item active">
                <a class="nav-link" href="LabInchargeWork.jsp"> <span class="fa fa-bell-o"></span> View Complaints <span class="sr-only">(current)</span></a>
            </li>

           
            <li class="nav-item">
                <a class="nav-link" href="labinchargeRequest.jsp"> <span class="fa fa-address-card-o"></span> Request</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" data-toggle="modal" data-target="#labincharg_notification"> <span class="fa fa-address-card-o"></span> Check Request <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="updateStatus.jsp"> <span class="fa fa-address-card-o"></span> Update Status</a>
            </li>
            
            

        </ul>
        <ul class="navbar-nav mr-right">
            <li class="nav-item">
                <a class="nav-link" href="#"> <span class="fa fa-user-circle "></span><%=labincharge.getName()%></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"> <span class="fa fa-system "></span><%=labincharge.getLab()%></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="LabinchargeLogout"> <span class="fa fa-user-plus "></span> Logout</a>
            </li>
        </ul>
        
    </div>
</nav>


<!--            end of navbar-->
    
<!--   start request show message-->
<main>
<div class="modal fade" id="labincharg_notification" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Display all Lab Incharge Request....</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="row">
          <%
              LabinchargeRequestDao dataconnection = new LabinchargeRequestDao(ConnectionProvider.getConnection());
              List<LabinchargeRequest> req = dataconnection.getAllComplien(labincharge.getLab());
              for(LabinchargeRequest r : req){
                  %>
                  <div class="col-md-12 mt-2">
                      <div class="card">
                          <div class="card-body">
                              <b><%="Student Complain no : "+r.getScoid()%></b><br>
                              <b><%="Labincharge Request no: "+r.getReqno()%></b><br>
                              <b><%="Lab name: "+r.getLabname()%></b><br>
                              <b><%="Labincharge name: "+r.getLabincname()%></b><br>
                              <b><%="Labincharge Id: "+r.getLabincId()%></b><br>
                              <b><%="System Id:"+r.getSystemId()%></b><br>
                              <b><%="Title:"+r.getTitil()%></b><br>
                              <b><%="Request message:"+r.getMess()%></b><br>
                              <b><%="Request Date:"+r.getDate()%></b><br><br>
                              
                              <b><%="Labincharge Request Status:"+r.getStatus()%></b><br><br>
<!--                              <a  href="approveDeny.jsp">Approve or deny</a>-->
                              
                          </div>
                      </div>
                  </div>
                  
                  <%
              }
          %>
      </div>
    </div>
  </div>
</div>
</main>
<!--   end show request message-->
        
 
     <!--javascripts-->
        <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <script src="js/myjs.js" type="text/javascript"></script>    
        

        
    </body>
</html>