<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <td>Exercise</td>
        <td>Weight</td>
        <td>Reps</td>
        <td>Optional</td>
    </tr>
    </thead>
    <tbody>
    <h1>${user.name}, this are your training details:</h1>
    <div>
        <h3>${trainingName}</h3>
    </div>
    <c:forEach items="${historyList}" var="var">
        <tr>
            <td>${var.exercise.name}</td>
            <td>${var.weight}</td>
            <td>${var.reps}</td>
            <td><a href="/history/progress/${var.exercise.id}">Progress</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
