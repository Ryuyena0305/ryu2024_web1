package web.controller.member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

@WebServlet("/member/info")
public class InfoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDto result =null;
		
		HttpSession session = req.getSession();
		session.getAttribute("loginMno");
		Object object = session.getAttribute("loginMno");
		
		if(object != null) {
			int loginMno = (Integer)object;
			result = MemberDao.getInstance().myInfo(loginMno);
		}

	}
}
