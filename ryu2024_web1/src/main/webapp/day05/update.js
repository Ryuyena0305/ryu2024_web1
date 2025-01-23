const boardView = () =>{
	let bno = new URL(location.href).searchParams.get('bno');
	
	const option = {method : 'GET'}
	
	fetch(`/ryu2024_web1/day05/board/view?bno=${ bno }`,option)
	.then(response => response.json())
	.then(data =>{
		
		document.querySelector('.titleUpdateInput').value = `${data.btitle}`
		document.querySelector('.contentUpdateInput').value = `${data.bcontent}`
		})
	.catch(error => {console.log(error)})
}
boardView();

//[수정 처리]
const boardUpdate = () =>{
	let bno = new URL(location.href).searchParams.get('bno')
		
	
		let titleUpdateInput = document.querySelector('.titleUpdateInput').value
		let contentUpdateInput = document.querySelector('.contentUpdateInput').value
		
		let dataObj = {
			bno : bno,
			btitle : titleUpdateInput,
			bcontent : contentUpdateInput
		}
	
		const option = {
			method : 'PUT',
			headers : {'Content-Type' : 'application/json'},
			body : JSON.stringify(dataObj)
		}
		fetch(`/ryu2024_web1/day05/board`, option)
			.then(r => r.json())
			.then(data => {
				if(data == true){
					alert('게시물 수정 성공');
					location.href=`/ryu2024_web1/day05/view.jsp?bno=${ bno }`;
				}else{
					alert('게시물 수정 실패');
				} 
			}) 
			.catch(error => {console.log(error)})
}