<%-- 
    Document   : userLogout
    Created on : Nov 10, 2016, 4:28:22 PM
    Author     : akshay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<p style="color:red;"><c:if test="${not empty message}"><c:out value="${message}"/></c:if></p>
<form name="logout" action="LoginServlet" method="post" align="right">
    <input type="submit" name="logout" value="logout"/>
    <input type="hidden" name="action" value="logout"/>
</form>
<br/>
