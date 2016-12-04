<%-- 
    Document   : userHome
    Created on : Oct 29, 2016, 3:17:45 PM
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
   
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body style="background-color:#F1F4FF;">
    <%@ include file="defaultNav.jsp" %>
<br/>
<br/>
    <!-- Page Content -->
    <br/>                
    <form name="login" action="BookManager" method="post">
        <div style="text-align:center; margin:10px 80px;"/>
        <input type="searchText" name="searchString" placeholder="Search.." align="center">
        <input type = "Submit" name="submit" value="Search"/>
        <input type="hidden" name="action" value="searchBook">
    </form>
    <br/><br/>
    <div class="container">

        <div class="row">

            <div class="col-md-3">
                <p class="lead">Genres</p>
                <div class="list-group">
                    <a href="#" class="list-group-item">Fiction</a>
                    <a href="#" class="list-group-item">Science Fiction</a>
                    <a href="#" class="list-group-item">Mystery</a>
                    <a href="#" class="list-group-item">Horror</a>
                </div>
            </div>

            <div class="col-md-9">
                
            <input type="hidden" name="action" value="bookList">
                <div class="row carousel-holder">
                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" height="300" width="800" src="http://arthuryao.com/Blog/wp-content/uploads/2014/12/books_300.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="http://college.uchicago.edu/sites/college.uchicago.edu/files/styles/uniquely_full/public/images/uniquely/BooksForArticleContrasted-1.jpg?itok=XXGmNQ0S" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="http://vineyardcountryschool.org/wp-content/uploads/2016/09/books800.jpg" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>
                </div>
            
                <div class="row">
                  <c:forEach items="${books}" var="item">
                    <div class="col-sm-3 col-lg-3 col-md-3">
                        <div class="thumbnail">
                            <img src="http://placehold.it/320x150" alt="">
                            <div class="caption">
                                
                                <h3 align="center">${item.title}</h3>
                                <h4 align="center">By:${item.author}</h4> 
                                <form name="viewBook" action="BookListServlet" method="post" align="center">
                                    <input type="hidden" name="action" value="viewBook">
                                    <input type="hidden" name="bookid" value=${item.bookID}>
                                    <input type="submit" value="View Details" />
                                </form>
                            </div>
                        </div>
                    </div>
                    </c:forEach>   
                </div>
            
            </div>
        </div>
    </div>


    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>
<%@ include file="footer.jsp" %>
</html>
