<%-- 
    Document   : googleSearchResults
    Created on : 11 Nov, 2016, 11:47:41 PM
    Author     : Prateek
--%>
<!DOCTYPE html>
<html>
    <head>
<%@page import="business.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/shop-homepage.css" rel="stylesheet">
<link href="css/userProfile.css" rel="stylesheet">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@ include file="header.jsp" %>
    <%@ include file="userLogout.jsp" %>
    <%@ include file="headerClose.jsp" %>
  
        <h3>Books from Google</h3>
        <p style="color:white;"><c:if test="${not empty message}"><c:out value="${message}"/></c:if></p>
        <form action="GoogleBooksApiServlet" method="POST">
            <input type="hidden" name="action" value="addGoogleBook"/>
            <table>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td><img src="${book.getImageLink()}" alt="${book.getTitle()}"></td>
                        <td>
                            <b>Title :</b><c:out value="${book.getTitle()}"/><br/>
                            <b>Author(s) :</b> ${book.getAuthor()}<br/>
                            <b>Publisher :</b> ${book.getPublisher()}<br/>
                            <b>ISBN10 :</b> ${book.getISBN10()}<br/>
                            <b>ISBN13 :</b> ${book.getISBN13()}<br/>
                            <b>Genre :</b> ${book.getGenre()}<br/>
                            <b>Edition :</b>${book.getEdition()}<br/>
                            <b>Description :</b>${book.getDescription()}<br/>
                            -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                        </td>


                        <td><input type="hidden" name="title" value="<c:out value="${book.getTitle()}"/>" />
                            <input type="hidden" name="ISBN_13" value="<c:out value="${book.getISBN13()}"/>" />
                            <input type="hidden" name="ISBN_10" value="<c:out value="${book.getISBN10()}"/>"/>
                            <input type="hidden" name="author" value="<c:out value="${book.getAuthor()}"/>"/>
                            <input type="hidden" name="genre" value="<c:out value="${book.getGenre()}"/>" />
                            <input type="hidden" name="edition" value="<c:out value="${book.getEdition()}"/>" />
                            <input type="hidden" name="publisher" value="<c:out value="${book.getPublisher()}"/>" />
                            <input type="hidden" name="description" value="<c:out value="${book.getDescription()}"/>"/>
                            <input type="hidden" name="imageLink" value="<c:out value="${book.getImageLink()}"/>"/>

                            <button type="submit" name="Add" value="Add">Add</button></td>
                        
                    </tr>
                    
                    <c:set value="${book}" var="bookN" scope="request"></c:set>
                    
                </c:forEach>
                   

            </table>
        </form>
    </body>
</html>
