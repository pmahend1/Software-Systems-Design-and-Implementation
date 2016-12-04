<%-- 
    Document   : editProfile
    Created on : Oct 28, 2016, 11:08:26 AM
    Author     : sanju
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="business.User" %>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
        <link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css" rel="stylesheet" type="text/css" />      
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
        <link href="css/userProfile.css" rel="stylesheet">
        <script src="js/userProfile.js"></script>
    
        <title>Edit Profile</title>
    </head>
    <body style="background-color:#F1F4FF;">
       <%@ include file="defaultNav.jsp" %>
        <br/><br/>
        <center>
        <h3>Edit Profile</h3><br/>
        </center>
        <form class="form-horizontal" name="editProfile" action="UserProfileManager" method="post">
            <div class="form-group">
                <label for="inputPassword" class="col-sm-4 control-label">Password</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="inputPassword" name="passWord" value="${user.getPassWord()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputRePassword" class="col-sm-4 control-label">Re enter Password</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="inputRePassword" name="rePassword" value="${user.getPassWord()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputFirstName" class="col-sm-4 control-label">First Name</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="inputFirstName" name="firstName" value="${user.getFirstName()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputLastName" class="col-sm-4 control-label">Last Name</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="inputLastName" name="lastName" value="${user.getLastName()}">
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-4 control-label">Email</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="inputEmail" name="email" value="${user.getEmail()}">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-7 col-sm-10">
                    <button type="Submit" name="submit" class="btn btn-primary btn-lg">Submit</button>
                    <input type="hidden" name="username" value="${user.getUserName()}"</input>
                    <input type="hidden" name="action" value="updateProfile"/>
                </div>
            </div>
        </form>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/>
        <%@ include file="footer.jsp" %>
    </body>
</html>
