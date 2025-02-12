package web.controller.member;


import java.rmi.server.RMIClientSocketFactory;
import java.util.List;
import java.util.Vector;

import com.mysql.cj.xdevapi.Client;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatsocket")
public class ServerSocket {
	//[*] 접속된 세션(접속성공한 클라이언트 소켓 정보) 저장, list 컬력션으로 여러개 Session을 저장하기
	//*세션이란? 네트워크 상의 정보를 저장하는 공간, HTTP 세션 vs WS 세션
	//static 이란? 프로젝트 내 하나의 변수를 만들 때 사용되는 키워드, 전역변수
	private static List< Session > 접속명단 = new Vector<>();
	
	//[1] 클라이언트 소켓이 서버소켓에 접속했을 때, onOpen
	@OnOpen
	public void onOpen(Session session) {
		//Session : import : jakarta.websocket
		
		System.out.println("클라이언트 ws 접속 성공");
		System.out.println(session);
		//* onOpen( 클라이언트가 정상적으로 서버와 접속 성공했을 때 )
		접속명단.add(session);
		System.out.println(접속명단);
	}// f e
	//[2] 클라이언트 소켓이 서버소켓으로부터 메시지를 보냈을 때 onMessage
	@OnMessage
	public void onMessage(Session session,String message) {
		System.out.println("클라이언트 소켓으로부터 메시지가 왔다");
		System.out.println(message);
		
		//* 서버가 클라이언트에게 메시지 전송
//		try {
//			session.getBasicRemote().sendText("클라이언트 소켓 완성!");
//			
//		}catch(Exception e) {
//			System.out.println(e);
//		}
		
		//(1) 받은 메세지를 접속된 모든 세션(클라이언트 소켓)들에게 메세지 보내기
		//1. 받은메세지 = 매개변수의 message
		//2. 접속 명단 : private static List<Session> 접속명단 = new Vector<>();
		//3. 반복문 이용한 접속명단 순회
		for(int index = 0; index<=접속명단.size()-1;index++) {
			//4. 접속된 명단의 index번째 세션(접속정보)가져오기
			Session clientSocket = 접속명단.get(index);
			//5. inex번째 세션에 (서버가 받은)메세지를 보내기, 예외처리
			try {
				clientSocket.getBasicRemote().sendText(message);
			}catch(Exception e) {System.out.println(e);}
		}
	}//f e 
	//[3] 클라이언트 소켓과 영ㄴ결이 닫혔을 때(클라이언트 소켓(객체)의 포함된 JS가 새로고침(객체가 지워졌을 때) 실행행되는 함수
	@OnClose
	public void onClose(Session session) {
		//클라이언트 소켓과 연결이 닫혔을 때 명단에서 제외
		접속명단.remove(session);//접속이 닫힌 클라이언트 소켓을 리스트에서 제거
	}
	
	

	
	

}//m e
