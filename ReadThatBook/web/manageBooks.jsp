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
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
        <link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css" rel="stylesheet" type="text/css" />      
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
        <link href="css/userProfile.css" rel="stylesheet">
        <script src="js/userProfile.js"></script>

        <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        </style>
        <title>Manage Books</title>
    </head>
    <body style="background-color:#F1F4FF;">
        <!--#e3e8f8-->
	 <%@ include file="defaultNav.jsp" %>
	<br/>
    <h4>Add book from Google Books</h4>
    <form action="GoogleBooksApiServlet" method="POST">
        <input type="text" placeholder="Title or Author" name="query" style="width: 450px"/>
        <input type="submit" class="btn btn-primary btn-sm" name="Search" value="Search"/>
        <p style="color:red;"><c:if test="${not empty messageText}"><c:out value="${messageText}"/></c:if></p>
    </form>
        <div id="results"></div>
        <br>
        <div><a class="btn btn-primary" href="BookManager?action=addBookPage">Add Books Manually</a></div>
        <br>
        <h3 align="center">Book Details </h3>
        <br>
        <div>
        <table class="table table-striped">
            <thead class="thead-default">
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
            </thead>>
                <c:forEach items="${bookList}" var="book">
                    <tr>
                        <td><c:out value="${book.getTitle()}"/></td>
                        <td><c:out value="${book.getAuthor()}"/></td>
                        <td><c:out value="${book.getEdition()}"/></td>
                        <td><c:out value="${book.getGenre()}"/></td>
                        <td><c:out value="${book.getISBN10()}"/></td>
                        <td><c:out value="${book.getISBN13()}"/></td>
                        <td><center><a href="<c:url value="BookManager?action=updateBookPage&bookID=${book.getBookID()}"/>" class ="btn btn-primary btn-xs">Edit</a></center></td>
                        <td><a href="<c:url value="BookManager?action=deleteBook&bookID=${book.getBookID()}"/>" class ="btn btn-primary btn-xs">Delete</a></td>
                    </tr>
                </c:forEach>          
        </table>       
        </div>
        <br>
    </body>
    <%@ include file="footer.jsp" %>
</html>
