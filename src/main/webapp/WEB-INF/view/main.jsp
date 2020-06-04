<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body style="margin-right:750px; text-align:right;">
    <h1>${message}</h1>

<form action="/user/start" method="get">
    <input type="submit" value="start">
</form>
</body>
</html>