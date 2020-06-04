<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h4 style="color: blue">you have ${countOfNotification} notifications</h4>
    <table border="1">
                <tr>
                    <td>task name</td>
                    <td>severity</td>
                    <td>status</td>
                    <td>created date</td>
                </tr>
                <c:forEach items="${tasks}" var="task">
                    <tr>
                        <td>${task.name}</td>
                        <td>${task.severity}</td>
                        <td>${task.status}</td>
                        <td>${task.createdDate}</td>
                    </tr>
                </c:forEach>
            </table>
            <a href="/user/info/${userId}">go back</a>
</body>
</html>