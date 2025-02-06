package day05;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day05/board")
public class BoardController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST OK");
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		boolean result = BoardDao.getInstance().write(boardDto);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET ALL OK");
		ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("PUT OK");
		ObjectMapper mapper =  new ObjectMapper();
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		boolean result = BoardDao.getInstance().update(boardDto);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DELETE OK");
		//HTTP queryString 매개변수를 가져오기, URL?bno=1, 
		int bno = Integer.parseInt(req.getParameter("bno"));
		boolean result = BoardDao.getInstance().delete(bno);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}

}