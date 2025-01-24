const parkingFindAll = () =>{
	let tbody = document.querySelector('tbody');
	let html ='';
	
	const option = {method :'GET'}
	fetch('/ryu2024_web1/day06/parking/admin',option)
		.then(response => response.json())
		.then(data => {
			data.forEach(parking =>{
			html += `<tr>
						<td>${parking.cno}</td>
						<td>${parking.carNum}</td>
						<td>${parking.carLo}</td>
						<td>${parking.inCar}</td>
						<td>${parking.outCar}</td>
						<td>${parking.state}</td>
						<td><button onclick ="parkingDelete(${parking.cno})">삭제</button></td>
					</tr>`
		});
		tbody.innerHTML = html;
	})
	.catch(error => {console.log(error);})
}
parkingFindAll();



const parkingDelete=(cno)=>{
	if(confirm(`${parking.carNum} 차량 목록을 삭제하시겠습니까?`)){
		alert("정상적으로 삭제되었습니다.")
	}
	else{
		return;
	}
	const option = {method :'DELETE'}
	fetch(`/ryu2024_web1/day06/parking?cno=${cno}`,option)
	.then(response => response.json())
				.then(data => 
					{if(data == true){alert('게시물 삭제 성공');}
					else{alert('게시물 삭제 실패');}
				})
		.catch(e =>{console.log(e)})
	
}
