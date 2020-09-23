<%-- 
    Document   : Login
    Created on : Nov 26, 2018, 9:19:12 AM
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
        <form action="Login" method="post">
                <table class="table">
                    <tr>
                        <td>User Name: </td>
                        <td><input type="text" name="username" required></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="password" required/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Login"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><p style="color:red">${message}</p></td>
                    </tr>
                </table>
            </form>
    </body>
</html>
