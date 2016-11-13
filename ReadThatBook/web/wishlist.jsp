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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wishlist Page</title>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@ include file="header.jsp" %>
        <p style="color:white; font-weight:bold; text-align:right;"><c:out value="${cookie['userCookie'].value}"  ></c:out></p>
        <%@ include file="userLogout.jsp" %>
        <%@ include file="headerClose.jsp" %>
        <h3 align="center">My Wishlist</h3>
        <table align="center" style="align-items: middle; border:1px solid black;">
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
                            <input type="hidden" name="bookid" value=${item.bookID}/>
                            <input type="submit" value="View" />
                        </form>
                    </td>
                    <td>
                        <form name="deleteWishlist" action="WishlistServlet" method="post" align="center">
                            <input type="hidden" name="action" value="deleteWishlist"/>
                            <input type="hidden" name="username" value="${user.getUserName()}"/>
                            <input type="hidden" name="bookid" value=${item.bookID}/>
                            <input type="hidden" name="books" value="${books}"/>
                            <input type="submit" value="Remove" />
                        </form>
                    </td>
                </tr>           

            </c:forEach>   
        </table> 

        <form name="viewhome" action="LoginServlet" method="post">
            <input type="hidden" name="username" value="${user.getUserName()}"</input>
            <input type="hidden" name="action" value="backHome">
            <center><input type="submit" value="Back to homepage" 
                   style="background-color: grey; 
                   border: none;
                   color: white;
                   padding: 15px 32px;
                   text-align: center;
                   text-decoration: none;
                   display: inline-block;
                   font-size: 16px;
                   margin: 4px 2px;
                   cursor: pointer;"/></center>
        </form>
    </body>
    <%@ include file="footer.jsp" %>
</html>
