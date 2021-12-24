<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
		<!-- header include -->
	<jsp:include page="../header.jsp" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/member/updatePwPage.css">

    <section id="updatePwPage">
        <div id="top-banner">아이디/비밀번호 찾기</div>
        <div id="updatePw-info">
            <div class="wrap">
                <img src="${contextPath}/resources/images/main/koyang2.png" class="koyang">
            </div>
            <form action="${contextPath}/member/updatePw" method="post" onsubmit="return validate();">
                <table>
                    <tr>
                        <td colspan="3" id="success-text">회원 찾기 성공! 비밀번호 변경 후 이용가능합니다.</td>
                    </tr>
                    <tr>
                        <th>회원 ID</th>
                        <td>${sessionScope.searchMember.memberId}</td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td>${sessionScope.searchMember.memberNm}</td>
                    </tr>
                    <tr>
                        <th>변경할 비밀번호</th>
                        <td><input name="memberPw" id="pwd1" type="password" required></td>
                        <td id="checkPw1"></td>
                    </tr>
                    <tr>
                        <th>변경할 비밀번호 확인</th>
                        <td><input name="memberPw" id="pwd2" type="password" required></td>
                        <td id="checkPw2"></td>
                    </tr>
                    <tr>
                        <td colspan="3"><button id="updatePw-Btn" class="btn-style">변경</button></td>
                    </tr>
                </table>
            </form>
            

        </div>
    </section>

	<script src="${contextPath}/resources/js/updatePw.js"></script>

	<jsp:include page="../sideBar.jsp" />

    <!-- footer include -->
	<jsp:include page="../footer.jsp" />