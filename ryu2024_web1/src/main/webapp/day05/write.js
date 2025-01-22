const boardWrite = ()=>{
	let writerInput = document.querySelector('.writerInput');
	let pwInput = document.querySelector('.pwInput');
	let titleInput = document.querySelector('.titleInput');
	let contentInput = document.querySelector('.contentInput');
	
	let bwriter = writerInput.value;
	let bpw = pwInput.value;
	let btitle = titleInput.value;
	let bcontent = contentInput.value;
	
	let dataObj = {
		bwriter : bwriter , bpw : bpw,btitle:btitle,bcontent:bcontent}

	
	const option = {
		method : 'POST',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	fetch('/ryu2024_web1/day05/board',option)
	.then(response => response.json())
	.then(data =>{
		if(data ==true){alert('글쓰기성공'); location.href='/board.jsp';}
		else{alert('글쓰기 실패');}
	})
	.catch(error=>{alert('시스템오류 : 관리자에게 문의')})
	}