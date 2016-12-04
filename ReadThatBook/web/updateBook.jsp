<%-- 
    Document   : updateBook
    Created on : 29 Oct, 2016, 7:43:33 PM
    Author     : Prateek
--%>

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
        <title>Update Book</title>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@ include file="defaultNav.jsp" %>
        
        <h3><center>Update Book</center></h3>
         <form action="BookManager" enctype="multipart/form-data" method="POST">
            <input type="hidden" name="action" value="updateBook"/>
            <input type="hidden" name="bookID" value="${book.getBookID()}"/>
            <table align="center">
                <td><img src="${pageContext.request.contextPath}/images/${book.getBookID()}" style="width:320px;height: 420px" alt="No image"/></td>
                <td>
                    <table align="center">
                <tbody>
                    <tr>
                        <td style="font-weight: bold">Book Title</td>
                        <td>:</td>
                        <td><input type="text" name="title" value="${book.getTitle()}"/></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold">ISBN-13</td>
                        <td>:</td>
                        <td><input type="text" name="ISBN_13" value="${book.getISBN13()}"/></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold">ISBN-10</td>
                        <td>:</td>
                        <td><input type="text" name="ISBN_10" value="${book.getISBN10()}"/></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold">Author</td>
                        <td>:</td>
                        <td><input type="text" name="author" value="${book.getAuthor()}"/></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold">Genre</td>
                        <td>:</td>
                        <td><input type="text" name="genre" value="${book.getGenre()}"/></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold">Edition</td>
                        <td>:</td>
                        <td><input type="text" name="edition" value="${book.getEdition()}"/></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold">Publisher</td>
                        <td>:</td>
                        <td><input type="text" name="publisher" value="${book.getPublisher()}"/></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold">Description</td>
                        <td>:</td>
                        <td><textarea rows="3" cols="21" name="description">${book.getDescription()}</textarea></td>
                    </tr>
                    <tr>
                        <td style="font-weight: bold">Image</td>
                        <td>:</td>
                        <td><input type="file" name="photo"/><p style="color:red">* Choose JPG,PNG </p></td>
                    </tr>
                <br>
                    <tr>
                        <td>  </td>
                        <td style="font-weight: bold"><input type="submit" name="Update" value="Update" style="color:black"/></td>
                        <td></td>
<!--                        <td style="font-weight: bold"><input type="reset" name="Reset" style="color:black"/></td>-->
                    </tr>
                </tbody>
            </table>
                </td>
            </table>         

        </form>
    </body>
    <%@ include file="footer.jsp" %>
</html>
