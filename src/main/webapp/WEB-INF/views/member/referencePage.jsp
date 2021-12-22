<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
		<!-- header include -->
	<jsp:include page="../header.jsp" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/member/searchPage.css">

    <section id="signUpPage">
        <div id="top-banner">아이디/비밀번호 찾기</div>
        <div id="signUpPage-info">
            <form action="${contextPath}/sendKey">
                <table>
                    <tr>
                        <th>인증번호 입력</th>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="number" name="inputKey" id="inputKey"></td>
                        <td><button id="key-Btn">확인</button></td>
                    </tr>
                    <tr>
                    	<td id="keyTime" style="color: #ccc;">05:00</td>
                    </tr>
                </table>
            </form>
        </div>
    </section>

    <!-- footer include -->
	<jsp:include page="../footer.jsp" />