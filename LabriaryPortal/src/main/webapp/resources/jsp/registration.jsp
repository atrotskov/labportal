<%--
  Created by IntelliJ IDEA.
  User: jdev
  Date: 31.12.2015
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Libriary registration</title>

</head>
<body>

<jsp:useBean id="userBean" class="ua.org.oa.atrotskov.model.dto.UserDTO" scope="session"/>
<h2>User form</h2>

<div>
    <form name="myform" method="POST" action="/registration">

        <span class="form-field-title">Name</span><input type="text" name="name"> <br><span class="required">*</span>
        <span class="form-field-title">Login</span><input type="text" name="login"><br><span class="required">*</span>
        <span class="form-field-title">Password</span>
        <input type="password" name="password"><br><span class="required">*</span>
        <span class="form-field-title">Birthday</span><input type="date" name="birthday"><br>

        <input id="regisbut" type="submit" value="Save"></form>
</div>

</body>
</html>