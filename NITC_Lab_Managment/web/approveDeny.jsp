
<%@page import="com.nitc.lab.entities.LabinchargeRequest"%>
<%@page import="com.nitc.lab.dao.LabinchargeRequestDao"%>
<%@page import="java.util.List"%>
<%@page import="com.nitc.lab.entities.StudentCompl"%>
<%@page import="com.nitc.lab.dao.StudentComplDao"%>
<%@page import="com.nitc.lab.helper.ConnectionProvider"%>
<%@page import="com.nitc.lab.entities.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error_page.jsp" %>



<%
   Admin admin = (Admin)session.getAttribute("currentUser");
   if(admin == null){
       response.sendRedirect("adminLogin.jsp");
       
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
                background-image: url(images/nitc4.jpg);
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
    <a class="navbar-brand" href="index.jsp"> <span class="fa fa-asterisk"></span>HOME</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
<!--                <a class="nav-link" href="#" data-toggle="modal" data-target="#admin_notification"> <span class="fa fa-bell-o"></span> View Complaints <span class="sr-only">(current)</span></a>-->
                <a class="nav-link" href="AdminWork.jsp"> <span class="fa fa-bell-o"></span> View Complaints</a>
            </li>

           
            <li class="nav-item">
                <a class="nav-link" href="adminRequest.jsp"> <span class="fa fa-address-card-o"></span> Request</a>
            </li>

            <li class="nav-item">
<!--                <a class="nav-link" href="approveDeny.jsp"> <span class="fa fa-address-card-o"></span> Request Approved/deny</a>-->
                <a class="nav-link" href="#" data-toggle="modal" data-target="#complain_status"> <span class="fa fa-address-card-o"></span> Request Approved/deny <span class="sr-only">(current)</span></a>
            </li>
       
        </ul>
        
        <ul class="navbar-nav mr-right">
            <li class="nav-item">
                <a class="nav-link" href="#"> <span class="fa fa-user-circle "></span><%=admin.getName()%></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="AdminLogout"> <span class="fa fa-user-plus "></span> Logout</a>
            </li>
        </ul>
        
    </div>
</nav>



<!--            end of navbar-->

<main>
<div class="modal fade" id="complain_status" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Provide Admin Request Approve or deny...</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          
          <form id="add-request" action="adminApproved" method="post">
              <div class="form-group">
                  <input type="text" required="required" name="scom" placeholder="Enter Student Complain No." class="form-control"/>
              </div>
              
              <div class="form-group">
                  <input type="text" name="labcom" required="required" placeholder="Enter Labincharge Request No." class="form-control"/>
              </div>
              
              <div class="form-group">
                  <select required="required" class="form-control" name="status" id="status">
                    <option selected disabled>---Select Request Status---</option>
                    <option>Approved</option>
                    <option>Deny</option>
                  </select>
                                    
               </div>
              
              <div class="container text-center">
                  <button type="submit" class="btn btn-outline-primary">Submit</button>
              </div>
          </form>
        
          
      </div>
    </div>
  </div>
</div>

</main>



        
<!--     javascripts-->
        <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/myjs.js" type="text/javascript"></script>    
        
        
<!--        <script>
    $(document).ready(function (e){
        
        $("#add-request").on("submit",function (event){
            // this code gets called when form is submitted...
            event.preventDefault();
            console.log("you have clicked on submit...")
            let form = new FormData(this);
            
            //now requesting to server
            $.ajax({
                url: "adminApproved",
                type: 'POST',
                data: form,
                
                success: function(data,textStatus,jqXHR){
                    //success.
                    console.log(data);
                    if(data.trim()=='done'){
                        swal("Good job!","saved successfully","success");
                    }else{
                        swal("Error!!","something went wrong.SHRAVAN.try again","error");
                    }
                },
                error: function (jqXHR,textStatus,errorThrown){
                    // error..
                    swal("Error!!","something went wrong..try again","error");
                },
                processData: false,
                contentType: false
            })
        })
    })
</script>-->

    </body>
</html>
