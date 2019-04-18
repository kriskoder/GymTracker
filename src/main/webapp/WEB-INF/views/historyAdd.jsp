<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="../../resources/js/historyAdd.js" type="text/javascript"></script>
    <title>Title</title>
</head>
<body>
<h3>${user.name}, add exercises:</h3>
<form:form method="post" modelAttribute="history">

    <form:select items="${exerciseList}" path="exercise" itemLabel="name" itemValue="id" multiple="false"/><br><br>

    <div id="addHistoryForm">
        <label for="weightId">Weight:</label><br>
        <form:input path="weight" id="weightId"/><br>
        <label for="repsId">Reps:</label> <br>
        <form:input path="reps" id="repsId"/><br>
    </div>

    <input type="submit" value="Save"><br><br>
</form:form>

</body>
</html>
