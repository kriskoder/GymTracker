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

<%@include file="../header/header.jsp" %>

<div class="container w-75">

    <div class="card transparent">
        <div class="card-body">
            <h3>Your progress on ${exerciseName}:</h3>
        </div>
    </div>

    <div class="card mt-4 transparent">
        <div class="card-body">
            <div class="row">
                <div class="col-md-6">
                    <table class="table table-hover">
                        <tr>
                            <th>Date</th>
                            <th>Reps</th>
                            <th>Weights</th>
                        </tr>
                        <c:forEach items="${progress}" var="var">
                            <tr>
                                <td>${var.training.strCreated}</td>
                                <td>${var.reps}</td>
                                <td>${var.weight} kg</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <div class="col-md-3">
                    <table class="table table-hover">
                        <tr>
                            <th>Max Weight</th>
                        </tr>
                        <tr>
                            <td>${max.weight} kg</td>
                        </tr>
                        <tr>
                            <th>${max.training.strCreated}</th>
                        </tr>
                    </table>
                </div>

                <div class="col-md-3">
                    <table class="table table-hover">
                        <tr>
                            <th>Min Weight</th>
                        </tr>
                        <tr>
                            <td>${min.weight} kg</td>
                        </tr>
                        <tr>
                            <th>${min.training.strCreated}</th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>