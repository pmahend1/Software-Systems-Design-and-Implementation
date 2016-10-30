<%-- 
    Document   : editProfile
    Created on : Oct 28, 2016, 11:08:26 AM
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
    
        <title>Edit Profile</title>
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
    
        <h3><center>Edit Profile<center></h3>
        <form name="editProfile" action="UserProfileManager" method="post">
            <editprofile>
            <label> Password :  </label>
            <input type="password" name="passWord" value="${user.getPassWord()}"/><br/>
            <label> Re enter Password :</label>
            <input type="password" name="rePassword" value="${user.getPassWord()}"/><br/>
            <label> First Name :</label>
            <input type="text" name="firstName" value="${user.getFirstName()}"/><br/>
            <label> Last Name :</label>
            <input type="text" name="lastName" value="${user.getLastName()}"/><br/>
            <label> Email :</label>
            <input type="email" name="email" value="${user.getEmail()}"/><br/>
            <input type="hidden" name="username" value="${user.getUserName()}"</input>
            <input type="hidden" name="action" value="updateProfile" />
            <input type="submit"/>
            </editprofile>
        </form>
    </body>
</html>
