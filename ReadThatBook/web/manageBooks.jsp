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
        <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        </style>
        <title>Manage Books</title>
    </head>
    <body>
        <h2>Add book from Google Books</h2>
        <input id="search" placeholder="Title or Author"/>
        <button id="button" type="button">Search</button>
        <div id="results"></div>
        <br>
        <h2>Book Details </h2>
        <div><a href="BookManager?action=addBookPage">Add Books Manually</a></div>
        <br>
        <br>
        <div>
        <table>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Edition</th>
                    <th>Genre</th>
                    <th>ISBN10</th>
                    <th>ISBN13</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items="${bookList}" var="book">
                    <tr>
                        <td><c:out value="${book.getTitle()}"/></td>
                        <td><c:out value="${book.getAuthor()}"/></td>
                        <td><c:out value="${book.getEdition()}"/></td>
                        <td><c:out value="${book.getGenre()}"/></td>
                        <td><c:out value="${book.getISBN_10()}"/></td>
                        <td><c:out value="${book.getISBN_13()}"/></td>
                        <td><a href="<c:url value="BookManager?action=updateBookPage&bookID=${book.getBookID()}"/>">Edit</a></td>
                        <td><a href="<c:url value="BookManager?action=deleteBook&bookID=${book.getBookID()}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
                    
        </table>
            
                
        </div>
        <br>
        
        

    </body>
</html>