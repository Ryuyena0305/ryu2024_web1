//[1]  URL(경로상의 cno) 현재 게시판의 cno 구하기
//- URL 상의 쿼리스트링 매개변수 : new URL(location.href).searchParams

console.log(new URL(location.href).searchParams)
console.log(new URL(location.href).searchParams.get('cno'))

//[2] 지정한 카테고리별 게시물 조회 요청
const findall = () =>{
	
	//1. 현재 페이지의 카테고리 구하기
	const cno = new URL(location.href).searchParams.get('cno');
	//2. fetch option
	const option = {method : 'GET'}
	//3. fetch
	fetch(`/ryu2024_web1/board?cno=${cno}`,option)
		.then(r =>r.json())
		.then(data =>{
			console.log(data);
			
			//4. 출력할 위치의 DOM 객체 반환
			const boardlist = document.querySelector('.boardlist>tbody');
			//5. 출력할 내용을 담을 변수 반환
			let html=``;
			//6. 서블릿으로 응답받은 자료들을
			data.forEach( (board) => {
				//7. 게시물 하나씩 html 테이블의 행으로 표현하기
				html+=`				<tr>
								<td>${board.bno}</td>
								<td>${board.btitle}</td>
								<td>${board.mid}</td>
								<td>${board.bdate}</td>
								<td>${board.view}</td>
								</tr>`
				
			})//f e
			//8. 반복무누 종료 표현될 html 표현
			boardlist.innerHTML=html;
		})
		.catch(e =>{console.log(e)})
	
}//f e 
findall();
