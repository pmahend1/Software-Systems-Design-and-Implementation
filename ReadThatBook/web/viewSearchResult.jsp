<%-- 
    Document   : viewSearchResult
    Created on : Nov 10, 2016, 5:23:45 PM
    Author     : ashwini
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Home Page</title>
        <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">

    </head>

    <body style="background-color:#F1F4FF;">
        <%@ include file="header.jsp" %>
        <%@ include file="headerClose.jsp" %>
        <br/>
        <br/>
        
        <div class="row">
            <c:forEach items="${bookResult}" var="item">
                <div class="col-sm-4 col-lg-4 col-md-4">
                    <div class="thumbnail">
                        <img src="http://placehold.it/320x150" alt="">
                        <div class="caption">
                          <h3 align="center">${item.title}</h3>
                          <h4 align="center">By:${item.author}</h4> 
                          <form name="viewBook" action="BookListServlet" method="post">
                              <input type="hidden" name="action" value="viewBook"/>
                              <input type="hidden" name="bookid" value="${item.bookID}"/>
                              <input type="submit" value="View Details" />
                          </form>
                        </div>
                    </div>
                </div>
            </c:forEach>   
        </div>
        
        <%@ include file="footer.jsp" %>
    </body>
</html>
