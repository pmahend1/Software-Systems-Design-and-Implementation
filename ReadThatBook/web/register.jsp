<%-- 
    Document   : register
    Created on : 2 Oct, 2016, 7:55:25 PM
    Author     : Prateek
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Home Page</title>
        <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/shop-homepage.css" rel="stylesheet">

    </head>

    <body style="background-color:#F1F4FF;">
        <%@ include file="header.jsp" %>
        <%@ include file="headerClose.jsp" %>
        <br/>
        <br/>
        <form class="form-horizontal" name="registerForm" action="LoginServlet" method="post">
            <span style = "color:red; margin-left:500px;" ng-show = "registerForm.userName.$dirty && registerForm.firstname.$invalid;">
                    <span ng-show = "registerForm.firstname.$error.required">User Name is required.</span>
            </span> <br/>
             <div class="form-group">
                <label for="inputUserName" class="col-sm-4 control-label">User Name</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="inputUserName" name="userName"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-sm-4 control-label">Password</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="inputPassword" name="passWord"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputRePassword" class="col-sm-4 control-label">Re enter Password</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="inputRePassword" name="rePassword"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputFirstName" class="col-sm-4 control-label">First Name</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="inputFirstName" name="firstName" />
                </div>
            </div>
            <div class="form-group">
                <label for="inputLastName" class="col-sm-4 control-label">Last Name</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="inputLastName" name="lastName"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-4 control-label">Email</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="inputEmail" name="email"/>
                </div>
            </div>
            <div class="form-group">
                <label for="inputUserRole" class="col-sm-4 control-label">Email</label>
                <div class="col-sm-4">
                    <select class="form-control" name="userRole" id="inputUserRole" style="width:193px;">
                        <option value="User">User</option>
                        <option value="Critic">Critic</option>
                    </select>
                </div>
            </div>    
            <div class="form-group">
                <div class="col-sm-offset-5 col-sm-10">
                    <button type="Submit" name="submit" class="btn btn-primary btn-lg">Submit</button>
                    <input type="hidden" name="action" value="registerForm"/>
                </div>
            </div>
        </form>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        <%@ include file="footer.jsp" %>
    </body>

</html>
