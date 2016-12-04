<%-- 
    Document   : profile
    Created on : Oct 27, 2016, 9:41:41 AM
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
        <title>Profile</title>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@ include file="defaultNav.jsp" %>
        <br/><br/>
    <center>
        <table>
            <tr>
                <td><b>First Name</b></td>
                <td>:</td>
                <td><c:out value="${user.getFirstName()}" ></c:out></td>    
                </tr>
                <tr>
                    <td><b>Last Name</b></td>
                    <td>:</td>
                    <td><c:out value="${user.getLastName()}" ></c:out></td>
                </tr>
                <tr>
                    <td><b>Username</b></td>
                    <td>:</td>
                    <td><c:out value="${user.getUserName()}" ></c:out></td>  
                </tr>
                <tr>
                    <td><b>Email</b></td>
                    <td>:</td>
                    <td><c:out value="${user.getEmail()}" ></c:out></td>  
                </tr>
                <tr>
                    <td><b>Role</b></td>
                    <td>:</td>
                    <td><c:out value="${user.getRole()}" ></c:out></td>  
                </tr>
            </table>
        </center>
        <br/><br/> <br/><br/><br/><br/><br/><br/>   
    </body>
<%@ include file="footer.jsp" %>
</html>
