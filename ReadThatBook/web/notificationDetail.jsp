<%-- 
    Document   : notificationDetail
    Created on : 30 Nov, 2016, 1:50:14 AM
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
        <title>Notification Detail</title>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@include file="defaultNav.jsp" %>
        

        <c:if test="${not empty notification}">
            <div class="col-xs-12">
                <table class="table table-hover">
                    <label><h3 class="h3">Notification details</h3></label>
                    <thead>
                    </thead>
                    <tbody>
                        <tr>
                            <td><h4><span class="label label-default">Notification ID </span></h4></td>
                            <td>${notification.getContactUsId()}</td>
                        </tr>
                        <tr>
                            <td><h4><span class="label label-default">Username</span></h4></td>
                            <td>${notification.getUserName()}</td>
                        </tr>
                        <tr>
                            <td><h4><span class="label label-default"> Category </span> </h4></td>
                            <td>${notification.getCategory()} </td>
                        </tr>
                        <tr>
                            <td><h4><span class="label label-default">Description</h4></td>
                            <td><pre class="text-justify"><br>${notification.getDescription()}</pre>
                                <c:if test="${notification.getCategory() eq 'Critic Access Request'}">
                                    <form action="contactUs" method="POST">
                                        <input type="hidden" name="action" value="notificationdecision" />
                                        <input type="hidden" name="userName" value="${notification.getUserName()}" />
                                        <input type="hidden" name="ID" value="${notification.getContactUsId()}" />
                                        <input type="submit" name="buttonStatus" value="Approve" class="btn btn-success" />
                                        <input type="submit" name="buttonStatus" value="Discard" class="btn btn-danger" />
                                    </form>
                                </c:if>
                                <c:if test="${notification.getCategory() eq 'Report Spam Review'}">
                                    <form action="contactUs" method="POST">
                                        <input type="hidden" name="action" value="spamdecision" />
                                        <input type="hidden" name="userName" value="${notification.getUserName()}" />
                                        <input type="hidden" name="ID" value="${notification.getContactUsId()}" />
                                        <input type="hidden" name="desc" value="${notification.getDescription()}" />
                                        <input type="submit" name="buttonSpam" value="Keep Review" class="btn btn-success" />
                                        <input type="submit" name="buttonSpam" value="Discard Review" class="btn btn-danger" />
                                    </form>
                                </c:if>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </c:if>
    </body>
</html>
