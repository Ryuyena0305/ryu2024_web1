const memberView = () =>{
	let mno = new URL(location.href).searchParams.get('mno');
	
	const option = {method : 'GET'}
	
	fetch(`/ryu2024_web1/test2?mno=${ mno }`,option)
	.then(response => response.json())
	.then(data =>{
		
		document.querySelector('.updateMno').value = `${data.mno}`
		document.querySelector('.updateMname').value = `${data.mname}`
		document.querySelector('.updateMphone').value = `${data.mphone}`
		document.querySelector('.updateMaddress').value = `${data.maddress}`
		document.querySelector('.updateMdate').value = `${data.mdate}`
		document.querySelector('.updateMgrade').value = `${data.mgrade}`
		document.querySelector('.updateMcode').value = `${data.mcode}`
		
		})
	.catch(error => {console.log(error)})
}
memberView();


const memberUpdate = () =>{
	let mno = new URL(location.href).searchParams.get('mno')
		
	let mnoUpdateInput = document.querySelector('.updateMno').value
	let mnameUpdateInput=document.querySelector('.updateMname').value 
	let mphoneUpdateInput=document.querySelector('.updateMphone').value 
	let maddressUpdateInput=document.querySelector('.updateMaddress').value
	let mdateUpdateInput=document.querySelector('.updateMdate').value 
	let mgradeUpdateInput=document.querySelector('.updateMgrade').value 
	let mcodeUpdateInput=document.querySelector('.updateMcode').value 
		
		
		let dataObj = {
		        mno:  mnoUpdateInput,
		        mname: mnameUpdateInput,
		        mphone: mphoneUpdateInput,
		        maddress: maddressUpdateInput,
		        mdate: mdateUpdateInput,
		        mgrade: mgradeUpdateInput,
		        mcode: mcodeUpdateInput
		    };

	
		const option = {
			method : 'PUT',
			headers : {'Content-Type' : 'application/json'},
			body : JSON.stringify(dataObj)
		}
		fetch(`/ryu2024_web1/test`, option)
			.then(r => r.json())
			.then(data => {
				if(data == true){
					alert('회원정보수정이 완료 되었습니다!');
					location.href=`/ryu2024_web1/test/memberListDetail.jsp?mno=${ mno }`;
				}else{
				} 
			}) 
			.catch(error => {console.log(error)})
}