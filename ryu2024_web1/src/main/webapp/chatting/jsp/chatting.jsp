<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/header.jsp"></jsp:include>
	<div>
		<div class="msgbox"></div>
		<textarea class="msginput"></textarea>
		<button onclick ="onMsgSend()" type="button" class="btn btn-primary" > 전송 </button>
	</div>

<script src="/ryu2024_web1/js/chatting/chatting.js"></script>
</body>
</html>