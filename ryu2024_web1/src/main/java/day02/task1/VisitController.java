package day02.task1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//컨트롤러 : view와 dao 사이의 가교 역할, (서블릿 이용한)매핑/연결 역할
@WebServlet("/day02/visit") //[2] 매핑주소 정의
public class VisitController extends HttpServlet{
	//[3] HTTP METHOD 들을 재정의한다.
	//1. 방문록 등록(쿼리 스트링)	: Create C
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String content = req.getParameter("content");
		int age = Integer.parseInt(req.getParameter("age"));
		
		boolean result = VisitDao.getInstance().write(content, age);
		System.out.println(result);
	}
	//2. 방문록 조회			: Read R
	//3. 방문록 수정			: Update U
	//4. 방문록 삭제(쿼리스트링)	: Delete D
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));
		boolean result = VisitDao.getInstance().delete(num);
		System.out.println(result);
	}
}
