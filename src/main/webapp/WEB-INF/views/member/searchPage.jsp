<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
		<!-- header include -->
	<jsp:include page="../header.jsp" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/member/searchPage.css">

    <section id="signUpPage">
        <div id="top-banner">아이디/비밀번호 찾기</div>
        <div id="signUpPage-info">
            <form action="${contextPath}/sendEmail">
                <table>
                    <tr>
                        <th>회원가입한 이메일</th>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="email" name="inputEmail" id="inputEmail"></td>
                        <td><button id="key-Btn" disabled>인증번호 보내기</button></td>
                    </tr>
                    <tr>
                    	<td id="checkEmail" style="font-size: 16px;"></td>
                    </tr>
                </table>
            </form>
        </div>
    </section>
    
   	<script src="${contextPath}/resources/js/searchIdPw.js"></script>

    <!-- footer include -->
	<jsp:include page="../footer.jsp" />