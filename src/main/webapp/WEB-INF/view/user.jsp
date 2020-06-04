<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<table border="1">
        <tr>
            <td>user name</td>
        </tr>
        <c:forEach items="${users}" var="reporter">
            <tr>
                <td><a href="/user/info/${reporter.id}">${reporter.userName}</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>

    <c:choose>
    <c:when test="${isSelected}">

     <c:choose>
         <c:when test="${not empty tasks}">

         <h4>${user.userName}</h4><a href="/notification/show/${user.id}"><h4 style="color: red;">${notification}</h4></a>

        <table border="1">
            <tr>
                <td>task name</td>
                <td>severity</td>
                <td>status</td>
                <td>created date</td>
                <td>edit task</td>
            </tr>
            <c:forEach items="${tasks}" var="task">
                <tr>
                    <td>${task.name}</td>
                    <td>${task.severity}</td>
                    <td>${task.status}</td>
                    <td>${task.createdDate}</td>
                    <td><a href="/task/edit/${task.id}">edit task</a></td>
                </tr>
            </c:forEach>
        </table>
        </c:when>
          <c:otherwise>
              <h3 style="color: blue;">${user.userName} - does not have a task</h3>
          </c:otherwise>
      </c:choose>

                   <h3>create task</h3>
                       <form action="/task/createTask" modelAttribute="task" method="post">
                           <input name="name" type="text" value="" placeholder="task name"><br><br>

                           <select name="severity">
                               <option value="">select severity</option>
                               <option value"LOW">LOW</option>
                               <option value="ORDINARY">ORDINARY</option>
                               <option value"HIGH">HIGH</option>
                           </select><br><br>
                           <input type="hidden" name="userId" value="${user.id}">
                           <input type="submit" value="create task">
                       </form>
    </c:when>
    <c:otherwise>
        <h3 style="color: blue;">Select User</h3>
    </c:otherwise>
    </c:choose>

</body>
</html>