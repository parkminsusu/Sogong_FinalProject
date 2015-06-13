package kr.ac.mju;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@Autowired
	private LoginService service;

	@RequestMapping(value = "loginController/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {

		request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");

		if (service.Login(userID, userPW).equals("true")) {
			request.getSession().setAttribute("userID",
					service.user.getUserID());
			request.getSession().setAttribute("userJob",
					service.user.getUserJob());
			request.getSession().setAttribute("userName",
					service.user.getUserName());
			request.getSession().setAttribute("idcheck", "ture");
		} else {
			request.getSession().setAttribute("idcheck", "false");
		}

		return "redirect:/";
	}

	@RequestMapping(value = "LoginController/logout.do", method = RequestMethod.POST)
	public String logout(HttpServletRequest request)
			throws UnsupportedEncodingException {

		request.setCharacterEncoding("utf-8");
		request.getSession().removeAttribute("userID");
		request.getSession().removeAttribute("userJob");
		request.getSession().removeAttribute("userName");
		request.getSession().removeAttribute("idcheck");

		return "redirect:/";
	}

	@RequestMapping(value = "LoginController/createaccount.do", method = RequestMethod.POST)
	public String createaccount(HttpServletRequest request)
			throws UnsupportedEncodingException {

		request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("id");
		String userPW = request.getParameter("password");

		return "regist";
	}

	@RequestMapping(value = "LoginController/gohome.do", method = RequestMethod.POST)
	public String gohome(HttpServletRequest request)
			throws UnsupportedEncodingException {
		return "redirect:/";
	}

	@RequestMapping(value = "LoginController/createaccount1.do", method = RequestMethod.POST)
	public String createaccount1(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {

		request.setCharacterEncoding("utf-8");

		String userID = request.getParameter("id");
		String userPW = request.getParameter("password");
		String userJob = request.getParameter("job");
		String userName = request.getParameter("name");

		service.InsertData(userID, userPW, userName, userJob);

		request.getSession().setAttribute("userID", userID);
		request.getSession().setAttribute("userJob", userJob);
		request.getSession().setAttribute("userName", userName);

		return "redirect:/";
	}

	@RequestMapping(value = "LoginController/registlecture1.do", method = RequestMethod.POST)
	public String registlecture1(HttpServletRequest request)
			throws SQLException, IOException {

		request.setCharacterEncoding("utf-8");
	
		HttpSession session = request.getSession();

		String userID = (String) session.getAttribute("userID");
		String cno = request.getParameter("cno");
		String cname = request.getParameter("cname");
		String pname = request.getParameter("pname");
		String cyear = request.getParameter("cyear");
		String year = request.getParameter("year");
		String credit = request.getParameter("credit");
		String units = request.getParameter("units");

		service.sugang(userID, cno, cname, pname, cyear, year,credit, units);

		return "redirect:/";
	}

	@RequestMapping(value = "LoginController/createlecture.do", method = RequestMethod.POST)
	public String createlecture(HttpServletRequest request)
			throws UnsupportedEncodingException {

		return "createlecture";
	}

	@RequestMapping(value = "LoginController/createlecture1.do", method = RequestMethod.POST)
	public String createlecture1(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");

		String cno = request.getParameter("cno");
		String name = request.getParameter("name");
		String cyear = request.getParameter("cyear");
		String year = request.getParameter("year");
		String units = request.getParameter("units");
		String credit = request.getParameter("credit");

		service.CreateLecture(cno, name, cyear, year, units, credit, userName);

		return "redirect:/";
	}

	@RequestMapping(value = "LoginController/registlecture.do", method = RequestMethod.POST)
	public String registlecture(HttpServletRequest request)
			throws UnsupportedEncodingException {

		return "showlecturelist";
	}

	@RequestMapping(value = "LoginController/viewsugang.do", method = RequestMethod.POST)
	public String viewsugang(HttpServletRequest request)
			throws UnsupportedEncodingException {

		return "viewsugang";
	}


	@RequestMapping(value = "LoginController/viewgrade.do", method = RequestMethod.POST)
	public String viewgrade(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {

		return "viewgrade";
	}

	@RequestMapping(value = "LoginController/grantgrade.do", method = RequestMethod.POST)
	public String grantgrade(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {

		return "viewsugangstudent";
	}

	@RequestMapping(value = "LoginController/grantgrade1.do", method = RequestMethod.POST)
	public String grantgrade1(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {

		request.setCharacterEncoding("utf-8");

		String userID = (String) request.getParameter("userID");
		String lecname = (String) request.getParameter("lecname");
		String grade = (String) request.getParameter("grade");

		service.GraintGrade(userID, lecname, grade);

		return "redirect:/";
	}

	@RequestMapping(value = "LoginController/grantgrade2.do", method = RequestMethod.POST)
	public String grantgrade2(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String cno = request.getParameter("cno");
		return "viewsugangstudent1";
	}

	@RequestMapping(value = "LoginController/grantgrade3.do", method = RequestMethod.POST)
	public String grantgrade3(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {

		request.setCharacterEncoding("utf-8");

		String cno = request.getParameter("cno");
		String id = request.getParameter("id");
		String grade = request.getParameter("grade");

		service.GraintGrade(id, cno, grade);

		return "redirect:/";
	}

	@RequestMapping(value = "LoginController/viewstudentgrade.do", method = RequestMethod.POST)
	public String viewstudentgrade(HttpServletRequest request)
			throws UnsupportedEncodingException, SQLException {

		return "viewstudentgrade";
	}
}
