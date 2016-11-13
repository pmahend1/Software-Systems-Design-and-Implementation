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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
    
        <title>Edit Profile</title>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@ include file="header.jsp" %>
        <p style="color:white; font-weight:bold; text-align:right;"><c:out value="${cookie['userCookie'].value}" ></c:out></p>
        <%@ include file="userLogout.jsp" %>
        <%@ include file="headerClose.jsp" %>
        <br/><br/>
        <center>
        <h3>Edit Profile</h3><br/>
        <table>
            <tr>
                <td><b>Password</b></td>
                <td>:</td>
                <td><input type="password" name="passWord" value="${user.getPassWord()}"/></td>    
            </tr>
            <tr>
                <td><b>Re enter Password</b></td>
                <td>:</td>
                <td><input type="password" name="rePassword" value="${user.getPassWord()}"/></td>
            </tr>
            <tr>
                <td><b>First Name</b></td>
                <td>:</td>
                <td><input type="text" name="firstName" value="${user.getFirstName()}"/></td>  
            </tr>
            <tr>
                <td><b>Last Name</b></td>
                <td>:</td>
                <td><input type="text" name="lastName" value="${user.getLastName()}"/></td>  
            </tr>
            <tr>
                <td><b>Email</b></td>
                <td>:</td>
                <td><input type="email" name="email" value="${user.getEmail()}"/></td>  
            </tr>
            <tr>
                <form name="editProfile" action="UserProfileManager" method="post">
                <td><input type="hidden" name="username" value="${user.getUserName()}"</input></td>   
                <td><input type="hidden" name="action" value="updateProfile" /></td>   
                <td><input type="submit"/></td>   
                </form>
            </tr>
        </table>
        </center>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/>
        <%@ include file="footer.jsp" %>
    </body>
</html>
