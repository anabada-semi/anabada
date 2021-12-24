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
            나는 고양이 고고 고양이 이이이<br>
            너도 고양이 규규 규양이 이이이<br>
            우리 모두 고 양 이  이 이   이<br>
            고고고 양이 규규규 양이<br>
            고고고 양이 규규규 양이<br>
            <button onclick="location.href='${contextPath}/member/login'">바로 로그인</button>
        </div>
    </section>

	<jsp:include page="../sideBar.jsp" />

    <!-- footer include -->
	<jsp:include page="../footer.jsp" />