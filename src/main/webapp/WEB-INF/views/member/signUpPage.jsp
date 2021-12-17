<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
		<!-- header include -->
	<jsp:include page="../header.jsp" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/member/signUpPage.css">

    <section id="signUpPage">
        <div id="top-banner">회원 가입</div>
        <div id="signUpPage-info">
            <form action="${contextPath}/member/signUp" method="POST">
                <table>
                    <tr>
                        <th>아이디</th>
                        <td><input type="text" name="memberId" id="memberId" required></td>
                        <td><button class="dup-Btn btn-style">중복 확인</button></td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td><input type="text" name="memberNm" id="memberNm" required></td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td><input type="password" name="memberPw" id="memberPw" required></td>
                    </tr>
                    <tr>
                        <th>비밀번호 확인</th>
                        <td><input type="password"></td>
                    </tr>
                    <tr>
                        <th>E-MAIL</th>
                        <td><input type="text" name="memberEmail" id="memberEmail" required></td>
                        <td><button class="dup-Btn btn-style">중복 확인</button></td>
                    </tr>
                    <tr>
                        <th>전화번호</th>
                        <td><input type="text" name="memberPhone" id="memberPhone" required></td>
                    </tr>
                    <tr>
                        <td colspan="3"><button type="submit" id="signUp-Btn" class="btn-style">회원 가입</button></td>
                    </tr>
                </table>
            </form>
            

        </div>
    </section>

    <!-- footer include -->
	<jsp:include page="../footer.jsp" />