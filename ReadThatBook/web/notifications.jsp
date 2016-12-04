<%-- 
    Document   : notifications
    Created on : 30 Nov, 2016, 12:39:04 AM
    Author     : Prateek
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Notifications</title>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@include file="defaultNav.jsp" %>
        <div class="container">
            <table class="table">
            </table>
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><h4>Notifications</h4></div>
                <div class="panel-body">
                    <ul class="list-group">
                        <c:forEach items="${contactUsInfoList}" var="cui" >
                            <li class="list-group-item"><a href="contactUs?action=contactUsInfo&ID=${cui.getContactUsId()}">${cui.getContactUsId()} : ${cui.getCategory()} - ${cui.getDescription()}</a></li>
                            </c:forEach>
                    </ul>
                </div>

                <!-- List group -->

            </div>
        </div>
    </body>
</html>
