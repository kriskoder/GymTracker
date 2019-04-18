<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${userSession.name}</h1>


<table border="1">
    <thead>
    Last tainings:
    <tr>
        <td>Name</td>
        <td>Created</td>
        <td>Optional</td>
    </tr>
    </thead>
    <tbod>
        <c:forEach items="${lastTrainings}" var="var">
            <tr>
                <td>${var.name}</td>
                <td>${var.created}</td>
                <td><a href="history/${var.id}">Details</a></td>
            </tr>
        </c:forEach>
    </tbod>
</table>
<br>
<form method="post" action="training">
    <label for="trainingName">Training name:</label><br>
    <input type="text" name="trainingName" id="trainingName"><br><br>
    <input type="submit" value="createTraining">
</form>
</body>
</html>
