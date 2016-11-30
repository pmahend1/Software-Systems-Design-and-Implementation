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
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
        <link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css" rel="stylesheet" type="text/css" />      
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/shop-homepage.css" rel="stylesheet">
        <link href="css/userProfile.css" rel="stylesheet">
        <script src="js/userProfile.js"></script>
    </head>
    <body style="background-color:#F1F4FF;">
        <%@ include file="header.jsp" %>
        <p style="color:white; font-weight:bold; text-align:right;">${cookie.userCookie.value}</p>
        <%@ include file="userLogout.jsp" %>
          </div>
    </nav>
        <table>
            <tr>
                <td>
                    <c:if test="${user.getRole()=='admin'}">
                        <a class ="dropbtn" style="text-decoration:none; color:white;"
                           href="BookManager?action=manageBooks&user=${cookie.userCookie.value}">Manage Books</a><br/>
                    </c:if> 
                </td>
                <td>
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
                </td>
                <td>
                    <form name="viewWishlist" action="WishlistServlet" method="post">
                        <input type="hidden" name="action" value="viewWishlist">
                        <input type="hidden" name="username" value="${user.getUserName()}"></input>
                        <input type="submit" value="View wishlist" 
                               style="background-color: gray; 
                               border: none;
                               color: white;
                               padding: 15px 32px;
                               text-align: center;
                               text-decoration: none;
                               display: inline-block;
                               font-size: 16px;
                               margin: 5px 0px;
                               cursor: pointer;"/>
                    </form>
                </td>
                <td>
                    <form name="login" action="BookManager" method="post">
                        <div style="text-align:center; margin:0 80px;"/>
                        <input type="searchText" name="searchString" placeholder="Search.." align="center">
                        <input type = "Submit" name="submit" value="Search"/>
                        <input type="hidden" name="action" value="searchBook"/>
                    </form>
                </td>
            </tr>
        </table>
        <c:if test="${searchErrorMessage != null}">
            <p style="color:red; font-weight:bold; text-align:center;">${searchErrorMessage}</p>  
        </c:if>
        <c:if test="${wishMessage != null}">
            <p style="color:red; font-weight:lighter; text-align:center;">${wishMessage}</p>
        </c:if>
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
        </div>    
    </body>
</html>
