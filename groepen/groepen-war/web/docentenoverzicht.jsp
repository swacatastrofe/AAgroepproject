<%-- 
    Document   : docentenoverzicht
    Created on : 28-nov-2017, 9:09:51
    Author     : student
--%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Overzicht</title>
    </head>
    <body>
        <h1>Welkom docent!</h1>
        <h2>Overzicht van de bestaande groepen</h2>
        <table>
            <tr>
                <th> Groepsnaam </th>
                <th> Aanpassen </th>
            </tr>
            <c:forEach var="groepen" items="${requestScope.groepen}">
                <td>${groepen}</td>
                <td>
                    <form method="post" action="<c:url value='controller.do' />" >
                        <input type="hidden" name="dtoestand" value="pasGroepAan"/>
                        <input type="hidden" name="groepsnr" value="${groepen}"/>
                        <input type="submit" name="Volgende" value="Pas deze groep aan"/>
                    </form>
                </td>
            </c:forEach>
        </table>
        <form method="post" action="<c:url value='controller.do' />" >
            <input type="hidden" name="dtoestand" value="voegGroepToe"/>
            <input type="submit" name="Volgende" value="Voeg een groep toe"/>
        </form>
    </body>
</html>
