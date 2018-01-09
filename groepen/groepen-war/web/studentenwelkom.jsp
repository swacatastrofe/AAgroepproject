<%-- 
    Document   : studentenwelkom
    Created on : 21-Nov-2017, 11:09:13
    Author     : Wouter
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/opmaak.css"/>
        <title>student home</title>
    </head>
    <body>
        <h1>welkom <%-- get name out of user --%> </h1>
            match made in heaven list:
            <ul>
            <c:forEach var="vriend" items="${requestScope.vrienden}">
                <li>Groepsnummer: ${groepen}</li>
            </c:forEach>
            </ul>
        <form method="post" action="<c:url value='controller' />" >
                <input type="submit" value="iemand toevoegen"/>
                <input type="hidden" name="oorsprong"  value="making friends"/>
            </form>
            match made in hell list:
            <ul>
            <c:forEach var="vriend" items="${requestScope.vrienden}">
                <li>Groepsnummer: ${groepen}</li>
            </c:forEach>
            </ul>
            <form method="post" action="<c:url value='controller' />" >
                <input type="submit" value="iemand toevoegen"/>
                <input type="hidden" name="oorsprong"  value="making enemies"/>
            </form>
    </body>
    <footer>
        <%@include file="footer.jspf" %>
    </footer>
</html>