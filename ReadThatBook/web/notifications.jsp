<%-- 
    Document   : notifications
    Created on : 30 Nov, 2016, 12:39:04 AM
    Author     : Prateek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="bootstrap.min.css">
        <script src="jquery.min.js"></script>
        <script src="bootstrap.min.js"></script>
        <title>Notifications</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <p style="color:white; font-weight:bold; text-align:right;">${cookie.userCookie.value}</p>
        <%@ include file="userLogout.jsp" %>
        <%@include file="headerClose.jsp" %>
        <br>
        <br>
        <br>
        <br>
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
