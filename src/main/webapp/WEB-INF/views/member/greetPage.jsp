<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
		<!-- header include -->
	<jsp:include page="../header.jsp" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/member/greetPage.css">

    <section id="greetPage">
        <div id="greet-Box">
            <span style="color: #689BA6;">${requestScope.memberNm}</span>
            <span>님 환영합니다!</span>
        </div>
        <div class="float-Box">
            <img src="${contextPath}/resources/images/main/koyang3.png">
        </div>
        <div class="float-Box">
            <h1>회원가입이 완료 되었습니다.</h1>
            가까운 이웃과 안전하게 중고상품을<br>
            거래 할 수 있는 사이트<br>
            아나바다에 오신 것을 환영합니다.<br>
            지금 즉시 로그인 하여<br>
            원하시는 서비스를 이용해보세요.<br>
            <button onclick="location.href='${contextPath}/member/login'">바로 로그인</button>
        </div>
    </section>

	<jsp:include page="../sideBar.jsp" />

    <!-- footer include -->
	<jsp:include page="../footer.jsp" />