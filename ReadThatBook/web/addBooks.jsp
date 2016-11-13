<%-- 
    Document   : addBooks
    Created on : 24 Oct, 2016, 7:30:06 PM
    Author     : Prateek
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">

        <title>Add a Book</title>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@ include file="header.jsp" %>
        <%@ include file="userLogout.jsp" %>        
        <%@ include file="headerClose.jsp" %>
        <br/>
        <h3><center>Add A Book Manually</center></h3>
        <p style="color:white;" align="center"><c:if test="${not empty messageText}"><c:out value="${cookie['userCookie'].value}" /></c:if></p>
        <form action="BookManager" enctype="multipart/form-data" method="POST">
            <input type="hidden" name="action" value="addBook"/>
            <table align="center" style="font-weight:bold;">
                <tbody>
                    <tr>
                        <td>Book Title</td>
                        <td>:</td>
                        <td><input type="text" name="title"/></td>
                    </tr>
                    <tr>
                        <td>ISBN-13</td>
                        <td>:</td>
                        <td><input type="text" name="ISBN_13"/></td>
                    </tr>
                    <tr>
                        <td>ISBN-10</td>
                        <td>:</td>
                        <td><input type="text" name="ISBN_10"/></td>
                    </tr>
                    <tr>
                        <td>Author</td>
                        <td>:</td>
                        <td><input type="text" name="author"/></td>
                    </tr>
                    <tr>
                        <td>Genre</td>
                        <td>:</td>
                        <td><input type="text" name="genre"/></td>
                    </tr>
                    <tr>
                        <td>Edition</td>
                        <td>:</td>
                        <td><input type="text" name="edition"/></td>
                    </tr>
                    <tr>
                        <td>Publisher</td>
                        <td>:</td>
                        <td><input type="text" name="publisher"/></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>:</td>
                        <td><textarea rows="4" cols="21" name="description"></textarea></td>
                    </tr>
                    <tr>
                        <td>Image</td>
                        <td>:</td>
                        <td><input type="file" name="photo"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" style="color:black" /></td>
                        <td>  </td>
                        <td><input type="reset" style="color:black"/></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
    <%@ include file="footer.jsp" %>
</html>
