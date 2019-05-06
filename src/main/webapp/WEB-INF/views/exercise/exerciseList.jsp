<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/webjars/jquery/3.0.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <title>ExerciseList</title>
</head>
<body>

<%@include file="../header/header.jsp" %>

<div class="container w-75">

    <div class="card mt-4 transparent">
        <div class="card-header">Exercise List</div>
        <div class="card-body">
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover table-light">
                        <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Technique</th>
                        </tr>
                        </thead>
                        <tbod>
                            <c:forEach items="${exerciseList}" var="var">
                                <tr>
                                    <td style="width: 200px"> ${var.name}</td>
                                    <td><iframe width="560" height="315" src="${var.link}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></td>
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


