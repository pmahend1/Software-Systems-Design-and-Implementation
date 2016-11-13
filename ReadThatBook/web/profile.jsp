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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
        <title>Profile</title>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@ include file="header.jsp" %>
        <p style="color:white; font-weight:bold; text-align:right;"><c:out value="${cookie['userCookie'].value}"  ></c:out></p>
        <%@ include file="userLogout.jsp" %>
        <%@ include file="headerClose.jsp" %>
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
