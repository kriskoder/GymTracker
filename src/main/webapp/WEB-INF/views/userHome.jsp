<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/webjars/jquery/3.0.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <title>Welcome ${userSession.name}</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container w-75">

    <div class="card mt-4 transparent">
        <div class="card-header">Recent activity</div>
        <div class="card-body">

            <div class="row">
                <div class="form-group col-md-4">
                    <div class="card-header">Add workout</div>
                    <form method="post" action="/training/create">
                        <label for="trainingName">Training name:</label>
                        <input type="text" name="trainingName" id="trainingName" class="form-control"/><br>
                        <input class="btn btn-info btn-sm" type="submit" value="createTraining"/>
                    </form>
                </div>
                <div class="col-md-8">
                    <div class="card-header">Your last 3 workouts</div>
                    <table class="table table-hover table-light">
                        <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Performed</th>
                            <th scope="col">Details</th>
                        </tr>
                        </thead>
                        <tbod>
                            <c:forEach items="${lastTrainings}" var="var">
                                <tr>
                                    <td>${var.name}</td>
                                    <td>${var.created}</td>
                                    <td>
                                        <a class="btn btn-primary btn-lg btn-sm" href="/history/${var.id}">Details</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbod>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
