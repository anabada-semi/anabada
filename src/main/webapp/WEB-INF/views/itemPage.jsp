<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
		<!-- header include -->
	<jsp:include page="header.jsp" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/itemPage.css">
	
    <section>

    </section>

    <section id="item-box">
        <div id="select-it">	
            &#8962; 홈 > <%-- 카테고리의 변경이 감지되면 숨겨진 버튼을 눌러 폼태그로 전송하는 방식으로 설계 할 예정 --%>
            <form action="${contextPath}/categoryPage" id="category-form">
	            <select name="category-tag" id="category-tag">
	                <option value ="100">여성의류</option>
	                <option value ="101">남성의류</option>
	                <option value ="102">신발</option>
	                <option value ="103">가방</option>
	                <option value ="104">시계/쥬얼리</option>
	                <option value ="105">디지털/가전</option>
	                <option value ="106">스포츠/레저</option>
	                <option value ="107">차량/오토바이</option>
	                <option value ="108">스타굿즈</option>
	                <option value ="109">키덜트</option>
	                <option value ="110">예술/희귀/수집품</option>
	                <option value ="111">음반/악기</option>
	                <option value ="112">도서/티켓/문구</option>
	                <option value ="113">뷰티/미용</option>
	                <option value ="114">가구/인테리어</option>
	                <option value ="115">생활/가공식품</option>
	                <option value ="116">유아동/출산</option>
	                <option value ="117">반려동물용품</option>
	                <option value ="118">기타</option>
	            </select>
            	<button style="visibility: hidden;">카테고리 값 전송</button>
            </form>
        </div>

        <div><h3><span style="color:#B8CC7A">패션의류</span> 상품 추천</h3></div>
        <div class="item" id="ct-it-1" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="img/ku6.jpg">
            <div class="item-title">사지마!!!!</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">9,990원</span>
                <span style="float: right;">12분 전</span>
            </div>
            <div class="item-address"><p>&#127968; 경기도 안양시 안양 1동</p></div>
        </div>

        <%-- 글 생성 --%>
        <c:choose>
        	<c:when test="${empty itemList}">
        	
        	</c:when>
        	<c:otherwise>
        		<c:forEach items="${itemList}" var="item">
   			        <div class="item" id="it-1" onclick="location.href='${contextPath}/detail/select?no=${item.itemNo}&cp=${pagination.currentPage}'">
			            <img src="${contextPath}${item.imgList[0].imgPath}${item.imgList[0].imgName}">
			            <div class="item-title">${item.itemName}</div>
			            <div class="item-content" style="font-weight: bold;">
			                <span style="float: left;">${item.itemPrice}원</span>
			                <span style="float: right;">${item.date}</span>
			            </div>
			            <div class="item-address"><p>&#127968; ${item.address}</p></div>
			        </div>
        		</c:forEach>
        	</c:otherwise>
        </c:choose>
        
        <div class="page-button">
        	<div class="page-box">
	            <div class="move-button page-div" onclick="location.href='mainItem?cp=${pagination.prevPage}'">&lt;</div>
	            <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" step="1" var="i">
					<c:choose>
						<c:when test="${i == pagination.currentPage}">
							<div class="current-div" style="background-color: #ccc;">${i}</div>								
						</c:when>
						<c:otherwise>
							<div class="page-div" onclick="location.href='mainItem?cp=${i}'">${i}</div>
						</c:otherwise>
					</c:choose>
	            </c:forEach>
	            <div class="move-button page-div" onclick="location.href='mainItem?cp=${pagination.nextPage}'">&gt;</div>
        	</div>
        </div>

    </section>
    
    <jsp:include page="sideBar.jsp" />
    
    <!-- footer include -->
	<jsp:include page="footer.jsp" />