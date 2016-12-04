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
    <body style="background-color:#F1F4FF;">
        <%@ include file="defaultNav.jsp" %>
        <p style="color:white; font-weight:bold; text-align:right;">${cookie.userCookie.value}</p>
        <c:if test="${searchErrorMessage != null}">
            <p style="color:red; font-weight:bold; text-align:center;">${searchErrorMessage}</p>  
        </c:if>
        <c:if test="${wishMessage != null}">
            <p style="color:red; font-weight:lighter; text-align:center;">${wishMessage}</p>
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
