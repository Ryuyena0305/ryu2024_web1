package day05;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day05/board/view")
public class BoardController2 extends HttpServlet{

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int bno =  Integer.parseInt( req.getParameter("bno") ) ;
            BoardDto boardDto = BoardDao.getInstance().findById( bno );
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString( boardDto );
            resp.setContentType("application/json");
            resp.getWriter().print( jsonString );
    } // f end 
}
