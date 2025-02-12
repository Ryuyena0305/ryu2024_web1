console.log('chatting.js open')

//[1] WebSocket 클래스 이용하여 클라이언트 소켓
let clientSocket = new WebSocket('ws://localhost:8080/ryu2024_web1/chatsocket');

//[2] 접속/연결(상태유지)된 서버소켓에게 메시지 전송 ,.send("메시지")
//clientSocket.send('서버소켓아 안녕!');

//전송버튼을 클릭했을 때 실행할 함수
const onMsgSend = () => {
	
	//(1) 입력받은 값 가져오기
	const msg = document.querySelector('.msginput').value;
	clientSocket.send(msg);
	
	//clientSocket.send("서버 소켓아 안녕!!")
}//f e

//[3] 서버 소켓이 클라이언트 소켓으로부터 메시지를 보냈을 때
clientSocket.onmessage = ( msgEvent ) =>{
	console.log('서버소켓으로 부터 메세지 왔다.')
	console.log(msgEvent);
	console.log(msgEvent.data);
	
	//(1) 받은 메세지를 html에 출력하기
	//1. 어디에
	const msgbox = document.querySelector('.msgbox')
	//2. 무엇을
	let html = `<div> ${msgEvent.data}`
	msgbox.innerHTML += html;
	
}