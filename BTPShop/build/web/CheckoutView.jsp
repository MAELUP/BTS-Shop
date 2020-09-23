<%-- 
    Document   : ChenkoutView
    Created on : Nov 28, 2018, 2:14:50 PM
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
        <div class="col-75">
            <div class="container">
                <form action="/action_page.php">

                    <div class="row">
                        <div class="col-50">
                            <h3>Billing Address</h3>
                            <label for="fname"><i class="fa fa-user"></i> Full Name</label>
                            <input type="text" id="fname" name="firstname" value="${sessionScope.acc.fullname}">
                            <label for="email"><i class="fa fa-envelope"></i> Email</label>
                            <input type="text" id="email" name="email" value="${sessionScope.acc.email}">
                            <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
                            <input type="text" id="adr" name="address" value="${sessionScope.acc.address}">
                            <label for="city"><i class="fa fa-institution"></i> Province</label>
                            <input type="text" id="city" name="province" value="${sessionScope.acc.province}">

                            <div class="row">
                                <div class="col-50">
                                    <label for="state">district</label>
                                    <input type="text" id="state" name="district" value="${sessionScope.acc.district}">
                                </div>
                                <div class="col-50">
                                    <label for="zip">postalcode</label>
                                    <input type="text" id="zip" name="postalcode" value="${sessionScope.acc.postalcode}">
                                </div>
                            </div>
                        </div>

                        <!--                            <div class="col-50">
                                                        <h3>Payment</h3>
                                                        <label for="fname">Accepted Cards</label>
                                                        <div class="icon-container">
                                                            <i class="fa fa-cc-visa" style="color:navy;"></i>
                                                            <i class="fa fa-cc-amex" style="color:blue;"></i>
                                                            <i class="fa fa-cc-mastercard" style="color:red;"></i>
                                                            <i class="fa fa-cc-discover" style="color:orange;"></i>
                                                        </div>
                                                        <label for="cname">Name on Card</label>
                                                        <input type="text" id="cname" name="cardname" placeholder="John More Doe">
                                                        <label for="ccnum">Credit card number</label>
                                                        <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
                                                        <label for="expmonth">Exp Month</label>
                                                        <input type="text" id="expmonth" name="expmonth" placeholder="September">
                                                        <div class="row">
                                                            <div class="col-50">
                                                                <label for="expyear">Exp Year</label>
                                                                <input type="text" id="expyear" name="expyear" placeholder="2018">
                                                            </div>
                                                            <div class="col-50">
                                                                <label for="cvv">CVV</label>
                                                                <input type="text" id="cvv" name="cvv" placeholder="352">
                                                            </div>
                                                        </div>
                                                    </div>-->

                        <table>
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Product Name</th>
                                    <th>Price</th>
                                    <th>Total Quantity</th>
                                    <th>Total Price</th>

                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${sessionScope.cart}" var="c" varStatus="vs">
                                <tr>
                                    <td>${vs.count}</td>       
                                    <td>${c.productname}</td>
                                    <td>${cart}</td>
                                    <td>${c.productqueslity * c.productprice}</td>
                                <c:set var="totalPrice" value="${(c.productqueslity * c.productprice) + totalPrice}" />
                            </c:forEach>
                            <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td><strong>${totalPrice}</strong></td>
                            </tr>		  
                            </tbody>
                        </table>
                    </div>
                    <label>
                        <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
                    </label>
                    <input type="submit" value="Continue to checkout" class="btn"> <a href="ShowCartView.jsp">Back</a>
                </form>

            </div>
        </div>
    </body>
</html>
