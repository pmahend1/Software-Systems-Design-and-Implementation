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
    <body style="background-color:#FFF791;">
        <%@ include file="header.jsp" %>
        <p style="color:red; font-weight:bold; text-align:right;">Welcome <c:out value="${user.firstName}" ></c:out></p>
        <%@ include file="userLogout.jsp" %>
        <%@ include file="headerClose.jsp" %>
        <br/><br/>
        <h3 style="margin-left: 250px">Edit Profile</h3><br/>
        <form name="editProfile" action="UserProfileManager" method="post">
            <register>
            <label> Password :  </label>
            <input type="password" name="passWord" value="${user.getPassWord()}"/><br/>
            <label> Re enter Password :</label>
            <input type="password" name="rePassword" value="${user.getPassWord()}"/><br/>
            <label> First Name :</label>
            <input type="text" name="firstName" value="${user.getFirstName()}"/><br/>
            <label> Last Name:</label>
            <input type="text" name="lastName" value="${user.getLastName()}"/><br/>
            <label> Email :</label>
            <input type="email" name="email" value="${user.getEmail()}"/><br/>
            <input type="hidden" name="username" value="${user.getUserName()}"</input>
            <input type="hidden" name="action" value="updateProfile" />
            <input type="submit"/>
            </register>
        </form>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/>
        <%@ include file="footer.jsp" %>
    </body>
</html>
