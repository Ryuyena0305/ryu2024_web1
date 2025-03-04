
// [1] 로그인 요청 함수 
const onLogin = ( ) => {
        // 1. HTML INPUT DOM 가져오기 
        const midinput = document.querySelector('.midinput');
        const mpwdinput = document.querySelector('.mpwdinput');
        // 2. INPUT 입력값 가져오기 
        const mid = midinput.value;
        const mpwd = mpwdinput.value;
        // 3. 유효성검사
        // 4. fetch 
        // * 보낼 데이터를 객체(JSON) 화 
        const obj = { mid : mid , mpwd : mpwd }
        // * fetch 설정
        const option = {
                method : 'POST' ,
                headers : { 'Content-Type' : 'application/json'},
                body : JSON.stringify( obj )
        }
        // * fetch 
        fetch( '/ryu2024_web1/member/login' , option )
                .then( response => response.json() )
                .then( data => { 
                        if( data > 0 ){ alert('로그인성공')
							 location.href="../index.jsp"; 
						   alarmSocket.send( `${mid}님 접속했어요.`)}
                        else{ alert('로그인실패'); }
                })
                .catch( error => { console.log(error )})
} // f end 

