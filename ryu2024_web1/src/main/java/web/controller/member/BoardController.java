package web.controller.member;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;

@WebServlet("/board")
public class BoardController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// JSON문자열 -> 특정한 자바 객체 타입으로 변환기능을 제공하는 라이브러리 객체 생성
		ObjectMapper mapper= new ObjectMapper();
		// HTTP의 request Body로 부터 JSON문자열을 읽어와서 BoardDto 타입으로 변환하는 readValue 함수 실행
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		
		//읽어온 자료를 Dao에게 전달하고 결과를 받는다.
		boolean result = BoardDao.getInstance().write(boardDto);
		// HTTP로 부터 response
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
}
