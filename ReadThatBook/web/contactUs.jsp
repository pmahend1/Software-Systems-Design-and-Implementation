<%-- 
    Document   : contactUs
    Created on : 29 Nov, 2016, 4:41:42 PM
    Author     : Prateek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
        <link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css" rel="stylesheet" type="text/css" />      
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
        <link href="css/userProfile.css" rel="stylesheet">
        <script src="js/userProfile.js"></script>
        <title>Contact Us</title>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@ include file="header.jsp" %>
        <p style="color:white; font-weight:bold; text-align:right;">${cookie.userCookie.value}</p>
        <%@ include file="userLogout.jsp" %>
        <%@include file="headerClose.jsp" %>
        <br>
        <br>
        <br>
        <br>
        <div class="container">
            <h3>Contact Us</h3>
            <form action="contactUs" method="POST">
                <input type="hidden" name="action" value="contactUsForm">
                <div class="row">
                    <div class="col-xs-4">
                        <label for="category">Category</label>
                        <select name="category" class="form-control" id="category">
                            <option>Site Feedback</option>
                            <option>Error reporting</option>
                            <option>Access related</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-8">
                        <label>Description</label>
                        <textarea name="description" class="form-control" id="textArea" rows="4"></textarea>
                    </div>
                </div>
                <br>
                <input type="submit" class="btn btn-primary">
            </form>
            <p style="color:red; font-weight:lighter; text-align:center;"><c:out value="${message}"/></p>
        </div>
        
    </body>
</html>
