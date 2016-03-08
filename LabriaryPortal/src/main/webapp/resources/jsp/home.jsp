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
    <title><c:out value="${user.getName()}" default="guest"/>'s cabinet</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
<div class="top">
    <div class="logout"><a href="/logout">Log out</a></div>
    <c:if test="${user.getAdmin() == true}"><div class="admin"><a href="/admin">Admin Panel</a></div></c:if>
    <div class="hello">Hello <c:out value="${user.getName()}" default="guest"/></div>
</div>
<div class="right-box">
    <div class="box-title">Books wich you read now:</div>
    <div>

        <c:choose>
            <c:when test="${userBooks.isEmpty()}">
                You do not have any books
            </c:when>
            <c:otherwise>
                <table>
                    <tbody>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Return</th>
                    </tr>

                    <c:forEach items="${userBooks}" var="book">
                        <tr>
                            <td><c:out value="${book.getId()}"></c:out></td>
                            <td><c:out value="${book.getAuthor()}"></c:out></td>
                            <td><c:out value="${book.getTitle()}"></c:out></td>
                            <td>
                                <form name="return" method="POST" action="/returnbook">
                                    <button name="id" value="<c:out value="${book.getId()}"></c:out>">Return</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>


    </div>
</div>
<div class="left-box">
    <div class="box-title">All books in the Library:</div>
    <div>

        <table>
            <tbody>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Count</th>
                <th>Take</th>
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
                                <form name="take" method="POST" action="/takebook">
                                    <button name="id" value="<c:out value="${book.getId()}"></c:out>">Take</button>
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