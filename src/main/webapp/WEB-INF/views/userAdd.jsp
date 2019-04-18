<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="label" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>

<form:form method="post" modelAttribute="user">
    <div>
        <label for="nameId">Name:</label>
        <form:input id="nameId" path="name" type="text"/>
        <form:errors path="name" cssClass="error" element="div"/>
    </div>

    <div>
        <label for="emailId">Email:</label>
        <form:input id="emailId" path="email" type="text"/>
        <form:errors path="email" cssClass="error" element="div"/>
    </div>

    <div>
        <label for="passwordId">Password</label>
        <form:input id="passwordId" path="password" type="text"/>
        <form:errors path="password" cssClass="error" element="div"/>
    </div>
    <input type="submit" value="register"/>
</form:form>

<a href="../">Home</a>
</body>
</html>
