<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>아나바다 - 중고거래 웹 사이트</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="${contextPath}/resources/css/header+footer.css">

</head>
<body id="body-top">
	<div class="wrapper">
		<header>
			<!-- 맨 위부분 로그인, 로그아웃, 내 상점 -->
			<div class="header-top">
				<div class="header-login">
					<c:choose>
						<c:when test="${ empty sessionScope.loginMember }">
							<div id="login">
								<a href="${contextPath}/member/login" class="header-btn-style header-font">로그인</a>
							</div>
							<div id="singup">
								<a href="${contextPath}/member/signUp" class="header-btn-style header-font">회원가입</a>
							</div>
						</c:when>
						<c:otherwise>
							<div id="login">
								<a href="${contextPath}/member/logout" class="header-btn-style header-font">로그아웃</a>
							</div>
							<div id="singup">
								<a href="${contextPath}/member/myPage" class="header-btn-style header-font">내 정보</a>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>

			<div class="header-bottom">
				<div class="header-main">
					<div class="header-main-top">
						<div id="logo" class="header-font" onclick="location.href='${contextPath}'">아나바다</div>

						<div id="search">
							<div id="search-border">
							
								<form action="${contextPath}/categoryItem/search" method="GET">

									<input type="text" id="search_input" name="search_input" placeholder="검색어 입력">
									<button>
										<img src="${contextPath}/resources/images/header+footer/검색.png" id="search-img">
										<%-- id="search-img" onclick="location.href='${contextPath}/itemPage?cp=${loginMember.memberNo}';"> --%>
									</button>

								</form>

							</div>
						</div>

						<div id="logo-right">
							<c:choose>
								<c:when test="${ empty sessionScope.loginMember}">
									<div class="sale" onclick="location.href='${contextPath}/member/login';">
										<img src="${contextPath}/resources/images/header+footer/판매.png">
										<p id="sale" class="header-font">판매하기</p>
										<!-- &nbsp;판매하기 -->
									</div>
								</c:when>
								<c:otherwise>
									<div class="sale" onclick="location.href='${contextPath}/item/insert';">
										<img src="${contextPath}/resources/images/header+footer/판매.png">
										<p id="sale" class="header-font">판매하기</p>
										<!-- &nbsp;판매하기 -->
									</div>
								</c:otherwise>
							</c:choose>
							
							<c:choose>
								<c:when test="${ empty sessionScope.loginMember}">
									<div class="shop" onclick="location.href='${contextPath}/member/login';">
										<img src="${contextPath}/resources/images/header+footer/내상점.png">
										<p id="shop" class="header-font">내상점</p>
										<!-- &nbsp;내상점 -->
									</div>
								</c:when>
								<c:otherwise>
									<div class="shop" onclick="location.href='${contextPath}/myShop/myShop?no=${loginMember.memberNo}';">
										<img src="${contextPath}/resources/images/header+footer/내상점.png">
										<p id="shop" class="header-font">내상점</p>
										<!-- &nbsp;내상점 -->
									</div>
								</c:otherwise>
							</c:choose>
							
							<div class="notice" onclick="clickNotice()">
								<img id="notice-img" src="${contextPath}/resources/images/header+footer/알림.png">
								<p id="notice" class="header-font">알림</p>
								<div id="notice-area">
									<ul class="notice-ul">

									</ul>
								</div>
								<!-- &nbsp;알림 -->
							</div>
						</div>

					</div>
					<div class="header-main-bottom">
						<div class="dropdown">
							<span><img src="${contextPath}/resources/images/header+footer/카테고리.png"
								id="category"></span>
							<div class="dropdown-content">
								<ul id="category-ul" class="header-font">
								</ul>
							</div>
						</div>
					</div> 

				</div>
			</div>
		</header>

		<script>
			const contextPath = "${contextPath}";
			// console.log("contextPath: " , contextPath);
			// 로그인한 회원의 회원 번호, 비로그인 시 "" (빈문자열)
			const loginMemberNo = "${loginMember.memberNo}";
			
			// 현재 게시글 번호
			const itemNo = "${item.itemNo}";
			
			// 현재 게시글 작성자 번호
			var itemMemberNo = "${item.memberNo}";
	
			// 수정 전 댓글 요소를 저장할 변수 (댓글 수정 시 사용)
			let before;
	
		</script>
		<script src="${contextPath}/resources/js/header.js"></script>
