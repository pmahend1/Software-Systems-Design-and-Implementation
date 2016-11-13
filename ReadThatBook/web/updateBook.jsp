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
    <body style="background-color:#FFF791;">
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
                    <form name="logout" action="LoginServlet" method="post" align="right">
                        <input type="submit" name="logout" value="logout"/>
                        <input type="hidden" name="action" value="logout"/>
                    </form>
                    <br/>
                </div>
            </div>
        </nav>
        <h3><center>Update Book</center></h3>
         <form action="BookManager" enctype="multipart/form-data" method="POST">
            <input type="hidden" name="action" value="updateBook"/>
            <input type="hidden" name="bookID" value="${book.getBookID()}"/>
            <table align="center" style="color:brown; font-weight:bold;">
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
</html>
