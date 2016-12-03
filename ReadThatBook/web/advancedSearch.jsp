<%-- 
    Document   : advancedSearch
    Created on : Nov 29, 2016, 8:58:36 PM
    Author     : akshay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Advanced Search Page</title>
        <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
    </head>
    
    <body style="background-color:#F1F4FF;">
        <%@ include file="header.jsp" %>
        <%@ include file="headerClose.jsp" %>
        <br><br>
        <form name="login" action="BookManager" method="post">
            <advSearch>
                Title : <input type="searchText" name="searchBookTitle" placeholder="Title..." align="center"><br/><br/>
                Author : <input type="searchText" name="searchBookAuthor" placeholder="Author..." align="center"><br/><br/>
                Genre : <input type="searchText" name="searchBookGenre" placeholder="Genre..." align="center"><br/><br/>
                ISBN : <input type="searchText" name="searchBookISBN" placeholder="ISBN..." align="center"><br/><br/>
                <input type = "Submit" name="submit" value="Advanced Search"/>
                <input type="hidden" name="action" value="advSearchBook"/>
            </advSearch>
        </form>
    </body>

</html>
