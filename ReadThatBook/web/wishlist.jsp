<%-- 
    Document   : wishlist
    Created on : Nov 10, 2016, 8:06:35 PM
    Author     : Sweet_Home
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="business.User" %>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wishlist Page</title>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@ include file="defaultNav.jsp" %>
        <br/>
        <h3 align="center">My Wishlist</h3>
        <table align="center" class="table-striped" style="align-items: middle">
            <tr>
                <th style="border:1px solid black;">Book Title</th>
                <th style="border:1px solid black;">Book Author</th> 
                <th style="border:1px solid black;">View</th> 
                <th style="border:1px solid black;">Remove</th>
            </tr>

            <c:forEach items="${books}" var="item">
                <tr style="border:1px solid black;">
                    <td style="border:1px solid black;">${item.title}</td>
                    <td style="border:1px solid black;">${item.author}</td> 
                    <td style="border:1px solid black;">
                        <form name="viewBook" action="BookListServlet" method="post" align="center">
                            <input type="hidden" name="action" value="viewBook">
                            <input type="hidden" name="bookid" value=${item.bookID}>
                            <input type="submit" class="btn btn-primary btn-xs" value="View" />
                        </form>
                    </td>
                    <td>
                        <form name="deleteWishlist" action="WishlistServlet" method="post" align="center">
                            <input type="hidden" name="action" value="deleteWishlist"/>
                            <input type="hidden" name="username" value="${user.getUserName()}"/>
                            <input type="hidden" name="bookid" value=${item.bookID}>
                            <input type="hidden" name="books" value="${books}"/>
                            <input type="submit" class="btn btn-primary btn-xs" value="Remove" />
                        </form>
                    </td>
                </tr>           

            </c:forEach>   
        </table> 

        <form name="viewhome" action="LoginServlet" method="post">
            <input type="hidden" name="username" value="${user.getUserName()}"></input>
            <input type="hidden" name="action" value="backHome">
            <br/>
            <center><input type="submit" value="Back to homepage" class="btn btn-primary btn-sm"/></center>
        </form>
    </body>
    <%@ include file="footer.jsp" %>
</html>
