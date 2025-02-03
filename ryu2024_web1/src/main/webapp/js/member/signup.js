console.log("signup OK")
//[1] 회원가입 요청 함수
const onSignUp = () =>{
	//1. form을 한번에 가져오기 application/json이 아닌 multipart/form-data*\(첨부파일)
		// * form-data로 전송할 경우에은 속성명을 'name' 속성으로 사용된다.
	const signupform = document.querySelector('#signupform'); 
	console.log(signupform);
		
	//*. Fetch 이용한 multipart/form-data를 전송하는 방법
		//(1) 전송할 폼을 바이트(바이너리) 데이토로 전환, FormData클래스, new FormData(폼DOM);
	const signupformData = new FormData(signupform);
		//(2) fetch 옵션, content-type 생략하면 자동으로 'multipart/form-data' 적용된다.
	const option = {
		method : 'POST',
		//headers : { 'multipart/form-data' },
		body : signupformData//JSON.stringify() : 폼 전송은 json 형식이 아니므로 생략한다.
	}
	fetch('/ryu2024_web1/member/signup',option)
	.then(response => response.json())
	.then(data=>{
		if(data==true){
			alert('회원가입 성공'); 
			location.href="login.jsp";
		}else{
			alert('회원가입 실패');
		}
	})
	.catch(error =>{console.log(error)})
	
} //f e