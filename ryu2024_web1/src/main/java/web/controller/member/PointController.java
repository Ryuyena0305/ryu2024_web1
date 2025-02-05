package web.controller.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.MemberDao;
import web.model.dao.PointDao;
import web.model.dto.MemberDto;
import web.model.dto.PointDto;

@WebServlet("/point")
public class PointController extends HttpServlet {
       
        
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                System.out.println(" /point get ok ");

                Object result = null;
                
                Object object = req.getSession().getAttribute("loginMno");
                if( object != null ) {
                        int loginMno = (Integer)object;
                        result = MemberDao.getInstance().getPointLog( loginMno );
                }
                ObjectMapper mapper = new ObjectMapper();
                String jsonResult = mapper.writeValueAsString( result );
                
                resp.setContentType("application/json");
                resp.getWriter().print( jsonResult );
                
        } // f end 
}

