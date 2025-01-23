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
		<h3>게시물 개별 수정 : 새로운 내용하고 수정 버튼을 클릭하세요.</h3>
		제목 : <input class ="titleUpdateInput"/> <br/>
		내용 : <textarea class = "contentUpdateInput" rows ="10" cols ="60"></textarea>
		<button onclick ="boardUpdate()">수정 </button>
	</div>
	<script src ="update.js"></script>
	<jsp:include page="/day05/footer.jsp" />


</body>
</html>