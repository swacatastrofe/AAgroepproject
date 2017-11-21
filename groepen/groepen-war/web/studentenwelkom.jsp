<%-- 
    Document   : studentenwelkom
    Created on : 21-Nov-2017, 11:09:13
    Author     : Wouter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>student home</title>
    </head>
    <body>
        <h1>welkom <%-- get name out of user --%> </h1>
            match made in heaven list:
            <%--  loop over wel tabel  --%>
            <form action='<c:url value="controller" />' method='POST'>
                <input type="submit" value="iemand toevoegen"/>
                <input type="hidden" name="oorsprong"  value="making friends"/>
            </form>
            match made in hell list:
            <%--  loop over niet tabel  --%>
            <form action='<c:url value="controller" />' method='POST'>
                <input type="submit" value="iemand toevoegen"/>
                <input type="hidden" name="oorsprong"  value="making enemies"/>
            </form>
    </body>
</html>
