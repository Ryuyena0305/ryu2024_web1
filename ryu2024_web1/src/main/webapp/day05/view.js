let boardInfo = null;

const boardView = () =>{
	let bno = new URL(location.href).searchParams.get('bno');
	
	const option = {method : 'GET'}
	
	fetch (`/ryu2024_web1/day05/board/view?bno=${ bno }`,option)
	.then(response => response.json())
	.then(data =>{
		document.querySelector('.bdateBox').innerHTML = `${data.bdate}`
		document.querySelector('.bwriterBox').innerHTML = `${data.bwriter}`
		document.querySelector('.bviewBox').innerHTML = `${data.bview}`
		document.querySelector('.btitleBox').innerHTML = `${data.btitle}`
		document.querySelector('.bcontentBox').innerHTML = `${data.bcontent}`
		boardInfo = data;
	})
	.catch(error => {console.log(error)})
}
boardView();

const boardDelete = () => {
	
	let bno = new URL(location.href).searchParams.get('bno');
	let passwordCheck = prompt('게시물 비밀번호 :');
		if(boardInfo.bpw != passwordCheck){
			alert('비밀번호가 일치하지 않습니다.')
			return;
		}
	const option = {method : 'DELETE'}
	fetch(`/ryu2024_web1/day05/board?bno=${bno}`,option)
	.then(response => response.json())
			.then(data => 
				{if(data == true){alert('게시물 삭제 성공');location.href="board.jsp";}
				else{alert('게시물 삭제 실패');}
			})
	.catch(e =>{console.log(e)})
	
}

const boardUpdate = () =>{
	let passwordCheck = prompt('게시물 비밀번호 :');
	if(boardInfo.bpw != passwordCheck){
		alert('비밀번호가 일치하지 않습니다.')
		return;
	}
	location.href = `/ryu2024_web1/day05/update.jsp?bno=${boardInfo.bno}`
	
	
}