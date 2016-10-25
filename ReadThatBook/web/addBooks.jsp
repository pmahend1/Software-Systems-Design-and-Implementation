<%-- 
    Document   : addBooks
    Created on : 24 Oct, 2016, 7:30:06 PM
    Author     : Prateek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a Book</title>
    </head>
    <body>
        <h1>Add A Book Manually</h1>
        <form action="ManageBooks" method="POST">
            <table>
                <tbody>
                    <tr>
                        <td>Book Title</td>
                        <td>:</td>
                        <td><input type="text" ng-model="bookTitle"/></td>
                    </tr>
                    <tr>
                        <td>ISBN-13</td>
                        <td>:</td>
                        <td><input type="text" ng-model="ISBN_13"></td>
                    </tr>
                    <tr>
                        <td>ISBN-10</td>
                        <td>:</td>
                        <td><input type="text" ng-model="ISBN_10"></td>
                    </tr>
                    <tr>
                        <td>Author</td>
                        <td>:</td>
                        <td><input type="text" ng-model="author"/></td>
                    </tr>
                    <tr>
                        <td>Genre</td>
                        <td>:</td>
                        <td><input type="text" ng-model="author"/></td>
                    </tr>
                    <tr>
                        <td>Edition</td>
                        <td>:</td>
                        <td><input type="text" ng-model="edition"/></td>
                    </tr>
                    <tr>
                        <td>Publisher</td>
                        <td>:</td>
                        <td><input type="text" ng-model="publisher"/></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>:</td>
                        <td><textarea rows="4" cols="21"></textarea></td>
                    </tr>
                    <tr>
                        <td><input type="submit" /></td>
                        <td>  </td>
                        <td><input type="reset" /></td>
                    </tr>
                </tbody>
            </table>

            
        </form>
    </body>
</html>
