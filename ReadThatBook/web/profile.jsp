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
    <body style="background-color:#FFF791;">
        <%@ include file="header.jsp" %>
        <p style="color:red; font-weight:bold; text-align:right;">Welcome <c:out value="${user.firstName}" ></c:out></p>
        <%@ include file="userLogout.jsp" %>
        <%@ include file="headerClose.jsp" %>
        <br/><br/>
        <profile>
        <p><b>First Name:</b> <c:out value="${user.getFirstName()}" ></c:out></p>
        <p><b>Last Name:</b> <c:out value="${user.getLastName()}" ></c:out></p>
        <p><b>Email:</b> <c:out value="${user.getEmail()}" ></c:out></p> 
        <p><b>Books in your wishlist:</b></p>
        </profile>
        <br/><br/> <br/><br/><br/><br/><br/><br/>   
    </body>
    <%@ include file="footer.jsp" %>
</html>
