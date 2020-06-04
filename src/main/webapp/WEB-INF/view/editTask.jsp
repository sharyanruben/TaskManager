<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<body style="margin-right:750px; text-align:right;">
<h3>edit ${task.name}</h3>
<form action="/assign/edit" modelAttribute="task" method="post">

    <select name="status">
            <option value="${task.status}">${task.status}</option>
            <option value"STARTED">STARTED</option>
            <option value="INPROCESS">INPROCESS</option>
            <option value"DONE">DONE</option>
    </select><br><br>

        <c:if test="${not empty users}">
        <select name="userId">
                <option value="${task.user.id}">${task.user.userName}</option>
            <c:forEach items="${users}" var="user">
                <option value="${user.id}">${user.userName}</option>
            </c:forEach>
        </select>
        </c:if>
    <br><br>

    <input type="text" name="comment" value="" placeholder="write comment">

    <input type="hidden" name="taskId" value="${task.id}">
    <input type="hidden" name="userIdOfOldTask" value="${task.user.id}">
    <br><br>
    <input type="submit" value="edit task">
    <br><br>


    <c:if test = "${message != null}">
         <h3 style="color: green;">${message}<h3>
    </c:if>
</form>

    <c:choose>
       <c:when test="${userIdOfOldTask != null}">
            <a href="/user/info/${userIdOfOldTask}">go back</a>
       </c:when>
          <c:otherwise>
            <a href="/user/info/${user.id}">go back</a>
          </c:otherwise>
     </c:choose>
</body>
</html>