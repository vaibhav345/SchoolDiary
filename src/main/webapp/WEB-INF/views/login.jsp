<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>School Diary</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/vegas.min.css" type="text/css">
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="login">
    <div class="container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <div class="school-select">
                    <div>

                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active">
                                <a href="#student" aria-controls="home" role="tab" data-toggle="tab">Student Login</a>
                            </li>
                            <li role="presentation">
                                <a href="#teacher" aria-controls="profile" role="tab" data-toggle="tab">Teacher Login</a>
                            </li>

                        </ul>

                        <!-- Tab panes -->
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="student">
                                <form action="studentProfile.html">
                                    <label>Student login</label>
                                    <input type="text" class="form-control" placeholder="Enter Username">
                                    <input type="password" class="form-control" placeholder="Enter your Password">
                                    <button class="btn submit-btn">Submit</button>
                                </form>
                                <hr>
                                <a href="#" class="pull-right">Forget You Password?</a>
                                <a href="register.html">Click Here to Register</a>
                            </div>
                            <div role="tabpanel" class="tab-pane" id="teacher">
                                <form action="teacherProfile.html">
                                    <label>Teacher login</label>
                                    <input type="text" class="form-control" placeholder="Enter Username">
                                    <input type="password" class="form-control" placeholder="Enter your Password">
                                    <button class="btn submit-btn">Submit</button>
                                </form>
                                <hr>
                                <a href="#" class="pull-right">Forget You Password?</a>
                                <a href="register.html">Click Here to Register</a>
                            </div>
                        </div>

                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>