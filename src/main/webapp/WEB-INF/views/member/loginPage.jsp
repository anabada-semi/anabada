<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
		<!-- header include -->
	<jsp:include page="../header.jsp" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/member/loginPage.css">


    <section id="login-section">
        <div id="login-area">
            <form action="${contextPath}/member/login" method="POST">
                <div id="login-area2">
                    <input type="text" id="id" placeholder="아이디(ID)" required> <br>
                    <input type="password" id="pw" required> <br>
                    <a href="#" id="searchId">아이디</a>|<a href="#" id="searchPw">비밀번호 찾기</a>
                </div>
                <div id="login-area3">
                    <button id="login">로그인</button> <br>
                    <button id="signUp">회원가입</button>
                </div>
            </form>
        </div>
    </section>
    
    <!-- footer include -->
	<jsp:include page="../footer.jsp" />