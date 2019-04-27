<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GymTracker</title>
</head>
<body>
<form:form method="post" modelAttribute="exercise">
    <div>
        <label for="nameId">Exercise Name:</label>
        <form:input id="nameId" path="name" type="text"/>
        <form:errors path="name" cssClass="error"/>
    </div>

    <div>
        <label for="descriptionId">Description:</label>
        <form:textarea id="descriptionId" path="description"/>
    <form:errors path="description" cssClass="error"/>
    </div>

    <input type="submit" value="save" />

</form:form>

<a href="../">Home</a>

</body>
</html>
