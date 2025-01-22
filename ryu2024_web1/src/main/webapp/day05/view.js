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
		})
	.catch(error => {console.log(error)})
}
boardView();