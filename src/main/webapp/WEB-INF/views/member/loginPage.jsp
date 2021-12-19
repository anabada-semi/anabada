<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
		<!-- header include -->
	<jsp:include page="../header.jsp" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/member/loginPage.css">


    <section id="login-section">
        <div id="login-area">
            <form action="${contextPath}/member/login" method="POST">
                <div id="login-area2">
                    <input type="text" name="memberId" id="memberId" placeholder="아이디(ID)" required> <br>
                    <input type="password" name="memberPw" id="memberPw" required> <br>
                    <a href="${contextPath}/member/searchIdPw" id="search-IdPw">아이디|비밀번호 찾기</a>
                </div>
                <div class="login-area3">
                    <button type="submit" id="login">로그인</button> <br>
                </div>
            </form>
                <div class="login-area3">
	                <button onclick="location.href='${contextPath}/member/signUp'">회원가입</button>            
                </div>
        </div>
    </section>

    <!-- footer include -->
	<jsp:include page="../footer.jsp" />