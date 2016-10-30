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
                position: relative;
                display: inline-block;
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

        <form name="ProfileView" action="UserProfileManager" method="post">
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
    <body>
        <h3>Read that Book</h3>
            <input type="hidden" name="username" value="${user.getUserName()}"</input>
            <div class="dropdown">
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
        <p>Welcome <c:out value="${user.firstName}" ></c:out></p> 
         <c:if test="${user.getRole()=='admin'}">
         <a href="BookManager?action=manageBooks&user=${cookie.userCookie.value}">Manage Books</a><br/>
         </c:if> 
    </body>
</html>
