<%-- 
    Document   : login
    Created on : 21-nov-2017, 11:25:02
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Welkom</h1>
        <p> Log je hier in voor het bekijken van je groep en het ingeven van je voorkeuren:
        <form method=post action="j_security_check">
            <table>
                <tr> <td> Naam: </td> <td> <input type="text" name="j_username" /></td></tr>
                <tr> <td> Paswoord:</td><td><input type="password" name="j_password" /></td></tr>
            </table>
            <input type="submit" />
        </form>
    </body>
</html>
