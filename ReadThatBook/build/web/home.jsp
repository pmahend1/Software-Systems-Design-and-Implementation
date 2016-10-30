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
         <form name="viewBook" action="HomeServlet" method="post">
              <input type="hidden" name="action" value="viewBook">
             <input name="bookid" type="number"/><br></br>
            <input type="submit" value="View Details"/>
         </form>
         <a href="">Check Account</a>
         
         
    </body>
</html>

