<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="label" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/webjars/jquery/3.0.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <title>Register</title>
</head>
<body>
<h1></h1>
<br><br>
<div class="container w-25">
    <div class="card cardBackground1">
        <div class="card-header">GymTracker</div>
        <div class="card-body">
        <form:form method="post" modelAttribute="user">
            <div>
                <label for="nameId">Name:</label>
                <form:input class="form-control" id="nameId" path="name" type="text"/>
                <form:errors path="name" cssClass="error" element="div"/>
            </div>

            <div>
                <label for="emailId">Email:</label>
                <form:input class="form-control" id="emailId" path="email" type="text"/>
                <form:errors path="email" cssClass="error" element="div"/>
            </div>

            <div>
                <label for="passwordId">Password</label>
                <form:input class="form-control" id="passwordId" path="password" type="password"/>
                <form:errors path="password" cssClass="error" element="div"/>
            </div>
            <br>
            <input class="btn btn-info btn-sm" type="submit" style="float: right" value="Register"/>
            <a href="/" class="btn btn-warning btn-sm" style="float: left">Back</a>
        </form:form>
        </div>
    </div>
</div>


</body>
</html>
