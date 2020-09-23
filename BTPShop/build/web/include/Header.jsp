<%-- 
    Document   : header
    Created on : Nov 26, 2018, 12:22:36 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="row">
        <div class="col-sm-2">
            <br><br>
            <c:choose>
                <c:when test="${sessionScope.acc != null}">
                    Hello <a href="ProfileView.jsp">${sessionScope.acc.username},</a>
                </c:when>
                <c:otherwise>
                    Hello <a href="Login">Guest</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
  <hr>