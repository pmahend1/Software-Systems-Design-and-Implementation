<%-- 
    Document   : addBooks
    Created on : 24 Oct, 2016, 7:30:06 PM
    Author     : Prateek
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
        <script src="js/guestHome.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap.min.css">
        <script src="jquery.min.js"></script>
        <script src="bootstrap.min.js"></script>
        <script src="js/jquery.js"></script>
        <link href="css/userProfile.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Add a Book</title>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@ include file="defaultNav.jsp" %>
        <br/>
        <h3><center>Add A Book Manually</center></h3>
        <c:if test="${not empty messageText}">
        <div class="row">
            <div class="alert alert-danger alert-dismissible col-md-6 col-md-offset-3">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                <center><strong><c:out value="${messageText}"/></strong></center> 
            </div>
        </div> 
        </c:if>
        <form class="form-horizontal" action="BookManager" enctype="multipart/form-data" method="POST">
            <input type="hidden" name="action" value="addBook"/>
            <div class="form-group">
                <label for="BookTitle" class="col-sm-4 control-label">Book Title</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="BookTitle" name="title">
                </div>
            </div>
            <div class="form-group">
                <label for="ISBN_13" class="col-sm-4 control-label">ISBN-13</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="ISBN_13" name="ISBN_13">
                </div>
            </div>
            <div class="form-group">
                <label for="ISBN_10" class="col-sm-4 control-label">ISBN-10</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="ISBN_10" name="ISBN_10">
                </div>
            </div>
            <div class="form-group">
                <label for="Author" class="col-sm-4 control-label">Author</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="Author" name="author">
                </div>
            </div>
            <div class="form-group">
                <label for="Genre" class="col-sm-4 control-label">Genre</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="Genre" name="genre">
                </div>
            </div>
            <div class="form-group">
                <label for="Edition" class="col-sm-4 control-label">Edition</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="Edition" name="edition">
                </div>
            </div>
            <div class="form-group">
                <label for="Publisher" class="col-sm-4 control-label">Publisher</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="Publisher" name="publisher">
                </div>
            </div>
            <div class="form-group">
                <label for="Description" class="col-sm-4 control-label">Description</label>
                <div class="col-sm-4">
                    <textarea rows="4" cols="21"  class="form-control" id="Description" name="description"></textarea> 
                </div>
            </div>
            <div class="form-group">
                <label for="Image" class="col-sm-4 control-label">Image</label>
                <div class="col-sm-4">
                    <input type="file" id="Image" name="photo" >
                </div>
            </div>
            
            <div class="row">
                <div class="col-sm-offset-5">
                    <input type="submit" class="btn btn-primary btn-sm"/>
                    <input type="reset" class="btn btn-primary btn-sm"/>
                </div>
            </div>
        </form>
    </body>
    <%@ include file="footer.jsp" %>
</html>
