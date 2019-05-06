<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <h3>${userSession.name}, add training record:</h3>
        </div>
    </div>

    <div class="card mt-4 transparent">
        <div class="card-body">
            <div class="row">
                <div class="form-group col-md-4">
                    <form:form method="post" modelAttribute="history">
                        <label for="exerciseId">Exercise:</label>
                        <form:select class="form-control" items="${exerciseList}" path="exercise" itemLabel="name"
                                     itemValue="id" multiple="false" id="exerciseId"/><br>

                        <label for="weightId">Weight:</label>
                        <form:input path="weight" id="weightId" class="form-control" type="number"/>
                        <form:errors path="weight" cssClass="error" element="div"/>

                        <label for="repsId">Reps:</label>
                        <form:input path="reps" id="repsId" class="form-control" type="number"/>
                        <form:errors path="reps" cssClass="error" element="div"/>

                        <input class="btn btn-primary btn-lg btn-sm" type="submit" value="Save">
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

