<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
		<!-- header include -->
	<jsp:include page="../header.jsp" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/member/myPage.css">

    <section id="myPage">
    
		<c:set var="addr" value="${fn:split(loginMember.memberAddress, ',,')}"/>
		<c:set var="ph" value="${fn:split(loginMember.memberPhone, '-')}"/>
    
        <div id="top-banner">내 정보 조회</div>
        <div id="myPage-info">
            <table>
                <tr>
                    <th>아이디</th>
                    <td>${sessionScope.loginMember.memberId}</td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td>${sessionScope.loginMember.memberNm}</td>
                </tr>
                <tr>
                    <th>E-MAIL</th>
                    <td>${sessionScope.loginMember.memberEmail}</td>
                </tr>
                <tr>
                    <th>전화번호</th>
                    <td>${sessionScope.loginMember.memberPhone}</td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td>${addr[0]} ${addr[1]}${addr[2]}${addr[3]}</td>
                </tr>
            </table>
            <button class="btn-style" onclick="location.href='${contextPath}/member/myInfoModify'">내 정보 수정하기</button>
            <button class="btn-style" onclick="location.href='${contextPath}/member/resignMember'">회원 탈퇴</button>

        </div>
    </section>
    
    <!-- footer include -->
	<jsp:include page="../footer.jsp" />