package day02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/day02/example1")
public class Example1 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("1] HTTP 프로토콜 통신이 POST 방법으로 요청이 왔습니다.");
	}//f e
	
	//2. GET : doget + 자동완성
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("2] HTTP 프로토콜 통신이 GET 방법으로 요청이 왔습니다.");
	}
	
	//3. PUT : doput + 자동완성
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3] HTTP 프로토콜 통신이 PUT 방법으로 요청이 왔습니다.");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("4] HTTP 프로토콜 통신이 DELETE 방법으로 요청이 왔습니다.");
	}
}
