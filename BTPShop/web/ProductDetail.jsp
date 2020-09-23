<%-- 
    Document   : ProductDetail
    Created on : Nov 26, 2018, 12:44:33 PM
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
       <table>
           <tr>
                <td>Product Image: </td>
                <td><img src="image/${product.productimage}.jpg" width="120"></td>
            </tr>
            <tr>
                <td>Product Id: </td>
                <td>${product.productid}</td>
            </tr>
            <tr>
                <td>Product Name: </td>
                <td>${product.productname}</td>
            <tr>
                <td>Product Type: </td>
                <td>${product.producttype}</td>
            </tr>
            <tr>
                <td>Product Detail: </td>
                <td>${product.productdetail}</td>
            </tr>
            <tr>
                <td>Product Price: </td>
                <td>${product.productprice}</td>
            </tr>
        </table>
    </body>
</html>
