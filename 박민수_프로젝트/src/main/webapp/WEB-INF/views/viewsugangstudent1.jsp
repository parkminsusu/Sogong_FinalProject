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
<title>성적 부여 화면</title>
</head>
<body>

<center><h1>성적 부여 화면</h1></center><br/><br/>
	<div class="col-md-6">
	<table class="table table-striped" style="margin-left: 360px">
		<tr>
			<td width="100">학생</td>
			<td width="100">성적</td>
			<td width="300">성적 부여</td>
		</tr>
		<%
			String cno = request.getParameter("cno");	
		
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

			pstmt = conn.prepareStatement("select * from sugang natural join user where cno=?");

			pstmt.setString(1, cno);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("name");
				String grade = rs.getString("grade");
				String id = rs.getString("id");
		%>

		<tr>
			<td width="100"><%=name%></td>
			<td width="100"><%=grade%></td>
			<td width="300">
			<form action="${pageContext.request.contextPath}/LoginController/grantgrade3.do"
					method="post" class="form-inline">
					<input type="hidden" name="id" value="<%=id%>">
					<input type="hidden" name="cno" value="<%=cno%>">
					<input type="text" name="grade" class="form-control" style="width: 150px" placeholder="성적입력">
					<input type="submit" value="성적부여" class="btn btn-default" >
				</form>
			</td>
			</form>
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