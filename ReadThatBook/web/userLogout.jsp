<%-- 
    Document   : userLogout
    Created on : Nov 10, 2016, 4:28:22 PM
    Author     : akshay
--%>
<p style="color:red;"><c:if test="${not empty message}"><c:out value="${message}"/></c:if></p>
<form name="logout" action="LoginServlet" method="post" align="right">
    <input type="submit" name="logout" value="Logout"/>
    <input type="hidden" name="action" value="logout"/>
</form>
<br/>
