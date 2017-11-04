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
	<div class="select-school">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-3 col-md-6">
					<div class="school-select">
						<form action="login.html">
						<label>Select School</label>
						<input list="schoolList" type="text" class="form-control" placeholder="Select School">
							<!-- This DropDown will change in future -->
							<datalist id="schoolList">
								<option value="School 1"/>
								<option value="School 2"/>
								<option value="School 3"/>
							</datalist>
						<button href="login.html" class="btn submit-btn">Submit</button>
						<hr>
						<a href="#">Register School</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	</body>
</html>