<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- header include -->
	<jsp:include page="header.jsp" />
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/mainPage.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	
    <section id="carousel">
        <!-- Bootstrap Carousel-->
        <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
            <div class="carousel-inner">
              <div class="carousel-item active" data-bs-interval="5000" onclick="location.href='https://m.bunjang.co.kr/'">
                <img src="${contextPath}/resources/images/main/ku2.jpg" class="d-block w-100" alt="...">
              </div>
              <div class="carousel-item" data-bs-interval="5000" onclick="location.href='https://www.naver.com/'">
                <img src="${contextPath}/resources/images/main/ku3.jpg" class="d-block w-100" alt="...">
              </div>
              <div class="carousel-item" data-bs-interval="5000" onclick="location.href='https://www.youtube.com/'">
                <img src="${contextPath}/resources/images/main/ku4.jpg" class="d-block w-100" alt="...">
              </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
    </section>

    <section id="middle-banner">
        <div><img src="${contextPath}/resources/images/main/mo.jpg" alt=""></div>
    </section>

    <section id="item-box">
        <div><h3>새로 등록된 상품 </h3></div>
        
        <%-- 글 생성 --%>
        <c:choose>
        	<c:when test="${empty itemList}">
        	
        	</c:when>
        	<c:otherwise>
        		<c:forEach items="${itemList}" var="item">
   			        <div class="item" id="${item.itemNo}" onclick="location.href='${contextPath}/detail/select?no=${item.itemNo}&cp=${pagination.currentPage}'">
						<img src="${contextPath}${item.imgList[0].imgPath}${item.imgList[0].imgName}">
			            <div class="item-title">${item.itemName}</div>
			            <div class="item-content" style="font-weight: bold;">
			                <span style="float: left;">${item.itemPrice}원</span>
			                <span style="float: right;">${item.date}</span>
			            </div>
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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
	
	<jsp:include page="sideBar.jsp" />
	
	<!-- footer include -->
	<jsp:include page="footer.jsp" />