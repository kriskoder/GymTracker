<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/webjars/jquery/3.0.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <title>Title</title>
</head>
<body>

<%@include file="header.jsp" %>

<div class="container w-75">

    <div class="card transparent">
        <div class="card-body">
            <h3>${userSession.name}, this are your training details:</h3>
        </div>
    </div>

    <div class="card mt-4 transparent">
        <div class="card-body">
            <table class="table table-hover">
                <tr>
                    <th>Exercise</th>
                    <th>Weight</th>
                    <th>Reps</th>
                    <th style="width: 15%">Optional</th>
                </tr>

                <c:forEach items="${historyList}" var="var">
                    <tr>
                        <td>${var.exercise.name}</td>
                        <td>${var.weight} kg</td>
                        <td>${var.reps}</td>
                        <td><a class="btn btn-outline-info btn-sm" href="/history/progress/${var.exercise.id}">Progress</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
