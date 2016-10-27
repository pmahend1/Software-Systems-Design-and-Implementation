<%-- 
    Document   : manageBooks
    Created on : 23 Oct, 2016, 9:06:10 PM
    Author     : Prateek
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="scripts/angular.min.js"></script>
        <script src="scripts/angular.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
        <script src="js/manageBooks.js"></script>
        <title>Manage Books</title>
    </head>
    <body>
        <h1>Add book from Google Books</h1>
        <input id="search" placeholder="Title or Author"/>
        <button id="button" type="button">Search</button>
        <div id="results"></div>
        <table>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${bookList}" var="book">
                    <tr>
                        <td><c:out value="${book.getTitle()}"/></td>
                        <td><c:out value="${book.getAuthor()}"/></td>
                        <td><c:out value="${book.getEdition()}"/></td>
                        <td><c:out value="${book.getGenre()}"/></td>
                        <td><c:out value="${book.getISBN_10()}"/></td>
                        <td><c:out value="${book.getISBN_13()}"/></td>
                        </tr>
                </c:forEach>
        </table>


        <a href="BookManager?action=deleteBook&bookID=2">Delete Books</a>
        <a href="BookManager?action=addBookPage">Add Books</a>

    </body>
</html>