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
        <form name="registerForm" action="LoginServlet" method="post">
            <span style = "color:red; margin-left:300px;" ng-show = "registerForm.userName.$dirty && registerForm.firstname.$invalid;">
                    <span ng-show = "registerForm.firstname.$error.required">User Name is required.</span>
            </span> <br/>
            <register>
            <label> User Name </label>
            <input type="text" name="userName"/><br/>
            <label> Password </label>
            <input type="password" name="passWord"/><br/>
            <label> Re enter Password </label>
            <input type="password" name="rePassword"/><br/>
            <label> First Name </label>
            <input type="text" name="firstName"/><br/>
            <label> Last Name </label>
            <input type="text" name="lastName"/><br/>
            <label> Email </label>
            <input type="email" name="email"/><br/>
            <label> User Type </label>
            <select name="userRole" style="width:193px;">
                <option value="User">User</option>
                <option value="Critic">Critic</option>
            </select><br/>
            <input type="hidden" name="action" value="registerForm" />
            <input type="submit"/>
            </register>
        </form>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        <%@ include file="footer.jsp" %>
    </body>

</html>
