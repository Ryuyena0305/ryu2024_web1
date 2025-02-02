const SalesFindAll = () =>{
	let tbody = document.querySelector('tbody');
	let html='';
	
	const option = { method: 'GET' }
	fetch('/ryu2024_web1/test2',option)
		.then(response => response.json())
		.then(data => {
			data.forEach(member => {
				html += `<tr>
					<td>${member.mno}</td>
					<td>${member.mname}</a></td>
					<td>${member.mgrade}</td>
					<td>${member.m}
					</tr>`
		});
		tbody.innerHTML = html;
	})
		.catch(error => {console.log(error);})
}
memberFindAll();