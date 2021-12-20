<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
		<!-- header include -->
	<jsp:include page="../header.jsp" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/member/resignMember.css">

    <section id="signUpPage">
        <div id="top-banner">회원 탈퇴</div>
        <div id="signUpPage-info">
            <form action="${contextPath}/member/resignMember" method="post">
                <table>
                    <tr>
                        <th>아이디</th>
                        <td>${sessionScope.loginMember.memberId}</td>
                    </tr>
                    <tr>
                        <th>비밀번호 입력</th>
                        <td><input type="password" name="memberPw"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><button id="signUp-Btn" class="btn-style" onclick="return deleteCheck();">회원 탈퇴</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </section>
    
    <script>
    	function deleteCheck(){
    		const result = window.confirm("정말로 탈퇴하시겠습니까?");
    		
    		if(result){
    			return true;
    		}else{
    			return false;
    		}
    	}
    </script>

    <!-- footer include -->
	<jsp:include page="../footer.jsp" />