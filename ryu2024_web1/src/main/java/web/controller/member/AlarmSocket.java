package web.controller.member;

import java.util.List;
import java.util.Vector;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/alarmsocket")
public class AlarmSocket {
	private static List<Session> onList = new Vector<>();

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("open ok");
		onList.add(session);
	}

	@OnClose
	public void onClose(Session session) {

		onList.remove(session);
	}

	@OnMessage // 클라이언트 가 보낸 메시지를 서버가 정석적으로 받았을때. (자동) 실행 
    public void onMessage( Session session , String message ) {
            // - 현재 접속된 모든 클라이언트 소켓들에게 받은 메시지를 보낸다. -
            for( int index = 0 ; index <= onList.size() - 1 ; index++ ) {
                    Session client = onList.get(index);
                    try {client.getBasicRemote().sendText(message);
                    }catch (Exception e) { System.out.println( e ); }
            }
 
	}

}// m e
