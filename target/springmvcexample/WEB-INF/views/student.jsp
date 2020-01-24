<%--
  Created by IntelliJ IDEA.
  User: aleksandrzditovec
  Date: 1/22/20
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    Please Sign Up!
<form method="post" action="/jpa/students">
    <label for="name">Name
        <input class="input-field" type="text" id="name" name="name">
    </label>
    <label for="surname">Surname
        <input class="input-field" type="text" id="surname" name="surname">
    </label>
    <input type="submit" value="Add user">
</form>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
    </tr>
    <c:forEach items="${studentsFromServer}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.surname}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
