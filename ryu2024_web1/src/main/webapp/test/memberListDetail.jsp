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
	padding-top: 100px;
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

h3 {
	display: flex;
	justify-content: center;
	align-items: center;
}

table {

	margin: 20px auto;
	border-collapse: collapse;
}

th, td {
	text-align: center;
	border: 1px solid #000;
}

.updateBtn, .deleteBtn {
	padding: 8px 16px;
	cursor: pointer;
}

input[type="text"] {
	width: 300px; 
	padding : 1px;
}

</style>
</head>
<body>
	<header>
		<div class="totalName">쇼핑몰 회원관리 ver1.0</div>

		<div id="list">
			<ul class="listItem">
				<li><a href="/ryu2024_web1/test/memberListSignUP.jsp">회원등록</a></li>
				<li><a href="/ryu2024_web1/test/memberList.jsp">회원목록조회/수정</a></li>
				<li><a href="/ryu2024_web1/test/memberSaleQuery.jsp">회원매출조회</a></li>
				<li><a href="/ryu2024_web1/test/main.jsp">홈으로</a></li>
			</ul>
		</div>
	</header>
	<div class="main">
		<h3>홈쇼핑 회원정보 수정</h3>
		<table>
			<tr><th>회원번호(자동발생)</th><th><input type="text" readonly/></th></tr>
			<tr><th>회원성명</th><th><input type="text"/></th></tr>
			<tr><th>회원전화</th><th><input type="text"/></th></tr>
			<tr><th>회원주소</th><th><input type="text"/></th></tr>
			<tr><th>가입일자</th><th><input type="text"/></th></tr>
			<tr><th>고객등급[A:VIP B:일반 C:직원]</th><th><input type="text"/></th></tr>
			<tr><th>도서코드</th><th><input type="text"/></th></tr>
			<tr>
				<th><input class="updateBtn" type="button" value="수정" onclick=""></th>
				<th><input class="deleteBtn" type="button" value="삭제" onclick=""></th>
			</tr>
		</table>
	</div>

	<footer> HRDKOREA Copyright2016 All rights reserved. Human
		Resources Development Service of Korea </footer>

	<script src="memberListDetail.js"></script>
</body>
</html>
