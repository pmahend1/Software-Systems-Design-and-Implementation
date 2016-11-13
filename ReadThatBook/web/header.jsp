<%-- 
    Document   : header
    Created on : Nov 9, 2016, 5:48:13 PM
    Author     : ashwini
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <label style="color:white;"><h1>ReadThatBook &emsp;&emsp;&emsp;</h1></label>
        </div>
            <ul class="nav navbar-nav">
                <li><a href="#">About</a></li>
                <li><a href="#">Contact</a></li>
                <li><a href="<c:url value="LoginServlet?action=backHome"/>">Home</a></li>
            </ul>

