<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
		<!-- header include -->
	<jsp:include page="header.jsp" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/errorPage.css">
    
    <section id="errorPage">
        <div>
            <img src="${contextPath}/resources/images/main/koyang1.png">
        </div>
        <div>
            <h1>앗! 사이트에 문제가 발생했습니다!</h1>
            <h2>잠시 후에 다시 시도해주세요!</h2>
            <div id="error-Message">
                <span>Error : </span>
                <span style="color: crimson">${requestScope.errorMessage}</span>
            </div>
            <button onclick="history.back()">이전화면으로</button>
        </div>
    </section>


    <!-- footer include -->
	<jsp:include page="footer.jsp" />