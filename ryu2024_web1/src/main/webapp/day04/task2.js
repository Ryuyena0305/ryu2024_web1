const waitingWrite = () => {
	let phoneNumInput = document.querySelector('.phoneNumInput');
	let pNumInput = document.querySelector('.pNumInput');
	let phoneNum = phoneNumInput.value;
	let pNum = pNumInput.value;

	let dataObj = { 'phoneNum': phoneNum, 'pNum': pNum };

	let option = {
		method: 'POST',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify(dataObj)
	}
	fetch('/ryu2024_web1/day03/waiting2', option)
		.then(r => r.json())
		.then(data => {
			if (data == true) { alert('등록성공'); waitingFindAll(); }
			else { alert('등록 실패'); }
		})
		.catch(e => { console.log(e) })
}

const waitingFindAll = () => {
	let tbody = document.querySelector('tbody')
	let html = ''

	const option = { method: 'GET' }
	fetch('/ryu2024_web1/day03/waiting2')
		.then(r => r.json())
		.then(data => {
			data.forEach(obj => {
				html += `<tr>
						<td>${obj.num}</td>
						<td>${obj.phoneNum}</td>
						<td>${obj.pNum}</td>
						<td>
						<button onclick="waitingUpdate( ${obj.num} )">수정</button>
						<button onclick="waitingDelete( ${obj.num} )">삭제</button>
						</td>
						</tr>`
			})
			tbody.innerHTML = html;
		})
		.catch(e=>{console.log(e);})	
}
waitingFindAll();

const waitingUpdate = (num)=>{
	let newphoneNum = prompt('new phoneNum');
	let newpNum = prompt('new peopleNum');
	let dataObj = {num:num,phoneNum : newphoneNum,pNum:newpNum}
	
	const option = {
		method : 'PUT',
		headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}
	fetch('/ryu2024_web1/day03/waiting2',option)
	.then(r=>r.json())
	.then(data =>{
		if(data==true){alert('수정성공');waitingFindAll();}
		else{alert('수정실패');}
	})
	.catch(e=>{console.log(e);})	
}

const waitingDelete = (num)=>{
	const option = {method: 'DELETE'}
	fetch(`/ryu2024_web1/day03/waiting2?num=${num}`,option)
	.then(r =>r.json())
	.then(data=>{
		if(data==true){
			alert('삭제성공');waitingFindAll();}
			else{alert('성공실패');}
	})
	.catch(e=>{console.log(e)})
}