<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


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
        <div><h3>새로운 상품 추천</h3></div>
        <div class="item" id="it-1" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-2" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-3" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-4" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-5" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-6" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-7" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-8" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-9" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-10" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-11" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-12" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-13" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-14" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-15" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-16" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="img/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-17" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-18" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-19" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>
        <div class="item" id="it-20" onclick="location.href='https://m.bunjang.co.kr/'">
            <img src="${contextPath}/resources/images/main/ku.jpg">
            <div class="item-title">특히나 더 놀란 고양이</div>
            <div class="item-content" style="font-weight: bold;">
                <span style="float: left;">12,000원</span>
                <span style="float: right;">1일 전</span>
            </div>
        </div>

        <div class="page-button">
            <div class="move-button"><p>&#8249;</p></div>
            <div>1</div>
            <div>2</div>
            <div>3</div>
            <div>4</div>
            <div class="move-button"><p>&#8250;</p></div>
        </div>
    </section>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
	
	<jsp:include page="sideBar.jsp" />
	
	<!-- footer include -->
	<jsp:include page="footer.jsp" />