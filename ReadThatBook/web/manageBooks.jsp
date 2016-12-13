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
        
        <c:if test="${message != null}">
            <div class="row">
            <div class="alert alert-success alert-dismissible col-md-6 col-md-offset-3">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                <center><strong><c:out value="${message}"/></strong></center> 
            </div></div>
        </c:if>
        
        <h4 class="well well-sm" style="width:450px">Add Books from Google Books Library</h4>
        <form class="form" role="form" action="GoogleBooksApiServlet" method="POST">
            <div class="row">
                <div class="col-lg-4"><div class="form-group">
                        <input type="text" class="form-control" placeholder="Title or Author" name="query" style="width: 450px">
                    </div></div>
                <div class="col-lg-6"><button type="submit" class="btn btn-primary btn-sm" name="Search">Search</button></div>    
            </div>
            <c:if test="${not empty messageText}">
                <div class="row">
                    <div class="alert alert-danger alert-dismissible col-md-6 col-md-offset-3">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                        <center><strong><c:out value="${messageText}"/></strong></center> 
                    </div>
                </div>
            </c:if>
        </form>
        <div id="results"></div>
        <br>
        <div class="row">
            <div class="col-lg-5    ">
                <h4 class="well well-sm">Could not find book in Goolge Library?&emsp;&emsp;<a class="btn btn-primary" href="BookManager?action=addBookPage">Add Books Manually</a></div></h4>
            </div>
        <br>
   
        <div>
            <table class="table table-striped">
                <h4 align="center" class="h3">Book Details</h4>
                <thead class="well well-lg">
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
                </thead>
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
