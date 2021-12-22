<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
		<!-- header include -->
	<jsp:include page="../header.jsp" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/member/updatePwPage.css">

    <section id="updatePwPage">
        <div id="top-banner">회원 가입</div>
        <div id="updatePw-info">
            <div class="wrap">
                <img src="${contextPath}/resources/images/main/koyang2.png" class="koyang">
            </div>
            <form action="">
                <table>
                    <tr>
                        <td colspan="3" id="success-text">회원 찾기 성공! 비밀번호 변경 후 이용가능합니다.</td>
                    </tr>
                    <tr>
                        <th>회원 ID</th>
                        <td>와자뵤</td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td>김치왕</td>
                    </tr>
                    <tr>
                        <th>변경할 비밀번호</th>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <th>변경할 비밀번호 확인</th>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td colspan="3"><button id="updatePw-Btn" class="btn-style">변경</button></td>
                    </tr>
                </table>
            </form>
            

        </div>
    </section>

    <!-- footer include -->
	<jsp:include page="../footer.jsp" />