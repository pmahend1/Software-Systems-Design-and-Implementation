<%-- 
    Document   : guestHomeNav
    Created on : 3 Dec, 2016, 11:06:34 PM
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
            <div class="col-lg-2">
                <ul class="nav navbar-nav">            
                    <li><a href="LoginServlet?action=backHome">Home</a></li>
                    <li><a href="contactUs">Contact Us</a></li>
                </ul>
            </div>
            <div class="col-lg-6">
                <div class="navbar-form navbar-right">
                    <form class="form-horizontal" role="form" name="loginForm" action="LoginServlet" method="post">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="userName" type="text" placeholder="User Name" class="form-control" required/>
                        </div>
                        <input type="hidden" name="action" value="login" > 
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input name="passWord" type="password" placeholder="Password" class="form-control" required/>
                        </div>
                        <button type="submit" class="btn btn-primary">Login</button>
                    </form>
                </div>
            </div>
                <div class="col-lg-1">
                    <form class="navbar-form navbar-right" role="form" name="register" action="LoginServlet" method="post">
                        <input type="hidden" name="action" value="register">
                        <button type="submit" class="btn btn-primary" name="register" value="Register">Register</button>
                    </form>
                </div>
            </div>
        </div>
</nav>