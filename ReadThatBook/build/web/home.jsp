<%-- 
    Document   : home
    Created on : 1 Oct, 2016, 9:10:12 PM
    Author     : Prateek
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="business.User" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>

        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
        <link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css" rel="stylesheet" type="text/css" />
                
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
        <link href="css/userProfile.css" rel="stylesheet">
        <script src="js/userProfile.js"></script>
    </head>
    
    <body style="background-color:#FFF791;">
        
        <%@ include file="header.jsp" %>
        <p style="color:red; font-weight:bold; text-align:right;">Welcome <c:out value="${user.firstName}" ></c:out></p>
        <%@ include file="userLogout.jsp" %>
        <%@ include file="headerClose.jsp" %>
        <br/>
        <br/>
        
        <c:if test="${user.getRole()=='admin'}">
        <a class ="dropbtn" style="text-decoration:none; color:white;"
           href="BookManager?action=manageBooks&user=${cookie.userCookie.value}">Manage Books</a><br/>
        </c:if> 
        <br/>
        
        <form name="ProfileView" action="UserProfileManager" method="post">
            <input type="hidden" name="username" value="${user.getUserName()}"/>
            <div class="dropdown" style="z-index:1">
                <button class="dropbtn">Profile</button>
                <div class="dropdown-content">
                    <button type="submit" name="action" value="viewprofile" >View profile</button>
                    <button type="submit" name="action" value="editprofile" >Edit profile</button>
                    <input type="button" id="btnShow" value="Delete Account" />
                    <div id="dialog" style="display: none" align = "center">
                        Are you sure you want to delete your account?
                    </div>
                </div>
            </div>
        </form>
            
        <form name="login" action="BookManager" method="post">
            <div style="text-align:center; margin:0 80px;"/>
            <input type="searchText" name="searchString" placeholder="Search.." align="center">
            <input type = "Submit" name="submit" value="Search"/>
            <input type="hidden" name="action" value="searchBook"/>
        </form>
            
        <c:if test="${searchErrorMessage != null}">
        <p style="color:red; font-weight:bold; text-align:center;">${searchErrorMessage}</p>
        <%request.removeAttribute("searchErrorMessage"); %>  
        </c:if>
        
        <br/><br/><br/>
        
        <div class="row">
            <c:forEach items="${books}" var="item">
                <div class="col-sm-4 col-lg-4 col-md-4">
                    <div class="thumbnail">
                        <img src="http://placehold.it/320x150" alt="">
                        <div class="caption">
                          <h3 align="center">${item.title}</h3>
                          <h4 align="center">By:${item.author}</h4> 
                          <form name="viewBook" action="BookListServlet" method="post">
                              <input type="hidden" name="action" value="viewBook"/>
                              <input type="hidden" name="bookid" value="${item.bookID}"/>
                              <input type="submit" value="View Details" />
                          </form>
                        </div>
                    </div>
                </div>
            </c:forEach>   
        </div>  
    </body>
    <%@ include file="footer.jsp" %>
</html>
