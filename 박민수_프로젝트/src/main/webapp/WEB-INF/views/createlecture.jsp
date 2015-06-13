<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>강좌 개설 화면</title>
</head>
<body>
<center>
<h1>강좌 개설 화면</h1><br/><br/>
<div class="form-group">
<form action="${pageContext.request.contextPath}/LoginController/createlecture1.do" method="post">
	<input type="text" name="cno" class="form-control" style="width: 200px" placeholder="강좌번호"><br/>
	<input type="text" name="name" class="form-control" style="width: 200px" placeholder="과목명"><br/>
	<input type="text" name="cyear" class="form-control" style="width: 200px" placeholder="연도"><br/>
	<input type="text" name="year" class="form-control" style="width: 200px" placeholder="학년"><br/>
	<input type="text" name="units" class="form-control" style="width: 200px" placeholder="정원"><br/>
	<input type="text" name="credit" class="form-control" style="width: 200px" placeholder="학점"><br/>
	<input type="submit" value="완료" class="btn btn-default">
</form>
</div>
</center>


</body>
</html>