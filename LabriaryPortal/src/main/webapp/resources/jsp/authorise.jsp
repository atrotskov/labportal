<%--
  Created by IntelliJ IDEA.
  User: jdev
  Date: 31.12.2015
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <title>Authorise in the Libriary</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
<div class="auth-form">
    <div class="title">Please authorise in the Libriary</div>
    <div class="form">
        <div>
            <form name="authorise-form" method="POST" action="/authorise">

                <div>
                    <div class="form-field-title">Login</div>
                    <input type="text" name="login"></div>
                <div class="form-field-title">Password</div>
                <input type="password" name="password"><br>

                <input id="regisbut" type="submit" value="Sign In">
            </form>
        </div>
    </div>
    <c:if test="${message != null}">
        <div class="error-message"><c:out value="${message}"/></div>
    </c:if>
</div>
</body>
</html>
