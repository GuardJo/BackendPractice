<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>
<table>
  <thead>
  User List
  </thead>
    <c:forEach items="${userList}" var="user" varStatus="status">
        <tr>
            <th scope="row">${status.count}</th>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>