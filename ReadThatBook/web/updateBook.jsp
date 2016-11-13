<%-- 
    Document   : updateBook
    Created on : 29 Oct, 2016, 7:43:33 PM
    Author     : Prateek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
        <title>Update Book</title>
    </head>
    <body  style="background-color: #e3e8f8">
        <%@ include file="header.jsp" %>
        <%@ include file="userLogout.jsp" %> 
        <%@ include file="headerClose.jsp" %>
        
        <h3><center>Update Book</center></h3>
         <form action="BookManager" enctype="multipart/form-data" method="POST">
            <input type="hidden" name="action" value="updateBook"/>
            <input type="hidden" name="bookID" value="${book.getBookID()}"/>
            <table align="center" style="font-weight:bold;">
                <tbody>
                    <tr>
                        <td>Book Title</td>
                        <td>:</td>
                        <td><input type="text" name="title" value="${book.getTitle()}"/></td>
                    </tr>
                    <tr>
                        <td>ISBN-13</td>
                        <td>:</td>
                        <td><input type="text" name="ISBN_13" value="${book.getISBN13()}"/></td>
                    </tr>
                    <tr>
                        <td>ISBN-10</td>
                        <td>:</td>
                        <td><input type="text" name="ISBN_10" value="${book.getISBN10()}"/></td>
                    </tr>
                    <tr>
                        <td>Author</td>
                        <td>:</td>
                        <td><input type="text" name="author" value="${book.getAuthor()}"/></td>
                    </tr>
                    <tr>
                        <td>Genre</td>
                        <td>:</td>
                        <td><input type="text" name="genre" value="${book.getGenre()}"/></td>
                    </tr>
                    <tr>
                        <td>Edition</td>
                        <td>:</td>
                        <td><input type="text" name="edition" value="${book.getEdition()}"/></td>
                    </tr>
                    <tr>
                        <td>Publisher</td>
                        <td>:</td>
                        <td><input type="text" name="publisher" value="${book.getPublisher()}"/></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>:</td>
                        <td><textarea rows="3" cols="21" name="description">${book.getDescription()}</textarea></td>
                    </tr>
                    <tr>
                        <td>Image</td>
                        <td>:</td>
                        <td><input type="file" name="photo"/>* Choose JPG,PNG</td>
                    </tr>
                <br>
                    <tr>
                        <td><input type="submit" name="Update" value="Update" style="color:black"/></td>
                        <td>  </td>
                        <td><input type="reset" name="Reset" style="color:black"/></td>
                    </tr>
                </tbody>
            </table>


        </form>
    </body>
    <%@ include file="footer.jsp" %>
</html>
