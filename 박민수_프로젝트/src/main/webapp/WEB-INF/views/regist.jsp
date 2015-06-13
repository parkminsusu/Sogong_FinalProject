<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>회원가입 페이지</title>
</head>
<body>
	<center>
		<h1>회원가입 페이지</h1><br/><br/>
		<form
			action="${pageContext.request.contextPath}/LoginController/createaccount1.do"
			method="post">
			<input type="text" name="name" class="form-control"
				style="width: 200px" placeholder="이름"><br /> 
				<label class="checkbox-inline" style="font-size:18px">
				JOB : 학생 
				<input type="radio" name="job" value="student">&nbsp;&nbsp; 
				교수
				<input type="radio" name="job" value="professor"><br /><br/>
				</label>
				<input
				type="text" name="id" class="form-control" style="width: 200px" placeholder="ID"><br /> 
				<input type="password" name="password" class="form-control" style="width: 200px"
				placeholder="PASSWORD"><br /> 
				<input type="submit" value="완료" class="btn btn-default">
		</form>
	</center>
	<br/><br/>
	
</body>
</html>