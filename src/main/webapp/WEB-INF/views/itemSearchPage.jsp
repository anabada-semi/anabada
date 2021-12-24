<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
		<!-- header include -->
	<jsp:include page="header.jsp" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/itemSearchPage.css">
	
    <section>

    </section>

    <section id="item-box">
        
		
        <div><h3><span style="color:#668053;">${searchInput} </span>검색한 결과</h3></div>
		
		<div></div>

        <%-- 글 생성 --%>
        <c:choose>
        	<c:when test="${empty itemList}">
        	
        	</c:when>
        	<c:otherwise>
        		<c:forEach items="${itemList}" var="item">
        			<c:set var="addr" value="${fn:split(item.address, ',,')}"/>
        			
   			        <div class="item" id="${item.itemNo}" onclick="location.href='${contextPath}/detail/select?no=${item.itemNo}&cp=${pagination.currentPage}'">
			            <img src="${contextPath}${item.imgList[0].imgPath}${item.imgList[0].imgName}">
			            <div class="item-title">${item.itemName}</div>
			            <div class="item-content" style="font-weight: bold;">
			                <span style="float: left;">${item.itemPrice}원</span>
			                <span style="float: right;">${item.date}</span>
			            </div>
			            <div class="item-address"><p>&#127968; ${addr[1]}</p></div>
			        </div>
        		</c:forEach>
        	</c:otherwise>
        </c:choose>
        
        <div class="page-button">
        	<div class="page-box">
	            <div class="move-button page-div" onclick="location.href='search?cp=${pagination.prevPage}'">&lt;</div>
	            <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" step="1" var="i">
					<c:choose>
						<c:when test="${i == pagination.currentPage}">
							<div class="current-div" style="background-color: #ccc;">${i}</div>								
						</c:when>
						<c:otherwise>
							<div class="page-div" onclick="location.href='search?cp=${i}'">${i}</div>
						</c:otherwise>
					</c:choose>
	            </c:forEach>
	            <div class="move-button page-div" onclick="location.href='search?cp=${pagination.nextPage}'">&gt;</div>
        	</div>
        </div>

    </section>

    
    <jsp:include page="sideBar.jsp" />
    
    <!-- footer include -->
	<jsp:include page="footer.jsp" />