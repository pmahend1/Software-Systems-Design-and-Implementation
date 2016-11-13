<%-- 
    Document   : profile
    Created on : Oct 27, 2016, 9:41:41 AM
    Author     : sanju
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="business.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
        <title>Profile</title>
    </head>
    <body style="background-color:#FFF791;">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <label style="color:white;"><h1>ReadThatBook &emsp;&emsp;&emsp;</h1></label>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="#">About</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                    <p style="color:red;"><c:if test="${not empty message}"><c:out value="${message}"/></c:if></p>
                    <p style="color:red; font-weight:bold; text-align:right;">Welcome <c:out value="${user.firstName}" ></c:out></p>
                    <form name="logout" action="LoginServlet" method="post" align="right">
                        <input type="submit" name="logout" value="logout"/>
                        <input type="hidden" name="action" value="logout"/>
                    </form>
                    <br/>
                </div>
            </div>
        </nav>
        <br/><br/>
        <profile>
        <p><b>First Name:</b> <c:out value="${user.getFirstName()}" ></c:out></p>
        <p><b>Last Name:</b> <c:out value="${user.getLastName()}" ></c:out></p>
        <p><b>Email:</b> <c:out value="${user.getEmail()}" ></c:out></p> 
        <p><b>Books in your wishlist:</b></p>
        </profile>
    </body>
</html>
