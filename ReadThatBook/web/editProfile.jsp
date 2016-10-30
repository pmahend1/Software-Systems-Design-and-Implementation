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
        <title>Edit Profile</title>
    </head>
    <body>
        <h3>Edit Profile</h3>
        <form name="editProfile" action="UserProfileManager" method="post">
            <label> Password </label>
            <input type="password" name="passWord" value="${user.getPassWord()}"/><br/>
            <label> Re enter Password </label>
            <input type="password" name="rePassword" value="${user.getPassWord()}"/><br/>
            <label> First Name </label>
            <input type="text" name="firstName" value="${user.getFirstName()}"/><br/>
            <label> Last Name </label>
            <input type="text" name="lastName" value="${user.getLastName()}"/><br/>
            <label> Email </label>
            <input type="email" name="email" value="${user.getEmail()}"/><br/>
            <input type="hidden" name="username" value="${user.getUserName()}"</input>
            <input type="hidden" name="action" value="updateProfile" />
            <input type="submit"/>
        </form>
    </body>
</html>