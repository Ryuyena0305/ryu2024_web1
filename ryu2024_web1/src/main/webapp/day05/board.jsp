<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/day05/header.jsp" />
	<div>
		<h3>게시판 : 커뮤니티를 제공합니다.</h3>
		<a href ="/ryu2024_web1/day05/write.jsp">글쓰기</a>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th><th>제목</th><th>작성일</th><th>작성자</th><th>조회수</th>
				</tr>
			</thead>
			<tbody>
			<tr>
				<td>1</td><td><a href="view.jsp?bno=1">안녕하세요</a></td><td>2025-01-22 11:05:09</td><td>정준재</td><td>1</td>
			</tr>
			<tr>
				<td>2</td><td><a href="view.jsp?bno=2">안녕하세요2</a></td><td>2025-01-22 11:05:10</td><td>오원석</td><td>3</td>
			</tr>
			</tbody>
		</table>
		
	</div>
	


</body>
</html>