<%-- 
    Document   : home
    Created on : 1 Oct, 2016, 9:10:12 PM
    Author     : Prateek
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="business.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>

        <style>
            .dropbtn {
                background-color: #4CAF50;
                color: white;
                padding: 16px;
                font-size: 16px;
                border: none;
                cursor: pointer;
            }

            .dropdown {
                position: fixed;
                display: inline-block;
                top: 0px;
                left: 0px;

            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            }

            .dropdown-content a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
            }

            .dropdown-content button {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
                border: none;
                background-color: #f9f9f9;
            }
            
            .dropdown-content input {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
                border: none;
                background-color: #f9f9f9;
            }
            .dropdown-content a:hover {background-color: #f1f1f1}

            .dropdown:hover .dropdown-content {
                display: block;
            }

            .dropdown:hover .dropbtn {
                background-color: #3e8e41;
            }
        </style>
        
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
        <link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css"
        rel="stylesheet" type="text/css" />
      
<link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">
        
            <script type="text/javascript">
            $(function () {
                $("#dialog").dialog({
                    modal: true,
                    autoOpen: false,
                    title: "Delete Account",
                    width: 300,
                    height: 150,
                    buttons:
                    { "No": function() {
                        $(this).dialog("close")
                    },"Yes": function(){
                        $(this).dialog("close")                                   
                        $.post("UserProfileManager",
                        {
                            "action": "deleteaccount",
                            "username": "${user.getUserName()}"
                        },
                        function(data,status){
                            window.location.href="index.jsp"; 
                        });
                     }
                 }
                 });
                
                $("#btnShow").click(function () {
                    $('#dialog').dialog('open');
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
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                </ul>
                <p style="color:red;"><c:if test="${not empty message}"><c:out value="${message}"/></c:if></p>
                <p style="color:red; font-weight:bold; text-align:right;">Welcome <c:out value="${user.firstName}" ></c:out></p>
                <form name="logout" action="LoginServlet" method="post" >
                    <input type="submit" name="logout" value="logout" style="float: right;"/>
                    <input type="hidden" name="action" value="logout"/>
                </form>
                <br/>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
<br/>
<form name="ProfileView" action="UserProfileManager" method="post">
    <input type="hidden" name="username" value="${user.getUserName()}"/>
    <div class="dropdown" style="z-index:1">
        <button class="dropbtn">Profile</button>
        <div class="dropdown-content">
            <button type="submit" name="action" value="viewprofile" >View profile</button>
            <button type="submit" name="action" value="editprofile" >Edit profile</button>
            <input type="button" id="btnShow" value="Delete Account" />
            <div id="dialog" style="display: none" align = "center">
                Are you sure you want to delete your account?
            </div>
        </div>
    </div>
</form>  
    <br/>
    <c:if test="${user.getRole()=='admin'}">
    <a class ="dropbtn" style="text-decoration:none; color:white;"
       href="BookManager?action=manageBooks&user=${cookie.userCookie.value}">Manage Books</a><br/>
    </c:if> 
    <br/>
    
   <form name="viewWishlist" action="WishlistServlet" method="post">
        <input type="hidden" name="action" value="viewWishlist">
        <input type="hidden" name="username" value="${user.getUserName()}"></input>
        <input type="submit" value="View wishlist" 
               style="background-color: #4CAF50; 
                        border: none;
                        color: white;
                        padding: 15px 32px;
                        text-align: center;
                        text-decoration: none;
                        display: inline-block;
                        font-size: 16px;
                        margin: 4px 2px;
                        cursor: pointer;"/>
        </form>
    <br/><br/><br/><br/>
    
     <c:forEach items="${books}" var="item">
                            <div class="col-sm-4 col-lg-4 col-md-4">
                                <div class="thumbnail">
                                    <img src="http://placehold.it/320x150" alt="">
                                    <div class="caption">
 
                                        <h4 align="center">${item.title}</h4>
                                        <h5 align="center">By:${item.author}</h5> 
                                        <form name="viewBook" action="BookListServlet" method="post" align="center">
                                            <input type="hidden" name="action" value="viewBook">
                                            <input type="hidden" name="bookid" value=${item.bookID}>
                                            <input type="submit" value="View Details" />
                                        </form>
                                        <form name="addToWishlist" action="WishlistServlet" method="post" align="center">
                                            <input type="hidden" name="action" value="addToWishlist">
                                            <input type="hidden" name="username" value="${user.getUserName()}"</input>
                                            <input type="hidden" name="bookid" value=${item.bookID}>
                                            <input type="hidden" name="books" value="${books}">
                                            <input type="submit" value="Add to wishlist" />
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        
    </form>
    </body>
</html>
