<%-- 
    Document   : manageBooks
    Created on : 23 Oct, 2016, 9:06:10 PM
    Author     : Prateek
--%>

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
        <a href="BookManager?action=deleteBook&bookID=2">Delete Books</a>
        
    </body>
</html>