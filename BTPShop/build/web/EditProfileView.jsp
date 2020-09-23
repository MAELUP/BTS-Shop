<%-- 
    Document   : EditProfileView
    Created on : Nov 27, 2018, 9:49:11 PM
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
        <h1>Edit Your Profile</h1>
        <div>
            <form action="EditProfile" method="post">
                <table>
                    <tr>
                        <td>Fullname:<input type="text" name="fullname" placeholder="${sessionScope.acc.fullname}"></td>
                    </tr>
                    

                    <tr>
                        <td>Email:<input type="email" name="email" placeholder="${sessionScope.acc.email}"></td>
                    </tr>
                    <tr>
                        <td>Address:<input type="text" name="address" placeholder="${sessionScope.acc.address}"/><br></td>
                    </tr>
                    <tr>
                        <td>Province:<input type="text" name="province" placeholder="${sessionScope.acc.province}"/><br></td>
                    </tr>
                    <tr>
                        <td>District:<input type="text" name="district" placeholder="${sessionScope.acc.district}"/><br></td>
                    </tr>
                    <tr>
                        <td>Postalcode:<input type="text" name="postalcode" placeholder="${sessionScope.acc.postalcode}"/><br></td>
                    </tr>
                    <tr>
                        <td>Tel:<input type="text" name="tel" placeholder="${sessionScope.acc.tel}"/><br></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="OK!"/></td><td><a href="index.html">Back</a></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
