<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
		<!-- header include -->
	<jsp:include page="../header.jsp" />

    <section id="signUpPage">
        <div id="top-banner">아이디/비밀번호 찾기</div>
        <div id="signUpPage-info">
            <form action="">
                <table>
                    <tr>
                        <th>아이디</th>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <th>E-MAIL</th>
                        <td><input type="text"></td>
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