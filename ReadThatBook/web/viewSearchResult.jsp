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
        <title>Search Results</title>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
        <link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css" rel="stylesheet" type="text/css" />      
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
        <link href="css/userProfile.css" rel="stylesheet">
        <script src="js/userProfile.js"></script>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@ include file="defaultNav.jsp" %>
        <br/>
        <br/>
        <div class="row">
            <c:forEach items="${bookResult}" var="item">
                <div class="col-sm-3 col-lg-3 col-md-3">
                    <div class="thumbnail" style="width:200px;height:400px">
                        <!--<img src="${pageContext.request.contextPath}/images/${item.bookID}" style="width:200px;height: 300px" alt="No image"/>-->


                        <form name="viewBook" action="BookListServlet" method="post">
                            <input type="hidden" name="action" value="viewBook"/>
                            <input type="hidden" name="bookid" value="${item.bookID}"/>
                            <center><input type="image" src="${pageContext.request.contextPath}/images/${item.bookID}" class="thumbnail" style="width:200px;height: 300px" alt="No Image"/></center>
                        </form>
                        <div class="text-center" align="center">
                            <h5 class="text text-muted"><b>${item.title}</b></h5>
                            <h6 class="text text-muted">By:${item.author}</h6>                                         
                        </div>

                    </div>
                </div>
            </c:forEach>   
        </div>

        <%@ include file="footer.jsp" %>
    </body>
</html>
