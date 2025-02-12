

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<!-- 부트스트랩 케러셀 -->
	<div id="carouselExample" class="carousel slide">
		<!-- 이미지 본문들 -->
		<div class="carousel-inner">

		
			<div class="mainimg carousel-item active ">
				<img src="/ryu2024_web1/img/main1.jpg" class="d-block w-100 h-50"
					alt="...">
			</div>

			<div class="mainimg carousel-item ">
				<img src="/ryu2024_web1/img/main2.jpg" class="d-block w-100 h-50"
					alt="...">
			</div>

			<div class="mainimg carousel-item ">
				<img src="/ryu2024_web1/img/main3.jpg" class="d-block w-100 h-50"
					alt="...">
			</div>
			<div class="mainimg carousel-item">
				<img src="/ryu2024_web1/img/main4.jpg" class="d-block w-100 h-50"
					alt="...">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExample" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExample" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
</body>
</html>