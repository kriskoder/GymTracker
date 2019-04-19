<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <div class="card">
        <div class="card-body">
            <h3>${user.name}, add training record:</h3>
        </div>
    </div>

    <div class="card mt-4">
        <div class="card-body">
            <div class="row">
                <div class="form-group col-md-4">
                    <form:form method="post" modelAttribute="history">
                        <label for="exerciseId">Exercise:</label>
                        <form:select class="form-control" items="${exerciseList}" path="exercise" itemLabel="name"
                                     itemValue="id" multiple="false" id="exerciseId"/><br>
                        <label for="weightId">Weight:</label>
                        <form:input path="weight" id="weightId" class="form-control" type="number"/>
                        <label for="repsId">Reps:</label>
                        <form:input path="reps" id="repsId" class="form-control" type="number"/><br>
                        <input class="btn btn-primary btn-lg btn-sm" type="submit" value="Save">
                    </form:form>
                </div>
                <div class="col-md-8">
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

