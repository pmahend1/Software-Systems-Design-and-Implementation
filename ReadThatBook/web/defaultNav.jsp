<%-- 
    Document   : defaultNav
    Created on : 3 Dec, 2016, 11:55:37 PM
    Author     : Prateek
--%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-2">
                <div class="navbar-header">
                    <label style="color:white;" class="h3">ReadThatBook&emsp;</label>
                </div>
            </div>
            <div class="width:300px">
                <ul class="nav navbar-nav">            
                    <li style="width: 60px"><a href="LoginServlet?action=backHome" class="btn" style="text-decoration:none; color:white;">Home</a></li>
                    <li style="width: 90px"><a href="contactUs" class="btn" style="text-decoration:none; color:white;">Contact Us</a></li>
                    <li><c:if test="${user.getRole()=='admin'}">
                        <a style="text-decoration:none; color:white;"
                           href="BookManager?action=manageBooks&user=${cookie.userCookie.value}" class="btn btn-link" style="text-decoration:none; color:white;">Books</a><br/>
                    </c:if>
                    </li>
                </ul>
            </div>
            <div class="col-lg-6">
                <table>
                    <td>
                        <form name="login" action="BookManager" method="post">
                            
                            <input type="searchText" name="searchString" placeholder="Search.." style="width: 350px">
                            <input type = "Submit" name="submit" value="Search" class="btn"/>
                            <input type="hidden" name="action" value="searchBook"/>
                        </form>
                    </td>
                    <td>
                        <form name="login" action="BookManager" method="post">
                            <input type = "Submit" name="submit" value="Advanced" class="btn"/>
                            <input type="hidden" name="action" value="advancedSearchBook"/>
                        </form>
                    </td>
                </table>
            </div>       
            <div class="col-lg-2">
                <table class="nav navbar-right">
                    <td>
                        <form name="ProfileView" action="UserProfileManager" method="post">
                            <input type="hidden" name="username" value="${user.getUserName()}"/>
                            <div class="dropdown" style="z-index:1">
                                <button class="btn btn-link" style="text-decoration:none; color:white;">Profile</button>
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
                            <input type="submit" value="Wishlist" style="text-decoration:none; color:white;" class="btn btn-link" />
                        </form>
                    </td>
                    <td>
                        <form name="logout" action="LoginServlet" method="post">
                            <input type="submit" name="logout" value="Logout" style="text-decoration:none; color:white;" class="btn btn-link"/>
                            <input type="hidden" name="action" value="logout"/>
                        </form>
                    </td>
                </table>
            </div>

        </div>
    </div>
</nav>
