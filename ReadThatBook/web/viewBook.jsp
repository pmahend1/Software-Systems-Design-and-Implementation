<%-- 
    Document   : viewBook
    Created on : Oct 26, 2016, 7:03:37 PM
    Autdor     : Sweet_HomegetBookID
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="widtd=device-widtd, initial-scale=1">
        <meta name="description" content="">
        <meta name="autdor" content="">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Home Page</title>
        <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
        <!-- <script src="src/bootstrap-rating-input.js"></script> -->
        <script src="js/bootstrap-rating-input.min.js"></script>
        <script>
            $(function () {
                $('input').on('change', function () {
                    alert("Changed: " + $(this).val())
                });
            });
        </script>

        <style>
            textarea {
                width: 750px;
                height: 120px;
                border: 3px solid #cccccc;
                padding: 5px;
                font-family: Tahoma, sans-serif;
                background-image: url(bg.gif);
                background-position: bottom right;
                background-repeat: no-repeat;
            }
        </style>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@ include file="header.jsp" %>
        <%@ include file="headerClose.jsp" %>
        <br/><br/>
        <!-- Page Content -->
        <form name="rate" action="RatingManager" method="post">
            <input type="hidden" name="action" value="rateBook" />
            <table align="center">
                <tr>
                    <td><img src="${pageContext.request.contextPath}/images/${book.bookID}" style="width:200px;height: 300px" alt="No image"/></td>
                    <td>
                        <table align="center">
                                <tr>
                                    <td>Title</td>
                                    <td><c:out value="${book.getTitle()}"></c:out></td>
                                </tr>
                                <tr>
                                    <td>Author </td>
                                    <td><c:out value="${book.getAuthor()}"></c:out></td>
                                </tr> 
                                <tr>
                                    <td>Genre </td>
                                    <td><c:out value="${book.getGenre()}"></c:out></td>
                                </tr>
                                <tr>
                                    <td>Description </td>
                                    <td><c:out value="${book.getDescription()}"></c:out></td>
                                </tr>
                                <tr>
                                    <td>Edition </td>
                                    <td><c:out value="${book.getEdition()}"></c:out></td>
                                </tr>
                                <tr>
                                    <td> Rating</td>
                                <c:if test="${not empty user}">
                                    <td><input type="number" name="rating"  value="${rating}" id="rating-empty-clearable" class="rating" data-clearable/></td>  
                                </c:if>
                                <c:if test="${empty user}">
                                <td><input type="number" name="rating" value="${avgRatinginDouble}" id="rating-readonly" class="rating" data-clearable="remove" data-readonly /></td> 
                                </c:if>
                            </tr>
                            <c:if test="${not empty user}">
                                <tr>
                                   <input type="hidden" name="bookID" value="${book.getBookID()}" />
                                    <td><input type="submit" name="Submit" value="Rate"/></td>
                                </tr>
                            </c:if>
                                
                            
                        </table>
                    </td>
                </tr>
            </table>
                                    <center><h4>Average Rating :${avgRating}/10</h4> <h5> ${votes} votes</h5></center>

       </form>

<c:if test="${not empty user}">
                               
                            
        <c:choose>

            <c:when test="${showtextarea}">
                <form name="review" action="ReviewManager" method="post">
                    <input type="hidden" name="action" value="editreviewBook" />
                    <table align="center" style="width:50%">
                        <tr>
                            <td>
                                <input type="hidden" name="bookID" value="${book.getBookID()}" />
                                <textarea name='review' id='review' class="textarea">${editreviewvalue}</textarea><br />
                                <input type="submit" name="Submit" value="edit review"/>
                            </td>
                        </tr>    

                    </table>
                </form>
            </c:when>
            <c:when test = "${reviewexists}" >

            </c:when>
            <c:otherwise>
                <form name="review" action="ReviewManager" method="post">
                    <input type="hidden" name="action" value="reviewBook" />
                    <table align="center" style="width:50%">
                        <tr>
                            <td>
                                <input type="hidden" name="bookID" value="${book.getBookID()}" />
                                <textarea name='review' id='review' class="textarea"></textarea><br />
                                <input type="submit" name="Submit" value="AddReview"/>
                            </td>
                        </tr>    

                    </table>
                </form>
            </c:otherwise>
        </c:choose>
</c:if>
        <div >
            <c:if test="${not empty reviewlist}"><table style="background-color:cornsilk;padding:20px;width: 50%; " align="center">
                <th>Reviews:</th>
                    <c:forEach items="${reviewlist}" var="review">  
                    <tr>
                        <td><b><c:out value="${review.getUserName()}" /></b>
                            <c:if test="${review.getUserRole() eq 'Critic'}">
                                <b class="text-warning">[Critic]</b>                             
                            </c:if>
                            <input type="number" name="rating" value="${review.getUserrating()}" id="rating-readonly" class="rating" data-clearable="remove" data-readonly /></td> 
                    </tr>
                    <tr>
                        <td width="70%"><font color="blue"><c:out value="${review.getReview()}"/></font></td>

                        <c:choose>
                            <c:when test = "${review.getUserName() eq user}" >

                            <form name="editreview" action="ReviewManager" method="post">
                                <input type="hidden" name="action" value="editreview" />
                                <input type="hidden" name="bookID" value="${book.getBookID()}" />
                                
                                <td width="20%"><input type="submit" name="buttonStatus" value="Edit" class="btn btn-success" />
                                <input type="submit" name="buttonStatus" value="Delete" class="btn btn-danger" /></td>
                            </form>

                        </c:when>
                        <c:otherwise>

                        </c:otherwise>
                    </c:choose>

                    </tr>
                </c:forEach>
            </table></c:if>
            
        </div> 
        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
    </body>
    <%@ include file="footer.jsp" %>
</html>

