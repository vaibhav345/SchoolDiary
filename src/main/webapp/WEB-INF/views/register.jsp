<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
</head>

<body>
<form:form id="regForm" modelAttribute="student" action="${pageContext.request.contextPath}/addStudent.json" method="post">

    <div class="form-group">
        <label>Name</label>
        <input id="name" type="text" name="name" class="form-control">
    </div>
    <div class="form-group">
        <label>Username</label>
        <input id="username" type="text" name="username" class="form-control">
    </div>
    <div class="form-group">
        <label>Password</label>
        <input id="password" type="password" name="password" class="form-control">
    </div>
    <div class="form-group">
        <label>Email</label>
        <input id = "email" type="text" name="email" class="form-control">
    </div>
    <button id="submitButton" type="submit" class="btn btn-primary" value="Submit">Submit</button>
</form:form>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/registerStudent.js"></script>
</body>
</html>