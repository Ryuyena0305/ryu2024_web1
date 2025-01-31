package day09;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day09/example3")
public class Example3 extends HttpServlet{
	//*여러개 map객체(Dto)를 저장할 list 선언
	//ArrayList<Dto> list = new ArrayList<>();
	ArrayList<HashMap<String,String>> list = new ArrayList<>();
	
	//* 파일 경로
	private String filePath = "c:/java";
	//1. doPost : 파일 쓰기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//(1) HTTP 요청 BODY 자료들을 HashMap타입으로 매핑하기
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String,String> map = mapper.readValue(req.getReader(), HashMap.class);
		
		//(2) 입력받은 map을 list에 저장
		list.add(map);
		//(3) 만약에 지정한 경로가 존재하지 않으면 폴더 경로 생성
		File file = new File(filePath);
		if(file.exists()) {file.mkdir();}
		//(4) 출력 스트림 객체
		FileOutputStream out = new FileOutputStream(filePath + "/test3.txt");
		//(5) 출력할 내용물 , list 타입을(JSON형식)문자열타입으로 변환
		String outStr = mapper.writeValueAsString(list);
		//(6) 출력할 내용물을 바이트로 변환
		byte []bytes = outStr.getBytes();
		out.write(bytes);
		
		
	}// f e
	//2.doGet : 파일 내용 가져오기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 지정한 파일 경로의 파일객체로 가져오기
		File file = new File(filePath+"/test3.txt");
		if( !file.exists()){
			System.out.println("파일이 존재하지 않습니다.");
			resp.setContentType("text.plain");
			resp.getWriter().print("파일이 존재하지 않습니다.");
		}else {
			// 파일의 자료들을 ArrayList 타입으로 변환
			ObjectMapper mapper = new ObjectMapper();
				//mapper.readValue(req.getReader()혹은 file,
			ArrayList<HashMap<String,String>>list = mapper.readValue(file,ArrayList.class);
			//4. 읽어온 파일의 list 내용들을 다시 json 문자열로 반환
			String jsonResult = mapper.writeValueAsString(list);
			//5. 파일의 내용들을 HTTP 응답하기
			resp.setContentType("application/json");
			resp.getWriter().print(jsonResult);
		}
				
	}
	

}// c e
