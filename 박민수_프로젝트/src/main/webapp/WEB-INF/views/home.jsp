<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>


<html>
<head>
<title>수강신청 홈페이지 입니다.</title>
</head>
<body>


	<br />
	<br />
	<br />
	<div style: align="center">

		<%
			HttpSession session = request.getSession();
			String check = (String) session.getAttribute("userJob");
			String userName = (String) session.getAttribute("userName");

			if (check == null) {
		%>
		<h2 align="center">학사관리 시스템</h2>
		<br /> ${serverTime} <br/><br/>

		<form action="loginController/login.do" method="post">
			ID <input type="text" name="userID" class="form-control" style="width: 200px"> <br /> PW <input
				type="password" name="userPW" class="form-control" style="width: 200px"> <br /> <br /> <input
				type="submit" value="로그인" class="btn btn-default">
		</form>
		<div style="margin-left: 950px">
		<form action="LoginController/createaccount.do" method="post">
			<input type="submit" value="회원가입" class="btn btn-default"></form></div>

		<%
			} else if (check.equals("student")) {
		%>
		<h1>학생 페이지</h1><br/>
		<h3><%=userName%>님 환영합니다.</h3>
		
		<br /> <br /> <br />
		
		<form action="LoginController/registlecture.do" method="post">
			<input type="submit" value="수강신청" class="btn btn-default"></form> 
		

		<form action="LoginController/viewgrade.do" method="post">
			<input type="submit" value="성적열람" class="btn btn-default"></form>
		
		<form action="LoginController/logout.do" method="post">
			<input type="submit" name="logout" value="로그아웃" class="btn btn-default">
		</form>

		<%
			} else if(check.equals("professor")){%>
			
			<h1>교수 페이지</h1><br/>
			<h3><%=userName%>님 환영합니다.</h3><br/><br/><br/>
			
				<form action="LoginController/createlecture.do" method="post">
					<input type="submit" value="강좌개설" class="btn btn-default"></form> 
					
				<form action="LoginController/grantgrade.do" method="post">
					<input type="submit" value="성적입력" class="btn btn-default"></form>	
				
				 
				<form action="LoginController/logout.do" method="post">
					<input type="submit" name="logout" value="로그아웃" class="btn btn-default"></form>
		<% }
		else{%>
		<h1>직업이뭐니 : <%=check %></h1>
		<%}%>
	</div>
</body>
</html>
