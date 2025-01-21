

//1. 등록 함수
const visitWrite = () =>{
	
	//1. HTML으로부터 input dom 객체 가져오기
	//- document. querySelector(선택자) : 선택자 마크업을 객체로 반환함수
	let contentInput = document.querySelector('.contentInput');
	let ageInput = document.querySelector('.ageInput');
	//2. 입력받은 값 가져오기
	//- .value : 마크업의 value 속성
	let content = contentInput.value;
	let age = ageInput.value;
	
	//3. 객체화
	let dataObj = {'content':content,'age':age};
	
	//4. fetch 통신
	let option = {
		method:'POST', //HTTP METHOD 방법 선택
		headers : {'Content-Type' : 'application/json'}, //HTTP 요청 HEADER CONTENT-TYPE
		body : JSON.stringify(dataObj)//본문에 보낼 자료를 문자열타입으로 변환
		}
		fetch('/ryu2024_web1/day03/visit2',option)
		.then(r=>r.json())
		.then(data =>{
			//5. 결과에 따른 화면 구현
			if(data==true){
				alert('등록성공');
				visitFindAll();
			}else{
				alert('등록실패');
			}
		})
		.catch(e=>{console.log(e)})
	
}

//2. 전체 조회 함수, 실행조건 : 1. JS 열릴 때 2. 등록성공했을 때

const visitFindAll = () =>{
	//1.어디에 ,tbody
	let tbody = document.querySelector('tbody')
	//2.무엇을 ,fetch로 받은 자료들을
	let html = ''
	
		//2-1 fetch 이용한 서블릿에게 자료를 HTTP GET METHOD 요청
		const option = {method : 'GET'}
		//2-2 fetch
		fetch('/ryu2024_web1/day03/visit2')
		.then(r=>r.json())
		.then(data =>{
			//for(let index=0;index<=data.length-1;index++){}
			data.forEach(obj=>{
				html+=`<tr>
				<td>${obj.num}</td>
				<td>${obj.content}</td>
				<td>${obj.age}</td>
				<td>
				<button onclick="visitUpdate( ${obj.num} )">수정</button>
				<button onclick="visitDelete( ${obj.num} )">삭제</button>
				</td>
				</tr>`
				
			})//for e
			//3. 출력
				tbody.innerHTML = html;
				
		})//then2 e
		.catch(e=>{console.log(e);})	
	
	
	
}
visitFindAll(); //1.JS열릴 때

//3. 수정 함수
const visitUpdate = (num) =>{
	
	//1. 수정할 식별자(num)
	//2. 수정할 내용 content/age
	let newContent = prompt('new Content : ');
	let newAge = prompt('new Age: ');
	let dataObj = {num:num,content:newContent,age:newAge}
	const option = {
		method : 'PUT',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	fetch('/ryu2024_web1/day03/visit2',option)
	.then(r=>r.json())
	.then(data=>{
		if(data==true){alert('수정성공'); visitFindAll();}
		else{alert('수정실패');}
})
	.catch(e=>{console.log(e);})	

}


//4. 삭제 함수
const visitDelete = (num) =>{
	//1. 삭제할 식별자 num
	//2. fetch이용한 서블릿에게 자료를 HTTP delete METHOD 처리 요청
	const option = {method : 'DELETE'}
	fetch(`/ryu2024_web1/day03/visit2?num=${num}`,option)
	.then(r =>r.json())// 응답 결과를 Json타입으로 변환
	.then(data =>{
		if(data==true){
			alert('삭제성공'); visitFindAll();}
		else{alert('삭제실패');}
	})
	.catch(e=>{console.log(e)})
	
}