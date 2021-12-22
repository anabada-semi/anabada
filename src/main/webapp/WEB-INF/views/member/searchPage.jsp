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
                        <th>가입한 이메일</th>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="email" name="inputEmail" id="inputEmail"></td>
                    </tr>
                    <tr>
                        <td><input type="text"></td>
                        <td><button id="key-Btn" onclick="confirm();">인증번호 받기</button></td>
                    </tr>
                    <tr>
                    	<td id="keyTime" style="color: #ccc;"></td>
                        <td><button id="searchUp-Btn">확인</button></td>
                    </tr>
                </table>
            </form>
            

        </div>
    </section>
    
    <script>
    	function confirm(){
    		document.getElementById("keyTime").innerText = "05:00";
    	}
    </script>

    <!-- footer include -->
	<jsp:include page="../footer.jsp" />