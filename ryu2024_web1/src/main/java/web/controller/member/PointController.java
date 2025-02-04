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

@WebServlet("/member/point")
public class PointController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDto result1 = null;
        ArrayList<PointDto> result2 = new ArrayList<>();
        
        HttpSession session = req.getSession();
        Object object = session.getAttribute("loginMno");
        
        if (object != null) {
            int loginMno = (Integer) object;
            // 로그인된 회원 정보를 가져옴
            result1 = MemberDao.getInstance().myInfo(loginMno);
            
            // 해당 회원의 포인트 정보도 가져옴
            result2 = PointDao.getInstance().myPoint(loginMno);  // 포인트 정보는 로그인된 회원 번호를 통해 가져옴
        }

        // 응답에 포함할 데이터를 묶어서 전달
        ObjectMapper mapper = new ObjectMapper();
        
        resp.setContentType("application/json");
        
        // 응답으로 반환할 데이터에 MemberDto와 PointDto를 바로 매핑
        if (result1 != null && result2 != null) {
            // 바로 직렬화하여 반환
            mapper.writeValue(resp.getWriter(), result1);  // 회원 정보
            mapper.writeValue(resp.getWriter(), result2);  // 포인트 정보
        }
    }
}


