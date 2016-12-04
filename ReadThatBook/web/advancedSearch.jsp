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
 
        <form class="form-horizontal" name="advSearch" action="BookManager" method="post">
            <div class="form-group">
                <label for="inputTitle" class="col-sm-3 control-label">Title</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="inputTitle" name="searchBookTitle" placeholder="Title">
                </div>
            </div>
            <div class="form-group">
                <label for="inputAuthor" class="col-sm-3 control-label">Author</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="inputAuthor" name="searchBookAuthor" placeholder="Author">
                </div>
            </div>
            <div class="form-group">
                <label for="inputGenre" class="col-sm-3 control-label">Genre</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="inputGenre" name="searchBookGenre" placeholder="Genre">
                </div>
            </div>
            <div class="form-group">
                <label for="inputISBN" class="col-sm-3 control-label">ISBN</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="inputISBN" name="searchBookISBN" placeholder="ISBN">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-8 col-sm-10">
                    <button type="Submit" name="submit" class="btn btn-primary btn-lg">Search</button>
                    <input type="hidden" name="action" value="advSearchBook"/>
                </div>
            </div>
        </form>
    </body>

</html>
