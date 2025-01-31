<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<style>
* {
	margin: 0;
	padding: 0;
}

a, li, ul {
	text-decoration: none;
	list-style-type: none;
	color: white;
}

.totalName {
	background-color: #3156d2;
	text-align: center;
	display: flex;
	justify-content: center;
	align-items: center;
	color: white;
	height: 70px;
	color: white
}

.listItem {
	display: flex;
	justify-content: center;
	gap: 20px;
	height: 40px;
	justify-content: center;
	align-items: center;
}

#list {
	background-color: #8c8ce6;
}

.main {
	background-color: #e4e4e4;
	height: 300px;
	padding: 300px;
	padding-top : 100px;
	justify-content: center;
	align-items: center;
}

footer {
	background-color: #356cc1;
	color: white;
	text-align: center;
	height: 50px;
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>
	<header>
		<div class="totalName">쇼핑몰 회원관리 ver1.0</div>

		<div id="list">
			<ul class="listItem">
				<li><a href="">회원등록</a></li>
				<li><a href="/ryu2024_web1/test/memberListDetail.jsp">회원목록조회/수정</a></li>
				<li><a href="">회원매출조회</a></li>
				<li><a href="/ryu2024_web1/test/main.jsp"">홈으로</a></li>
			</ul>
		</div>
	</header>
	<div class="main">
		<h3>쇼핑몰 회원관리 프로그램</h3>
		<div>
			쇼핑몰 회원정보와 회원매출정보 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다.<br> 프로그램
			작성 순서<br> 1.회원정보 테이블을 생성한다<br> 2.매출정보<br>3.매출정보<br>4.매출정보<br>
		</div>
	</div>




	<footer> HRDKOREA Copyright2016 All rights reserved. Human
		Resources Development Service of Korea </footer>


	<script src="main.js"></script>
</body>
</html>