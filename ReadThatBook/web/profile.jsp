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
        <title>Profile</title>
    </head>
    <body>
        <p><b>First Name:</b> <c:out value="${user.getFirstName()}" ></c:out></p> 
        <p><b>Last Name:</b> <c:out value="${user.getLastName()}" ></c:out></p>
        <p><b>Email:</b> <c:out value="${user.getEmail()}" ></c:out></p> 
        <p><b>Books in your wishlist:</b></p>
    </body>
</html>
