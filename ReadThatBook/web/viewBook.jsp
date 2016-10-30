<%-- 
    Document   : viewBook
    Created on : Oct 26, 2016, 7:03:37 PM
    Author     : Sweet_HomegetBookID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Welcome </p>
        <p>BookId:<c:out value="${book.getBookID()}"></c:out><br/>
           Author:<c:out value="${book.getAuthor()}"></c:out><br/>
           Title:<c:out value="${book.getTitle()}"></c:out><br/>
           Genre:<c:out value="${book.getGenre()}"></c:out><br/>
           Description:<c:out value="${book.getDescription()}"></c:out><br/>
           Edition:<c:out value="${book.getEdition()}"></c:out><br/></p>
    </body>
</html>
