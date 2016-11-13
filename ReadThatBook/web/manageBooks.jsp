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
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">

        <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        </style>
        <title>Manage Books</title>
    </head>
    <body style="background-color:#FFF791;">
    
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <label style="color:white;"><h1>ReadThatBook &emsp;&emsp;&emsp;</h1></label>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">                  
                    <li><a href="#">About</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
                <p style="color:red;"><c:if test="${not empty message}"><c:out value="${message}"/></c:if></p>
                <p style="color:red; font-weight:bold; text-align:right;">Welcome <c:out value="${user.firstName}" ></c:out></p>
                <form name="logout" action="LoginServlet" method="post" align="right">
                    <input type="submit" name="logout" value="logout"/>
                    <input type="hidden" name="action" value="logout"/>
                </form>
                <br/>
            </div>
        </div>
    </nav>
<br/>
<br/>
    <h2>Add book from Google Books</h2>
    <form action="GoogleBooksApiServlet" method="POST">
        <input type="text" placeholder="Title or Author" name="query"/>
        <input type="submit" name="Search" value="Search"/>
        <p style="color:red;"><c:if test="${not empty messageText}"><c:out value="${messageText}"/></c:if></p>
    </form>
        <div id="results"></div>
        <br>
        <div><a class="btn" href="BookManager?action=addBookPage">Add Books Manually</a></div>
        <br>
        <h2>Book Details </h2>
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
                        <td><c:out value="${book.getISBN10()}"/></td>
                        <td><c:out value="${book.getISBN13()}"/></td>
                        <td><a href="<c:url value="BookManager?action=updateBookPage&bookID=${book.getBookID()}"/>">Edit</a></td>
                        <td><a href="<c:url value="BookManager?action=deleteBook&bookID=${book.getBookID()}"/>">Delete</a></td>
                    </tr>
                </c:forEach>          
        </table>       
        </div>
        <br>
    </body>
</html>
