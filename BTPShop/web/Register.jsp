<%-- 
    Document   : Register
    Created on : Nov 26, 2018, 9:44:59 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action="Register" method="post">
            <table>
                <tr>
                    <td>Username : </td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>Password : </td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td>EMAIL : </td>
                    <td> <input type="email" name="email"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Register"></td>
                </tr>
            </table>
        </form>
        <h4>${err}</h4>
    </body>
</html>
