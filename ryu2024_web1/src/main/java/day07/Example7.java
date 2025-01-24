package day07;

import java.io.IOException;
import java.lang.classfile.attribute.ModuleTargetAttribute;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/day07/example7")
public class Example7 extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	//[1] 톰캣 안에 있는 객체 호출 및 (첫 HTTP요청)
	HttpSession httpSession = req.getSession();
	System.out.println(httpSession);
	// 1요청시 : org.apache.catalina.session.StandardSessionFacade@6db14c71
	// 2요청시 : org.apache.catalina.session.StandardSessionFacade@6db14c71
	
	//[2] 세션 객체의 주요 메소드
	System.out.println(httpSession.getAttributeNames()); //세션객체내 모든 속성 반환 함수
	// 1요청시 : java.util.Collections$3@6376bfb7
	// 2요청시 : java.util.Collections$3@6376bfb7
	System.out.println(httpSession.getCreationTime());	//세션 객체가 만들어진 시간
	// 1요청시 : 1737706458761
	// 2요청시 : 1737706458761
	System.out.println(httpSession.getId());			//세션 객체의 아이디/식별자
	//1요청시 : 47DBC97384834895FA8B500C12E0AEAB
	//2요청시 : 47DBC97384834895FA8B500C12E0AEAB
	System.out.println(httpSession.getLastAccessedTime());//마지막으로 세션 객체 사용한 시간
	//1요청시 : 1737706458761
	//2요청시 : 1737706458761
	System.out.println(httpSession.isNew());			//새로 만들어진 세션 인지 여부 반환	
	//1요청시 : true
	//2요청시 : false
	
	// [3] 세션 객체의 속성명 과 값 저장 
	httpSession.setAttribute( "세션속성1", "정준재" );
			
	// [4] 세션 객체의 지정한 속성명의 값 호출 
	Object object = httpSession.getAttribute("세션속성1") ;
	System.out.println( (String)object );
			
	// [5] 세션 객체의 지정한 속성 제거 
	httpSession.removeAttribute("세션속성1");
	}
}
