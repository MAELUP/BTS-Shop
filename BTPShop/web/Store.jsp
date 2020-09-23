<%-- 
    Document   : Store
    Created on : Nov 26, 2018, 10:17:48 AM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet"  
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet"  
              href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">
        <script src=" https://code.jquery.com/jquery-3.3.1.js"></script>
        <script src=" https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src=" https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
    </head>
    <body>
          <c:forEach items="${sessionScope.cart}" var="c">                                    
          <c:set var="totalProduct" value="${c.productqueslity + totalProduct}" />
           </c:forEach>
        <jsp:include page="include/Header.jsp?title= Hello::"/>
        <h1><a href="ShowCart.jsp">Show Cart : (${totalProduct})</a></h1>
        <%-- <h1><form action="Search" method="post"> find product : <input type="text" name="findProduct"/> <input type="submit" value="search"/></form></h1> --%>
        <div class="container">
            <table id="example" class="table">
                <thead>
                <th>Image</th>
                <th>ID</th>
                <th>Name</th>
                <th>Type</th>
                <th>Price</th>
                <th>Quantity</th>
                </thead>
                <c:forEach items ="${products}" var="p">
                    <tr>
                        <td><a href="ProductDetail?productname=${p.productname}">
                                <img src="image/${p.productimage}.jpg" width="120"
                            </a>
                        </td>
                        <td>${p.productid}</td>
                        <td>${p.productname}</td>
                        <td>${p.producttype}</td>
                        <td>${p.productprice}</td>
                        <td>
                            <form action="AddToCart" method="post">
                                <input type="hidden" value="${p.productname}" name="productname"/>
                                <input type="number" value="0" name="quantity" min="0"/><br>
                                <input type="submit" value="Add To Cart"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
           
        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>
    </body>
</html>
