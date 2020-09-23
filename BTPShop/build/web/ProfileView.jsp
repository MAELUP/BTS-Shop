<%-- 
    Document   : ProfileView
    Created on : Nov 27, 2018, 9:48:51 PM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="include/Header.jsp?title= Hello::"/>
        <h1>My Profile</h1>
        <div>
            <table>
                <tr>
                    <td>Fullname:${sessionScope.acc.fullname}</td>
                </tr>
               
                <tr>
                    <td>Email:${sessionScope.acc.email}</td>
                </tr>
                <tr>
                    <td>Address: ${sessionScope.acc.address}</td>
                </tr>
                <tr>
                    <td>Province: ${sessionScope.acc.province}</td>
                </tr>
                <tr>
                    <td>District: ${sessionScope.acc.district}</td>
                </tr>
                <tr>
                    <td>Postalcode: ${sessionScope.acc.postalcode}</td>
                </tr>
                <tr>
                    <td>Tel:${sessionScope.acc.tel}</td>
                </tr>
            </table>
            <a href="EditProfile">Edit MY Profile</a>
            <a href="index.html">Back</a>
        </div>
    </body>
</html>
