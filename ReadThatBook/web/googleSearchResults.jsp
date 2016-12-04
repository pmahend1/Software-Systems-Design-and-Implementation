<%-- 
    Document   : googleSearchResults
    Created on : 11 Nov, 2016, 11:47:41 PM
    Author     : Prateek
--%>
<!DOCTYPE html>
<html>
    <head>
        <%@page import="business.Book"%>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link href="css/shop-homepage.css" rel="stylesheet">
        <link href="css/userProfile.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Google Search Results</title>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@ include file="defaultNav.jsp" %>
        <div class="container">
            <h3 class="h3">Books from Google</h3>
            <p style="color:white;"><c:if test="${not empty message}"><c:out value="${message}"/></c:if></p>
                
                    <input type="hidden" name="action" value="addGoogleBook"/>
                    <table class="table table-striped">
                    <c:forEach items="${books}" var="book">
                        <tr>
                            <td><img src="${book.getImageLink()}" alt="${book.getTitle()}"></td>
                            <td>
                                <b>Title :</b><c:out value="${book.getTitle()}"/><br/>
                                <b>Author(s) :</b> ${book.getAuthor()}<br/>
                                <b>Publisher :</b> ${book.getPublisher()}<br/>
                                <b>ISBN10 :</b> <c:out value="${book.getISBN10()}"/><br/>
                                <b>ISBN13 :</b> <c:out value="${book.getISBN13()}"/><br/>
                                <b>Genre :</b> ${book.getGenre()}<br/>
                                <b>Description :</b>${book.getDescription()}<br/>
                            </td>

                            <td><form class="form" role="form" action="GoogleBooksApiServlet" method="POST">
                                    <input type="hidden" name="action" value="addGoogleBook"/>
                                    <input type="hidden" name="title" value="${book.getTitle()}">
                                    <input type="hidden" name="ISBN_13" value="${book.getISBN13()}">
                                    <input type="hidden" name="ISBN_10" value="${book.getISBN10()}">
                                    <input type="hidden" name="author" value="${book.getAuthor()}">
                                    <input type="hidden" name="genre" value="${book.getGenre()}">
                                    <input type="hidden" name="publisher" value="${book.getPublisher()}">
                                    <input type="hidden" name="description" value="${book.getDescription()}">
                                    <input type="hidden" name="imageLink" value="<c:out value="${book.getImageLink()}"/>">
                                    <input type="submit" class="btn btn-primary btn-sm" name="Add" value="Add"> </form></td>
                        </tr>  
                    </c:forEach>
                    </table>
        </div>

    </body>
</html>
