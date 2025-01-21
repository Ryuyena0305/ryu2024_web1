package day03.task1;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//컨트롤러 : view와 dao 사이의 가교 역할, (서블릿 이용한)매핑/연결 역할
@WebServlet("/day03/visit") //[2] 매핑주소 정의
public class VisitController extends HttpServlet{
		//1. 방문록 등록 : 등록은 주로 POST
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. BODY(본문)의 JSON을 DTO로 파싱/변환 하기 위한 인스턴스 생성/준비
		ObjectMapper mapper = new ObjectMapper();
		//2. 변환
		VisitDto visitDto = mapper.readValue(req.getReader(), VisitDto.class);
		System.out.println(visitDto);
		//3.DAO 처리
		boolean result = VisitDao.getInstance().write(visitDto);
		System.out.println(result);
		
	}
		//2. 방문록 삭제 : 삭제는 주로 DELETE
	@Override
	//HTTP DELETE queryString : http://localhost:8080/ryu2024_web1/day03/visit?bno=삭제할번호
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1.queryString이 매개변수를 위한 코드
		int num = Integer.parseInt(req.getParameter("num"));
		System.out.println("num : "+num);
		boolean result = VisitDao.getInstance().delete(num);
		System.out.println(result);
	}
	
}
