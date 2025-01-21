
//[1] 람다식 힘수 정의
//const 상수명 = ()=>{}
const func1 = ()=>{
	console.log('func1 execute');
}

//[2] 람다식 함수 정의 안에서 fetch 함수 활용
const func2 = ()=>{
	//**fetch : HTTP 비동기 통신 제공하는 함수
	//day02의 example1 서블릿 클래스의 doget메소드 매핑
	fetch('http://localhost:8080/ryu2024_web1/day02/example1')
	
}//f e

//
const func3 = ()=>{
	fetch(`/ryu2024_web1/day02/example1`,{method:'POST'})
}

const func4 = ()=>{
	fetch(`/ryu2024_web1/day02/example1`,{method:'PUT'})
}
const func5 = ()=>{
	fetch(`/ryu2024_web1/day02/example1`,{method:'DELETE'})
}

const func6 = ()=>{
	let name='유재석';
	let age = 40;
	fetch(`/ryu2024_web1/day02/example2?name=${name}&age=${age}`)
}

const func7 = ()=>{
	let name='정준재';
	let age = 23;
	const option = {method : 'POST'}
	fetch(`/ryu2024_web1/day02/example2?name=${name}&age=${age}`,option);
}
const func8 = ()=>{
	let name='오원석';
	let age = 25;
	const option = {method : 'PUT'}
	fetch(`/ryu2024_web1/day02/example2?name=${name}&age=${age}`,option);
}
const func9 = ()=>{
	let name='최지훈';
	let age = 29;
	const option = {method : 'DELETE'}
	fetch(`/ryu2024_web1/day02/example2?name=${name}&age=${age}`,option);
}

const func10 = () =>{
	let object = {data1:'유재석',data2:50}
	const option ={
		method : 'POST',
		headers : {'Content-Type':'application/json'},
		body : JSON.stringify(object)//HTTP통신은 문자열타입만 가능하다
	}
	fetch(`/ryu2024_web1/day03/example3`,option);
}

const func11 = ()=>{
	let object = {data1:'박지환',data2:21}
	const option = {
		method : 'PUT',
		headers : {'Content-Type':'application/json'},
		body : JSON.stringify(object)//HTTP통신은 문자열타입만 가능하다
	}
	fetch(`/ryu2024_web1/day03/example3`,option);
}// f e

const func12 = ()=>{
	const option = {method : 'GET'}
	fetch(`/ryu2024_web1/day03/example5`,option)
	.then(response => response.json())
	.then((data) => {console.log(data);})
}// f e

const func13 = ()=>{
	const option = {method : 'POST'}
	fetch(`/ryu2024_web1/day03/example5`,option)
	.then(response => response.text())
	.then((data) => {console.log(data);})
}// f e

const func14 = ()=>{
	const option = {method : 'PUT'}
	fetch(`/ryu2024_web1/day03/example5`,option)
	.then(response => response.json())//통신 성공시
	.then((data) => {console.log(data);})
	.catch(error =>{console.log(error);})//통신 실패시

}// f e

const func15 = ()=>{
	const option = {method : 'DELETE'}
	fetch(`/ryu2024_web1/day03/example5`,option)
	.then(response => response.json())
	.then((data) => {console.log(data);})
	.catch(e =>{console.log(e)})
}// f e

/*
	fetch( `HTTP URL` , {옵션} )
		.then( response객체 => response.타입() )
		.then( 타입변환된자료 => { 실행문 } )
		
	
		URL 
			1. 통신할 서블릿의 URL 주소 
			2. 쿼리스트링 
		옵션
			1. METHOD 
				- GET : fetch( `HTTP URL` , { method: `GET` } )]
					-> GET METHOD는 기본값이므로 생략이 가능하다.
					
				- POST : fetch( `HTTP URL` , { method: `POST` } )
				- PUT : fetch( `HTTP URL` , { method: `PUT` } )
				- DELETE : fetch( `HTTP URL` , { method: `DELETE` } )
			2. HEADERS
				- { 'Content-Type' : 'application/json' }
			3. BODY : 
				- 전송할 데이터 자료 
		then( )
			1. 응답객체 : 통신한 응답의 정보가 담긴 HTTP 응답 객체 반환 
				then( 응답객체명 => 응답객체명.json() ) : response content-type : application/json 변환
				then( 응답객체명 => 응답객체명.text() ) : response content-type : text/plain 변환
		then( )
			1. 변환된 자료 객체 		
		catch( )
			
  	
	[참고1 : 백틱]
	`` : 백틱 템플릿 : 문자열 사이에 변수/함수 호출 과 연산식을 넣을수 있는 템플릿 
		`문자열 ${ 변수명 } 문자열 ${ 함수명() } 문자열 ${ 연산 } `
	
	[참고2 : JSON 문자열 타입변환 ]
		1. JSON.parse( )		: 문자열타입 --> JSON타입 변환 함수. 
		2. JSON.stringify( )	: JSON타입 --> 문자열타입 변환 함수.
		
*/