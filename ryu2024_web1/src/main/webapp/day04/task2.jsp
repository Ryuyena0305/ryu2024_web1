<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>DAY03 WATING2 화면 구현</h3>
	<div>
		<h6>대기명단 작성</h6>
		핸드폰번호 : <input class="phoneNumInput" /><br /> 인원수 : <input class="pNumInput" /><br />
		<button onclick="waitingWrite()" type="button">등록</button>
	</div>
	<div>
		<table border="1">
			<thead>
				<tr>
				<th>num</th> <th>phoneNum</th><th>pNum</th><th>etc</th>
				</tr>
			</thead>
			<tbody>
			
			</tbody>
			
		</table>
	</div>

	<script src="task2.js"></script>
</body>
</html>