<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>아나바다 - 중고거래 웹 사이트</title>
<link rel="stylesheet" href="${contextPath}/resources/css/header+footer.css">

</head>
<body>
	<div class="wrapper">
		<header>
			<!-- 맨 위부분 로그인, 로그아웃, 내 상점 -->
			<div class="header-top">
				<div class="header-login">
					<div id="login">
						<a href="#">로그인</a>
					</div>
					<div id="singup">
						<a href="#">회원가입</a>
					</div>
				</div>
			</div>

			<div class="header-bottom">
				<div class="header-main">
					<div class="header-main-top">
						<div id="logo" onclick="location.href='#'">아나바다</div>

						<div id="search">
							<input type="text" id="search_input" placeholder="검색어 입력">
							<img src="${contextPath}/resources/images/header+footer/검색.png"
								id="search-img" onclick="location.href='#'">
						</div>

						<div id="logo-right">
							<div class="sale" onclick="location.href='#'">
								<img src="${contextPath}/resources/images/header+footer/판매.png">
								<p id="sale">판매하기</p>
								<!-- &nbsp;판매하기 -->
							</div>
							<div class="shop" onclick="location.href='#'">
								<img src="${contextPath}/resources/images/header+footer/내상점.png">
								<p id="shop">내상점</p>
								<!-- &nbsp;내상점 -->
							</div>
							<div class="notice" onclick="location.href='#'">
								<img src="${contextPath}/resources/images/header+footer/알림.png">
								<p id="notice">알림</p>
								<!-- &nbsp;알림 -->
							</div>
						</div>

					</div>
					<%-- <div class="header-main-bottom">
						<div class="dropdown">
							<span><imgsrc="${contextPath}/resources/images/header+footer/카테고리.png"
								id="category"></span>
							<div class="dropdown-content">
								<ul>
									<li>여성의류</li>
									<li>남성의류</li>
									<li>신발</li>
									<li>가방</li>
									<li>시계/쥬얼리</li>
									<li>패션 액세서리</li>
									<li>디지털/가전</li>
									<li>스포츠/레저</li>
									<li">차량/오토바이
										</option>
									<li>스타굿즈</li>
									<li>키덜트</li>
									<li>예술/희귀/수집품</li>
									<li>음반/악기</li>
									<li>도서/티켓/문구</li>
									<li>뷰티/미용</li>
									<li>가구/인테리어</li>
									<li>생활/가공식품</li>
									<li>유아동/출산
										</option>
									<li>반려동물용품</li>
									<li>기타</li>
								</ul>
							</div>
						</div>
					</div> --%>

				</div>
			</div>
		</header>
