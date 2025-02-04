//[1] 로그인 정보 요청 함수
const getLoginInfo = () => {

	const option = { method: 'GET' }//get

	let loginmenu = document.querySelector('.loginmenu');
	let html = '';


	fetch('/ryu2024_web1/member/info', option)
		.then(r => r.json())
		.then(data => {
			if (data == null) {
				console.log('비로그인상태');
				html = `	<li class="nav-item"> <a class="nav-link" href="/ryu2024_web1/member/login.jsp">로그인</a> </li>
			        <li class="nav-item"> <a class="nav-link" href="/ryu2024_web1/member/signup.jsp">회원가입</a> </li>`
			} else {
				console.log('로그인상태');
				html += `
				<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
				<img class="header_profile" src="/ryu2024_web1/upload/${ data.mimg }" /> ${ data.mid } 님 </a>
				<ul class="dropdown-menu">
				<li class="nav-item"> <a class="nav-link" href="/ryu2024_web1/member/point.jsp">포인트 조회</a> </li>
					<li class="nav-item"> <a class="nav-link" href="/ryu2024_web1/member/info.jsp">마이페이지</a> </li>
					<li class="nav-item"> <a class="nav-link" href="#" onclick="onLogOut()">로그아웃</a></li>
					</ul>
				</li>`
			}
			loginmenu.innerHTML = html;
		})
		.catch(e => { console.log(e); })
}
getLoginInfo();

const onLogOut = () => {
	const option = { method: 'DELETE' }
	fetch('/ryu2024/member/login', option)
		.then(r => r.json())
		.then(data => {
			if (data == true) {
				alert('로그아웃합니다.');
				location.href = "/ryu2024_web1/member/login.jsp";
			}
		})
		.catch(e => { console.log(e); })
}