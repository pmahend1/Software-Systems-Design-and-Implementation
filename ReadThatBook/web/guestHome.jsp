<%-- 
    Document   : guestHome
    Created on : Oct 28, 2016, 3:28:28 PM
    Author     : Sweet_Home
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
        <title>Read That Book</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
        <script src="js/guestHome.js"></script>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@ include file="header.jsp" %>
        <c:if test="${message != null}">
            <p style="color:red; font-weight:lighter; text-align:center;">${message}</p>
        </c:if>
        <div>
            <br/>
            <form name="loginForm" action="LoginServlet" method="post" align="right" ng-app="guestHomeApp" ng-controller="validateCtrl"
                  novalidate>
                <input type="hidden" name="action" value="login">   
                <label style="color: white;">User Name</label>
                <input name="userName" ng-model="userName" type="text" required/>
                <label style="color: white;">Password</label>
                <input name="passWord" ng-model="passWord" type="password" required/>

                <span style="color:red" ng-show="loginForm.userName.$dirty && loginForm.userName.$invalid">
                    <span ng-show="loginForm.userName.$error.required">Username is required.</span>
                    <span style="color:red" ng-show="loginForm.passWord.$dirty && loginForm.passWord.$invalid"></span>
                    <span ng-show="loginForm.passWord.$error.required">password is required.</span>
                </span>

                <input type="submit" value="Login" ng-disabled="loginForm.userName.$dirty && loginForm.userName.$invalid ||
                                    loginForm.passWord.$dirty && loginForm.passWord.$invalid"/>
            </form>
        </div>
        <div>
            <form name="register" action="LoginServlet" method="post" align="right">
                <input type="submit" name="register" value="Register" />
                <input type="hidden" name="action" value="register"/>
            </form>
        </div>
        <br/>
        <%@ include file="headerClose.jsp" %>
        <br/><br/>
        <form name="login" action="BookManager" method="post">
            <div style="text-align:center; margin:0 80px;"/>
            <input type="searchText" name="searchString" placeholder="Search.." align="center">
            <input type = "Submit" name="submit" value="Search"/>
            <input type="hidden" name="action" value="searchBook">
        </form>
        <br/>
        <c:if test="${searchErrorMessage != null}">
            <p style="color:red; font-weight:bold; text-align:center;">${searchErrorMessage}</p>
            <%request.removeAttribute("searchErrorMessage");%>  
        </c:if>
        <br/>
        <div class="container">
            <div class="row">
                <div class="col-md-2">
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
                                    <img src="${pageContext.request.contextPath}/images/${item.bookID}" alt="No image"/>
                                    <div class="caption">

                                        <h4 align="center">${item.title}</h4>
                                        <h5 align="center">By:${item.author}</h5> 
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

