<%-- 
    Document   : home
    Created on : 1 Oct, 2016, 9:10:12 PM
    Author     : Prateek
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
    </head>
    <body>
         <h3>Read that Book</h3>
         <p>Welcome <c:out value="${user.firstName}" ></c:out></p> 
        
          <a href="">Check Account</a><br/>
         <c:if test="${user.getRole()=='admin'}">
         <a href="BookManager?action=manageBooks&user=${cookie.userCookie.value}">Manage Books</a><br/>
         </c:if> 
         
    </body>
</html>