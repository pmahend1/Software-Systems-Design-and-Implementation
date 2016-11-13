<%-- 
    Document   : googleSearchResults
    Created on : 11 Nov, 2016, 11:47:41 PM
    Author     : Prateek
--%>

<%@page import="business.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Books</h2>
        <p style="color:red;"><c:if test="${not empty message}"><c:out value="${message}"/></c:if></p>
        <form action="GoogleBooksApiServlet" method="POST">
            <input type="hidden" name="action" value="addGoogleBook"/>
            <table>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td><img src="${book.getImageLink()}" alt="${book.getTitle()}"></td>
                        <td>
                            <b>Title :</b><c:out value="${book.getTitle()}"/><br/>
                            Author(s) : ${book.getAuthor()}<br/>
                            Publisher : ${book.getPublisher()}<br/>
                            ISBN10 : ${book.getISBN10()}<br/>
                            ISBN13 : ${book.getISBN13()}<br/>
                            Genre : ${book.getGenre()}<br/>
                            Edition :${book.getEdition()}<br/>
                            Description :${book.getDescription()}<br/>
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
