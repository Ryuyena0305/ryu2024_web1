package test;

import java.io.IOException;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test2")
public class MemberController2 extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mno =  Integer.parseInt( req.getParameter("CUSTNO") ) ;
        MemberDto memberDto = MemberDao.getInstance().findById( mno );
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString( memberDto );
        resp.setContentType("application/json");
        resp.getWriter().print( jsonString );
	}
	

}
