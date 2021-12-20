<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
		<!-- header include -->
	<jsp:include page="../header.jsp" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/member/searchPage.css">

    <section id="signUpPage">
        <div id="top-banner">아이디/비밀번호 찾기</div>
        <div id="signUpPage-info">
            <form action="${contextPath}/member/emailSend" method="get">
                <table>
                    <tr>
                        <th>가입한 이메일</th>
                    </tr>
                    <tr>
                        <td><input type="email" name="email" id="email"></td>
                    </tr>
                    <tr>
                        <td><input type="text"></td>
                        <button>인증번호 받기</button>
                    </tr>
                    <tr>
                        <td colspan="2"><button id="signUp-Btn" class="btn-style">아이디/비밀번호 찾기</button></td>
                    </tr>
                </table>
            </form>
            

        </div>
    </section>

    <!-- footer include -->
	<jsp:include page="../footer.jsp" />