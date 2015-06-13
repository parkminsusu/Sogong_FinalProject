<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
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
<title>수강 신청 화면</title>
</head>
<center><h1>수강 신청 화면</h1></center><br/><br/>

<body>
<div class="col-md-8">
	<table class="table table-striped" style="margin-left: 250px">
		<tr>
			<td width="100">강좌번호</td>
			<td width="200">과목명</td>
			<td width="100">담당교수</td>
			<td width="100">연도</td>
			<td width="100">학년</td>
			<td width="100">학점</td>
			<td width="100">정원</td>
			<td width="100">신청하기</td>
		</tr>
		<%
			String URL = "jdbc:mysql://localhost:3306/";
			String ID = "root";
			String PASSWORD = "1234";

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sogongdb", ID, PASSWORD);

			pstmt = conn.prepareStatement("SELECT * from lecture");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String cno = rs.getString("cno");
				String cname = rs.getString("cname");
				String cyear = rs.getString("cyear");
				String year = rs.getString("year");
				String units = rs.getString("units");
				String credit = rs.getString("credit");
				String pname = rs.getString("pname");
		%>



		<tr>
			<td width="100"><%=cno%></td>
			<td width="100"><%=cname%></td>
			<td width="100"><%=pname%></td>
			<td width="100"><%=cyear%>
			<td width="100"><%=year%>
			<td width="100"><%=credit%>
			<td width="100"><%=units%>
			<td width="100">
				<form
					action="${pageContext.request.contextPath}/LoginController/registlecture1.do"
					method="post">
					<input type="hidden" name="cno" value="<%=cno%>"> 
					<input type="hidden" name="cname" value="<%=cname%>"> 
					<input type="hidden" name="pname" value="<%=pname%>"> 
					<input type="hidden" name="cyear" value="<%=cyear%>"> 
					<input type="hidden" name="year" value="<%=year%>"> 
					<input type="hidden" name="credit" value="<%=credit%>"> 
					<input type="hidden" name="units" value="<%=units%>"> 
					<input type="submit" value="신청" class="btn btn-default">
				</form>
			</td>
		</tr>

		<%
			}
		%>
	</table>
	
	<br />
	<br />
	<br />
	
	<div style="margin-left: 950px">
	<form action="${pageContext.request.contextPath}/LoginController/logout.do" method="post">
			<input type="submit" name="logout" value="로그아웃" class="btn btn-default">
	</form>
	</div>
</div>
	<%
		conn.close();
		pstmt.close();
		rs.close();
	%>
</body>
</html>