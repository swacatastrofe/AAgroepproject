<%-- 
    Document   : aanpassengroep
    Created on : 5-dec-2017, 9:28:43
    Author     : student
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aanpassen groep</title>
    </head>
    <body>
        <h1>Dag docent, u past momenteel groep <c:out value='${requestScope.groepsnr}'/> aan </h1>
        <h2> Leden toevoegen aan de groep </h2>
        <form method="post" action="<c:url value='controller' />" >
            <select name="toevoegen">
                <c:forEach var="student" items="${requestScope.studentenZonderGroep}">
                    <option value="${student}">${student}</option>
                </c:forEach>
            </select>
            <input type="hidden" name="dtoestand" value="voegStudentToe"/>
            <input type="submit" name="Volgende" value="Voeg de geslecteerde student toe"/>
        </form>
        <h2> Leden uit de groep verwijderen </h2>
        <form method="post" action="<c:url value='controller' />" >
            <select name="toevoegen">
                <c:forEach var="student" items="${requestScope.studentenInGroep}">
                    <option value="${student}">${student}</option>
                </c:forEach>
            </select>
            <input type="hidden" name="dtoestand" value="verwijderStudent"/>
            <input type="submit" name="Volgende" value="Verwijder de geslecteerde student uit de groep"/>
        </form>
        <form method="post" action="<c:url value='controller' />" >
            <input type="hidden" name="dtoestand" value="naarOverzicht"/>
            <input type="submit" name="Volgende" value="Ga terug naar de overzichts pagina"/>
        </form>
    </body>
</html>