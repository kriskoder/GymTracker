<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${progress}" var="var">
    ${var.reps}<br>
    ${var.weight}<br>
    ${var.training.created}<br>
</c:forEach>
</body>
</html>
