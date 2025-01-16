package day02.task1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day02/waiting")
public class WaitingController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phoneNum = req.getParameter("phoneNum");
		int pNum = Integer.parseInt(req.getParameter("pNum"));
		boolean result = WaitingDao.getInstance().write(phoneNum,pNum);
		System.out.println(result);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int Num = Integer.parseInt(req.getParameter("Num"));
		boolean result = WaitingDao.getInstance().delete(Num);
		System.out.println(result);
	}
}
