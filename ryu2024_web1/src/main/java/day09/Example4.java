package day09;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day09/example4")
public class Example4 extends HttpServlet{
	
	//1. doPost : 파일 업로드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 현재 서블릿의 로컬 경로 알기, (즉 서버 경로 조회)
		
		String uploadPath = req.getServletContext().getRealPath("/upload");
		System.out.println(uploadPath);
		
		//2. 만약에 업로드할 폴더가 존재하지 않으면 생성
		File file = new File(uploadPath);
		if(!file.exists()) {
			System.out.println("경로상의 폴더가 없으므로 폴더 생성합니다.");
			file.mkdir();
		}
		//3. 서블릿의 HTTP 요청중 contentTypedl 'multipart/form-data'일 때 첨부파일을 업로드 하는 방법
			//1. 
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(file); //1. 저장위치 설정
		factory.setSizeThreshold(1024*1024); //2. 업로드 용량 제한 설정, 1byte기준, 1024byte ->1kb, 1024*1024 ->1mb
		factory.setDefaultCharset("UTF-8");//3.한글 인코딩 설정
		
			//2. ServletFileUpload 클래스에 위에서 설정한 기준으로 객체 생성한다.
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
			
			//3. 업로드 객체에 HTTP 요청 객체를 대입하여 HTTP 요청객체를 업로드객체로 변환한다.
		try {
		List<FileItem> formItems = fileUpload.parseRequest(req);
			//4. 만약에 업로드객체내 반환된 자료들이 존재하면
		if(formItems != null&& !formItems.isEmpty()) {
			//5. 반복문을 이용한 form 자료들을 하나씩 확인한다.
			for(int index=0;index<=formItems.size()-1;index++) {
				//6. 자료 1개만 추출
				FileItem fileItem =formItems.get(index);
				//7. 자료가 첨부파일(파일)인지 단순한 문자열인지 구분
				if(fileItem.isFormField()) {
					System.out.println("첨부파일이 아닌 텍스트");
				}else {
					System.out.println("첨부파일 : "+fileItem.getName());
					
					
					//* 만일 서로다른 사람이 동일한 파일명을 올릴경우 식별이 불가능 -> UUID 내장함수
					//- UUID는 16진수로 5칸의 임의 자료 생성한다.
					String uuid = UUID.randomUUID().toString();
					System.out.println(uuid);
					//- UUID와 업로드 파일명 연결, 만약에 파일명에 '-'(하이픈) 포함되면 uuid와 파일명 구분이 힘들다.
					//만약에 사용자가 업로드한 파일명에 -를 _로 변경하기 이유 : -는 uuid 구분용
					//"문자열".replaceAll("변경할문자","새로운문자"); : 문자열내 변경할 문자가 존재하면 새로운 문자롤 치환
					String filename = uuid+"-"+fileItem.getName().replaceAll("-", "_");
					
					//8. 만일 첨부파일이면 현재 경로에 파일명 붙이기
					File uploadFile = new File(uploadPath+"/"+filename);
					
					//9. 지정한 파일명으로 업로드 처리
					fileItem.write(uploadFile);	
				}
			}
		}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
