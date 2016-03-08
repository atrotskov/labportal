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
  <title><c:out value="${user.getName()}" default="guest"/>'s admin panel</title>
  <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
<div class="top">
  <div class="logout"><a href="/logout">Log out</a></div>
  <div class="admin"><a href="/home">Home Panel</a></div>
  <div class="hello">Hello <c:out value="${user.getName()}" default="guest"/></div>
</div>
<div class="right-box">
  <div class="box-title">Books wich you read now:</div>

</div>
<div class="left-box">

    <div class="box-title"> Add new book</div>
  <div class="form">
    <form name="add-book-form" method="post" action="/addnewbook">
      <input type="text" name="title">
      <input type="text" name="author">
      <input type="number" name="count" min="0" max="100" step="1">
      <input id="addbookbut" type="submit" value="Save">

    </form>
  </div>
  <div class="box-title">All books in the Library:</div>
  <div>
    <table>
      <tbody>
      <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Count</th>
      </tr>

      <c:forEach items="${listAllBooks}" var="book">
        <tr>
          <td><c:out value="${book.getId()}"></c:out></td>
          <td><c:out value="${book.getAuthor()}"></c:out></td>
          <td><c:out value="${book.getTitle()}"></c:out></td>
          <td><c:out value="${book.getCount()}"></c:out></td>
          <td>
            <c:choose>
              <c:when test="${book.getCount() == 0}">
                <p>Comming soon</p>
              </c:when>
              <c:otherwise>
                <form name="take" method="POST" action="/deletebook">
                  <button name="id" value="<c:out value="${book.getId()}"></c:out>">Delete</button>
                </form>
              </c:otherwise>
            </c:choose>

          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
<div class="message"><c:out value="${message}"></c:out>
  <c:remove var="message" scope="session" />
</div>
<div class="footer"></div>
</body>
</html>