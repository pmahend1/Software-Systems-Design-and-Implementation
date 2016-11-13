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
<body  style="background-color: #e3e8f8">
        <%@ include file="header.jsp" %>
        <%@ include file="headerClose.jsp" %>
        <br/><br/>
        <!-- Page Content -->
        <form name="rate" action="RatingManager" method="post">
            <input type="hidden" name="action" value="rateBook" />
            <table align="center">
                <tr>
                    <td>BookID </td>
                    <td><c:out value="${book.getBookID()}"></c:out><input type="hidden" name="bookID" value="${book.getBookID()}" /></td>
                    </tr>
                    <tr>
                        <td>Autdor </td>
                        <td><c:out value="${book.getAuthor()}"></c:out></td>
                    </tr>   
                    <tr>
                        <td>Title</td>
                        <td><c:out value="${book.getTitle()}"></c:out></td>
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
                        <td><input type="number" name="rating"  value="${rating}" id="rating-empty-clearable" class="rating" data-clearable/></td>  

                </tr>
                <tr>
                    <td><h3>${avgRating}</h3> <h5>/10</h5> <h6> ${votes} votes</h6> </td>
                    <td><input type="submit" name="Submit" value="Rate"/></td>
                </tr>
            </table>


        </form>

                    
    <c:choose>

        <c:when test="${showtextarea}">
            <form name="review" action="ReviewManager" method="post">
            <input type="hidden" name="action" value="editreviewBook" />
            <table align="center" style="width:50%">
                <tr>
                    <td>
                        <input type="hidden" name="bookID" value="${book.getBookID()}" />
                        <textarea name='review' id='review' class="textarea" value="${editreviewvalue}"></textarea><br />
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
    
                    <div >
            
        <table style="background-color:cornsilk;padding:20px;width: 50%; " align="center">
            <th>Reviews:</th>
            <c:forEach items="${reviewlist}" var="review">  
              <tr>
                  <td><b><c:out value="${review.getUserName()}" /></b>
                  <input type="number" name="rating" value="${review.getUserrating()}" id="rating-readonly" class="rating" data-clearable="remove" data-readonly /></td> 
              </tr>
                <tr>
                    <td ><font color="blue"><c:out value="${review.getReview()}"/></font></td>
                    
                    <c:choose>
                        <c:when test = "${review.getUserName() eq user}" >
                            
                            <form name="editreview" action="ReviewManager" method="post">
                            <input type="hidden" name="action" value="editreview" />
                            <input type="hidden" name="bookID" value="${book.getBookID()}" />
                            <td><input type="submit" name="Submit" value="edit review"/></td>
                            </form>

                        </c:when>
                        <c:otherwise>
                            
                        </c:otherwise>
                    </c:choose>
                    
              </tr>
            </c:forEach>
        </table>
        </div> 
                    
    <div class="container">
            <hr>
            <!-- Footer -->
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p align="center">Copyright &copy; ReadThatBook 2016</p>
                    </div>
                </div>
            </footer>
        </div>
        <!-- /.container -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
    </body>
    <%@ include file="footer.jsp" %>
</html>

