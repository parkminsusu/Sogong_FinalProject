package kr.ac.mju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	private final static String URL="jdbc:mysql://localhost:3306/";
	private final static String ID="root";
	private final static String PASSWORD="1234";
	User user = new User();
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void InsertData(String id,String password,String name,String job) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;

		String userid = id;
		String userpassword = password;
		String username = name;
		String userjob = job;
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sogongdb",
				ID, PASSWORD);
		

		statement = connection.prepareStatement("Insert into user values (?,?,?,?)");
		statement.setString(1, username);
		statement.setString(2, userjob);
		statement.setString(3, userid);
		statement.setString(4, userpassword);
		statement.executeUpdate();
	
		
		System.out.println("데이터 삽입 완료");
		
		
		connection.close();
		statement.close();
	}
	
	public String Login(String userID,String userPassword) throws SQLException{
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sogongdb",
				ID, PASSWORD);
		
		statement = connection.prepareStatement("SELECT * FROM USER");
		rs = statement.executeQuery();
		
		while (rs.next()) {
			String checkid = rs.getString("id");
			String checkpassword = rs.getString("password");
			String checkjob = rs.getString("job");
			String checkname = rs.getString("name");
			
			if(checkid.equals(userID) && checkpassword.equals(userPassword)){
				user.setUserID(checkid);
				user.setUserJob(checkjob);
				user.setUserName(checkname);
				user.setUserPassword(checkpassword);
				
				connection.close();
				statement.close();
				return "true";
			} 
		}
		connection.close();
		statement.close();
		return "false";
	}
	
	public void CreateLecture(String cno,String name,String cyear,String year,String units,String credit,String userName) throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sogongdb",
				ID, PASSWORD);
		

		statement = connection.prepareStatement("Insert into Lecture values (?,?,?,?,?,?,?)");
		statement.setString(1, cno);
		statement.setString(2, name);
		statement.setString(3, cyear);
		statement.setString(4, year);
		statement.setString(5, units);
		statement.setString(6, credit);
		statement.setString(7, userName);
		statement.executeUpdate();
		
		
		System.out.println("데이터 삽입 완료");
		
		
		connection.close();
		statement.close();
	}
	
	public void sugang(String userID,String cno,String cname,String pname,String cyear ,String year,String credit,String units) throws SQLException{
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sogongdb",
				ID, PASSWORD);
		
		
		statement = connection.prepareStatement("SELECT * from sugang");
		rs = statement.executeQuery();
		
		while (rs.next()) {
			String ID = rs.getString("ID");
			String coursenumber = rs.getString("cno");
			
			if(ID.equals(userID) && coursenumber.equals(cno)){
				return;
			}
		}
		
		statement = null;
		
		System.out.println("ID는 "  + userID);
		
		statement = connection.prepareStatement("Insert into sugang values (?,?,?,?,?,?,?,?,?)");
		statement.setString(1, userID);
		statement.setString(2, cno);
		statement.setString(3, cname);
		statement.setString(4, cyear);
		statement.setString(5, year);
		statement.setString(6, units);
		statement.setString(7, credit);
		statement.setString(8, pname);
		statement.setString(9, "unwritten");
		statement.executeUpdate();
	
		System.out.println("데이터 삽입 완료");
		
		
		connection.close();
		statement.close();
		rs.close();
		
		return;
	}
	
	public void GraintGrade(String userID, String cno, String grade) throws SQLException{
		
		Connection connection = null;
		PreparedStatement statement = null;

		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sogongdb",
				ID, PASSWORD);
		
		statement = connection.prepareStatement("Update sugang set grade=? where id=? and cno=?");
		statement.setString(1, grade);
		statement.setString(2, userID);
		statement.setString(3, cno);
		statement.executeUpdate();
		
		connection.close();
		statement.close();
	}

}
