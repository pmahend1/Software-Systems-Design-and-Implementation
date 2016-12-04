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
        <title>View Book Page</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="widtd=device-widtd, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
        <!-- <script src="src/bootstrap-rating-input.js"></script> -->
        <script src="js/bootstrap-rating-input.min.js"></script>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
        <link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css" rel="stylesheet" type="text/css" />      
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
        <link href="css/userProfile.css" rel="stylesheet">
        <script src="js/userProfile.js"></script>
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
        <%@ include file="defaultNav.jsp" %>
        <br/><br/>
        <form name="rate" action="RatingManager" method="post">
            <input type="hidden" name="action" value="rateBook" />
            <table align="center">
                <tr>
                    <td><img src="${pageContext.request.contextPath}/images/${book.bookID}" style="width:200px;height: 300px" alt="No image"/></td>
                    <td>
                        <table class="table table-striped" align="center">
                            <tr>
                                <td><b>Title</b></td>
                                <td><c:out value="${book.getTitle()}"></c:out></td>
                                </tr>
                                <tr>
                                    <td><b>Author</b></td>
                                    <td><c:out value="${book.getAuthor()}"></c:out></td>
                                </tr> 
                                <tr>
                                    <td><b>Genre</b></td>
                                    <td><c:out value="${book.getGenre()}"></c:out></td>
                                </tr>
                                <tr>
                                    <td><b>Description</b></td>
                                    <td><c:out value="${book.getDescription()}"></c:out></td>
                                </tr>
                                <tr>
                                    <td><b>Edition</b></td>
                                    <td><c:out value="${book.getEdition()}"></c:out></td>
                                </tr>
                                <tr>
                                    <td><b>Rating</b></td>
                                <c:if test="${not empty userName}">
                                    <td><input type="number" name="rating"  value="${rating}" id="rating-empty-clearable" class="rating" data-clearable/>
                                        <c:if test="${not empty userName}">
                                          <input type="hidden" name="bookID" value="${book.getBookID()}" />
                                        <input type="submit" name="Submit" class="btn btn-primary btn-sm" value="Rate"/></td>
                                        </c:if>
                                    </td>  
                                </c:if>
                                <c:if test="${empty userName}">
                                    <td><input type="number" name="rating" value="${avgRatinginDouble}" id="rating-readonly" class="rating" data-clearable="remove" data-readonly /></td> 
                                    </c:if>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <center><h4>Average Rating :${avgRating}/10</h4> <h5> ${votes} votes</h5></center>
        </form>
        <c:if test="${not empty userName}">
            <c:choose>
                <c:when test="${showtextarea}">
                    <form name="review" action="ReviewManager" method="post">
                        <input type="hidden" name="action" value="editreviewBook" />
                        <table align="center" style="width:50%">
                            <tr>
                                <td>
                                    <input type="hidden" name="bookID" value="${book.getBookID()}" />
                                    <textarea name='review' id='review' class="textarea">${editreviewvalue}</textarea><br />
                                    <input type="submit" name="Submit" class="btn btn-primary btn-sm" value="edit review"/>
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
                                    <input type="submit" name="Submit" class="btn btn-primary btn-sm" value="AddReview"/>
                                </td>
                            </tr>    

                        </table>
                    </form>
                </c:otherwise>
            </c:choose>
        </c:if>
        <div >
            <c:if test="${not empty reviewlist}"><table style="background-color:cornsilk;padding:20px;width: 50%;" align="center">
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
                                <c:when test = "${review.getUserName() eq userName}" >

                                <form name="editreview" action="ReviewManager" method="post">
                                    <input type="hidden" name="action" value="editreview" />
                                    <input type="hidden" name="bookID" value="${book.getBookID()}" />

                                    <td width="20%"><input type="submit" name="buttonStatus" value="Edit" class="btn btn-primary btn-sm" />
                                        <input type="submit" name="buttonStatus" value="Delete" class="btn btn-primary btn-sm" /></td>
                                </form>

                            </c:when>
                            <c:otherwise>
                                <c:if test="${not empty userName}">
                                    <form name="reportSpam" action="SpamServlet" method="post">
                                        <input type="hidden" name="action" value="reportSpam" />
                                        <input type="hidden" name="bookID" value="${review.getBookID()}" />
                                        <input type="hidden" name="username" value="${review.getUserName()}" />
                                        <td align="right"><input type="text" name="reason" value="Why is it spam?" /></td>
                                        <td><input type="submit" name="Spam" class="btn btn-danger btn-sm" value="Report spam"/></td>
                                    </form>
                                </c:if>
                            </c:otherwise>
                        </c:choose>

                        </tr>
                    </c:forEach>
                </table></c:if>

            </div> 
            <br/>
        <c:if test="${not empty similarBookList}">
            <h4>This might interest you:</h4>
            <div class="row">
                <c:forEach items="${similarBookList}" begin="1" end="6" var="item">
                    <div class="col-sm-2 col-lg-2 col-md-2">
                        <div class="thumbnail" style="width:200px;height:400px">
                            <!--<img src="${pageContext.request.contextPath}/images/${item.bookID}" alt="No image"/>-->
                            <form name="viewBook" action="BookListServlet" method="post" align="center">
                                <input type="hidden" name="action" value="viewBook">
                                <input type="hidden" name="bookid" value=${item.bookID}>
                                <input type="image" src="${pageContext.request.contextPath}/images/${item.bookID}" class="thumbnail" style="width:200px;height: 300px" alt="No Image" />
                            </form>
                            <div class="text-center" align="center">
                                <h5 class="text text-muted"><b>${item.title}</b></h5>
                                <h6 class="text text-muted">By:${item.author}</h6>                                         
                            </div>
                        </div>
                    </div>
                </c:forEach>    
            </div>
        </c:if>
        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
    </body>
    <%@ include file="footer.jsp" %>
</html>
