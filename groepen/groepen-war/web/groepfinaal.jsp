<%-- 
    Document   : groepfinaal
    Created on : 12-dec-2017, 12:33:38
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Foutje</title>
    </head>
    <body>
        <h1>Deze groep is reeds gefinaliseerd</h1>
        <p> Deze samenstelling is reeds gefinaliseed. U kan deze niet meer aanpassen</p>
        <form method="post" action="<c:url value='controller' />" >
            <input type="hidden" name="dtoestand" value="naarOverzicht"/>
            <input type="submit" name="Volgende" value="Ga terug naar de overzichts pagina"/>
        </form>
    </body>
    <footer>
        <%@include file="footer.jspf" %>
    </footer>
</html>
