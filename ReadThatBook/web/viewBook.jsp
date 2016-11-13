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

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/shop-homepage.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view tde page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
        <!-- <script src="src/bootstrap-rating-input.js"></script> -->
        <script src="js/bootstrap-rating-input.min.js"></script>
        <script>
            $(function(){
              $('input').on('change', function(){
                alert("Changed: " + $(this).val())
              });
            });
          </script>

    </head>

    <body style="background-color:#FFF791;">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <label style="color:white;"><h1>ReadThatBook &emsp;&emsp;&emsp;</h1></label>
                </div>
                <!-- Collect tde nav links, forms, and otder content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">

                        <li>
                            <a href="#">About</a>
                        </li>
                        <li>
                            <a href="#">Contact</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>
        <br/>
        <br/>
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

        <!-- /.container -->

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

</html>

