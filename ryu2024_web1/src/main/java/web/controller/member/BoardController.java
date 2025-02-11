package web.controller.member;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;
import web.model.dto.PageDto;

@WebServlet("/board")
public class BoardController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// JSON문자열 -> 특정한 자바 객체 타입으로 변환기능을 제공하는 라이브러리 객체 생성
		ObjectMapper mapper= new ObjectMapper();
		// HTTP의 request Body로 부터 JSON문자열을 읽어와서 BoardDto 타입으로 변환하는 readValue 함수 실행
		BoardDto boardDto = mapper.readValue(req.getReader(), BoardDto.class);
		
		//+ 현재 로그인된 회원번호를 세션에서 찾아 boardDto 담아주기
		//요청 정보의 세션 객체 호출
		HttpSession session = req.getSession();
		//세션 객체내 특정한 속성(로그인된 회원번호)의 값 꺼내기, .getAttribute("속성명");
		// 모든 세션 객체 내 속성은 Object 타입이다.
		Object object = session.getAttribute("loginMno");
		// 세션 객체 내 로그인된 회원번호 속성이 존재하면
		if(object != null) {
			//boardDto에 로그인된 회원번호 담아주기, 게시물 작성자==로그인된 회원
			int loginMno = (Integer)object;
			boardDto.setMno(loginMno);
		}
		
		//읽어온 자료를 Dao에게 전달하고 결과를 받는다.
		boolean result = BoardDao.getInstance().write(boardDto);
		// HTTP로 부터 response
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//[1] 요청 매개변수 x
		int cno = Integer.parseInt(req.getParameter("cno"));
		int page = Integer.parseInt(req.getParameter("page"));
		
		// 페이징 철리에 필요한 자료를 준비
		//1. 1페이지 당 출력할 게시물 수 
		int display  = 5; //페이지 1개당 게시물 5개씩 출력할 예정
		//2. 페이지당 조회할 게시물의 시작번호
		int startRow = (page-1)*display;
			//게시물이 10개 존재한다고 가정 : 0 1 2 3 4 5 6 7 8 9 
			//1페이지 시작번호 0번 , 2페이지 시작번호 5번 
		//3.게시물의 전체 페이지수 구하기
		int totalSize = BoardDao.getInstance().getTotalSize(cno);
		//4. 특정 카테고리 게시물의 전체 게시물 수 구하기
		int totalPage = 0;
		if(totalSize%display==0) {
			//전체 게시물 수 나누기 페이지당 게시물 수 했을 때 나머지가 없으면
			totalPage = totalSize/display;
		}else {
			totalPage = totalSize/display+1;
		}
		//5. 페이지당 버튼 수
		int btnSize = 5;
		//6. 시작버튼 번호 구하기
		int startBtn = ((page-1)/btnSize) * btnSize+1;
		//7. 끝번호 번호 구하기
		int endBtn = startBtn +(btnSize-1);
		// * 만약에 끝번호가 전체 페이지수 보다 커지면 안되므로 끝번호가 전체페이지수 보다 커지면
		if(endBtn>totalPage) endBtn = totalPage;
		
		
		//[2] DAO에게 전체 게시물 요청하고 결과 받기
		ArrayList<BoardDto> result = BoardDao.getInstance().findAll(cno,startRow,display);
		
		//8. PageDto 객체 만들기
		PageDto pageDto = new PageDto();
		pageDto.setTotalCount(totalSize); //조회된 전체 게시물 수
		pageDto.setPage(page); //현재페이지
		pageDto.setTotalpage(totalPage);//전체페이지수
		pageDto.setStartbtn(startBtn);//페이징 버튼 시작번호
		pageDto.setEndbtn(endBtn);//페이징 버튼 끝 번호
		pageDto.setData(result);
		
		
		//[3] 받은 전체 게시물을 JSON 형식의 문자열로 변환하기
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(pageDto);
		//[4] http response
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
	
	 // [4] 게시물 개별 수정 컨트롤러 
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println(" board put ok ");
            // [1] 
            ObjectMapper mapper = new ObjectMapper(); 
            // [2]
            BoardDto boardDto = mapper.readValue( req.getReader() , BoardDto.class );
            // [3]
            boolean result = BoardDao.getInstance().update( boardDto );
            // [4]
            resp.setContentType("application/json");
            resp.getWriter().print(result);
    }
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 // [1] HTTP queryString 매개변수를 가져오기 , URL?bno=1 , req.getParameter("매개변수명") : 반환타입 문자열 이므로 타입변환 필요할 수 있다.
        // Integer.parseInt( "문자열") : 문자열 타입 --> 정수 타입 변환 함수.
		int bno = Integer.parseInt(req.getParameter("bno"));
		 // [2] Dao 에게 삭제할 번호를 전달하고 결과 받기 
		boolean result = BoardDao.getInstance().delete(bno);
		// [3] 결과를 HTTP의 response 로 응답하기
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
}
