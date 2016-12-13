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
        <title>Read That Book</title>
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
    </head>
    <body style="background-color:#F1F4FF;">
        <%@ include file="defaultNav.jsp" %>
        <br>
        
        <c:if test="${searchErrorMessage != null}">
            <div class="row">
            <div class="alert alert-danger alert-dismissible col-md-6 col-md-offset-3">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                <center><strong><c:out value="${searchErrorMessage}"/></strong></center> 
            </div></div>  
        </c:if>
        <c:if test="${wishMessage != null}">
            <div class="row">
            <div class="alert alert-success alert-dismissible col-md-6 col-md-offset-3">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                <center><strong><c:out value="${wishMessage}"/></strong></center> 
            </div></div>
        </c:if>
         <c:if test="${message != null}">
            <div class="row">
            <div class="alert alert-success alert-dismissible col-md-6 col-md-offset-3">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                <center><strong><c:out value="${message}"/></strong></center> 
            </div></div>
        </c:if>
        
        <div class="row">
            <c:forEach items="${books}" var="item">
                <div class="col-sm-3 col-lg-3 col-md-3">
                    <div class="thumbnail" style="width:280px;height:420px">
<!--                        <img src="${pageContext.request.contextPath}/images/${item.bookID}" alt="No image"/>-->
                            <div>
                                <form name="viewBook" action="BookListServlet" method="post" align="center">
                                    <input type="hidden" name="action" value="viewBook">
                                    <input type="hidden" name="bookid" value=${item.bookID}>
                                    <input type="image" src="${pageContext.request.contextPath}/images/${item.bookID}" class="thumbnail center-block" style="width:250px;height: 300px" alt="No Image" />
                                </form>
                                
                                <div class="text-center" align="center">
                                    <h5 class="text text-muted"><b>${item.title}</b></h5>
                                    <h6 class="text text-muted">By:${item.author}</h6>                                         
                                </div> 
                                <div class="center-block">
                                    <form name="addToWishlist" action="WishlistServlet" method="post" align="center">
                                        <input type="hidden" name="action" value="addToWishlist"/>
                                        <input type="hidden" name="username" value="${user.getUserName()}"/>
                                        <input type="hidden" name="bookid" value="${item.bookID}"/>
                                        <input type="hidden" name="books" value="${books}"/>
                                        <button type="submit" class="btn btn-primary btn-sm">Add to Wishlist</button>
                                    </form>
                                </div>
                            </div>

                    </div>
                </div>
            </c:forEach> 
        </div>    
    </body>
</html>
