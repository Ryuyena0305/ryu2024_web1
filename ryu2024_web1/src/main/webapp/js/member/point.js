const getMyPoint = () => {
	const option = { method: 'GET' }//get

	let pointmenu = document.querySelector('tbody');
	let html = '';


	fetch('/ryu2024_web1/member/info', option)
		.then(r => r.json())
		.then(data => {
			data.forEach(point => {
				html += `<tr>
					<th scope="row" class="pno">${point.pno}</th>
					<td class="pcontent">${point.pcontent}</td>
					<td class="pcount">${point.pcount}</td>
					<td class="pdate">${point.pdate}</td>
					</tr>`

			});
			pointmenu.innerHTML = html;
		})
		.catch(e => { console.log(e); })
}// f end 

getMyPoint();

