<%-- 
    Document   : ShowCartView
    Created on : Nov 28, 2018, 1:34:27 PM
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
    <c:set var="totalPrice" value="${0}" />		       
    <h4><span>Shopping Cart</span></h4>

    <h4>Your Cart</h4>
    <table>
        <thead>
            <tr>
                <th>No.</th>
                <th>Image</th>
                <th>Product No.</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total Price</th>
                <th>&nbsp;</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${sessionScope.cart}" var="c" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td><a href="GetProduct?productname=${c.productname}"><img src ="image/${c.productimage}.jpg"widtd="120"></a></td>
                <td><a href="GetProduct?productname=${c.productname}">${c.productid}</a></td>         
                <td>${c.productname}</td>
                <td>${c.productprice}</td>
                <td>
                    <form action="UpdateCart" method="post">
                        <input type ="hidden" name="productname" value="${c.productname}">
                        <input type ="number" name="quantity" value="${c.productqueslity}" min="1">
                        <input type ="submit" value="Update">
                    </form>
                </td>
                <td>${c.productqueslity * c.productprice}</td>
                <td> <form action="RemoveCart" method="post">
                        <input type ="hidden" name="productname" value="${c.productname}">
                        <input type ="submit" value="Remove">
                    </form>
                </td>
            <c:set var="totalPrice" value="${(c.productqueslity * c.productprice) + totalPrice}" />
        </c:forEach>		  
    </tbody>
</table>
<hr>
<p>
    <strong>Total</strong>: ${totalPrice} Bant.<br>
</p>
<hr/>
<div>
    <a href="Store"><button type="button">Back</button></a>
    <a href="Checkout"> <button  type="submit" id="checkout">Checkout</button></a>
</div>					  	
</body>
</html>
