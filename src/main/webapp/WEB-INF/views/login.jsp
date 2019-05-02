<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/webjars/jquery/3.0.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/resources/css/main.css" rel="stylesheet" type="text/css"/>
    <title>Login</title>
</head>
<body>
<h1></h1>
<br><br>
<div class="container w-25">
    <div class="card cardBackground1" >
        <div class="card-header">GymTracker</div>
        <div class="card-body">
            <form method="post" action="login">
                <label for="userEmailId">Email</label>
                <input type="text" name="userEmail" class="form-control" id="userEmailId"/>
                <label for="userPasswordId">Password</label>
                <input type="password" name="userPassword" class="form-control" id="userPasswordId"/><br>
                <a href="/" class="btn btn-warning btn-sm" style="float: left">Back</a>
                <input class="btn btn-info btn-sm" type="submit" style="float: right;" value="Login"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>