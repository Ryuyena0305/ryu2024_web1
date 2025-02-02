const memberFindAll = () =>{
	let tbody = document.querySelector('tbody');
	let html='';
	
	const option = { method: 'GET' }
	fetch('/ryu2024_web1/test',option)
		.then(response => response.json())
		.then(data => {
			data.forEach(member => {
				html += `<tr>
					<td><a href="memberListDetail.jsp?mno=${member.mno}">${member.mno}</td>
					<td>${member.mname}</a></td>
					<td>${member.mphone}</td>
					<td>${member.maddress}</td>
					<td>${member.mdate}</td>
					<td>${member.mgrade}</td>
					<td>${member.mcode}</td>
					</tr>`
		});
		tbody.innerHTML = html;
	})
		.catch(error => {console.log(error);})
}
memberFindAll();