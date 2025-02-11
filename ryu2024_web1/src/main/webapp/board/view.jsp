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

	<div class="container">


		<div>
			작성자 : <span class="midbox"></span> 조회수 : <span class="viewbox"></span>
			작성일 : <span class="datebox"></span>
		</div><br /> <br />

	
			<div class="titlebox">제목이 들어갈 구역
			</div><br /> <br />
			
			<div class="contentbox">본문이 들어갈 구역</div><br /><br />

			<div>
				<textarea class="rcontentinput form-control"></textarea>
				<button  type="button" class="btn btn-primary" onclick="onReplyWrite()">댓글 게시</button>
			</div>

			<div class="replybox mt-5">

			</div>
	</div>
	<script src="/ryu2024_web1/js/board/view.js" type="text/javascript"></script>
</body>
</html>