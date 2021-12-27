<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<link rel="stylesheet" href="${contextPath}/resources/css/salePage.css">
		<!-- header include -->
	<jsp:include page="header.jsp" />
	
<main>
<div id="title"><h3>상품등록</h3></div>
    <form action="insert" method="post" 
          enctype="multipart/form-data" role="form" onsubmit="return saleValidate();">
        <section>
            <h2>기본정보</h2>
        
            <ul>
                <li class="line">
                    <div class="content_title">상품이미지<br><small>(최대 3개)</small></div>
                    <div class="content_photo">
                        <div class="itemImg" id="boxes1"><img id="imgbox1">클릭하여<br> 이미지<br>업로드
                            <button type="button" class="deleteBtn" id="delete0" disabled>x</button>
                        </div>

                        <div class="itemImg" id="boxes2"><img id="imgbox2">클릭하여<br> 이미지<br>업로드
                            <button type="button" class="deleteBtn" id="delete1" disabled>x</button>
                        </div>

                        <div class="itemImg" id="boxes3"><img id="imgbox3">클릭하여<br> 이미지<br>업로드
                            <button type="button" class="deleteBtn" id="delete2" disabled>x</button>
                        </div>
                        
                        
                        <div id=fileArea">
                        <input type="file" name="img0" onchange="loadImg(this,0)">
                        <input type="file" name="img1" onchange="loadImg(this,1)">
                        <input type="file" name="img2" onchange="loadImg(this,2)">
                        </div>
                       
                        <div id="guide">
                            - <span>이미지는 최소 1장 등록</span>해야하며 최대 3장까지 등록 가능합니다.
                            <br>
                            - 큰 이미지일경우 이미지가 깨지는 경우가 발생할 수 있습니다.
                        </div>
                    </div>
                </li>
                <li class="line">
                <div class="content_title">제목 <br><small>최대 40글자</small></div> 
                <div>
                    <input class ="input_title" type="text" name="itemName" placeholder="상품 제목을 입력해주세요">
                </div>
                <div id="title_counter">
                    <p><span id = "title_count">0</span>/40</p>
                </div>
                
                </li>
                <li class="line"> <div class="content_title">카테고리</div> 
                    <div>
                        <select id="categoryCode" name="categoryCode" size=8 style="width: 250px;">
                            
                           <c:forEach items="${category}" var="c">
                           
                            <c:choose>
	                            <c:when test="${c.categoryCode == 100}">
	                                <option value="${c.categoryCode}" selected>${c.categoryName}</option>
	                            </c:when>
	                            <c:otherwise>
	                                <option value="${c.categoryCode}">${c.categoryName}</option>
	                            </c:otherwise>
	                        </c:choose>
	                        
	                  	</c:forEach>
                        </select>
                    </div>
                </li>

                <li class="line"> <div class="content_title">가격</div> 
                    <div id = "price">
                    <input class="input_price"  type="text"  name="itemPrice" placeholder="숫자만 입력해주세요" > 
                    </div>
                    <p id="won">원</p>

                </li>
                <li class="line"> <div class="content_title">설명<br><small>최대 200글자</small></div> 
                    <div>
                        <textarea class="input_content" name="itemInfo" rows="10" cols="100" style="resize:none"></textarea>
                    </div>
                    <div id ="content_counter">
                        <p><span id="content_count">0</span>/200</p>
                    </div>
                </li>
            </ul>

            </section>
            <div id="footer_register">
                <button type="submit" id="register">등록하기</button>
            </div>
    </form>

  </main>  
  	
	<jsp:include page="sideBar.jsp" />
  
    <!-- footer include -->
	<jsp:include page="footer.jsp" />
	
	<script>
		const ms = "${ms}";
		<%-- var uid = '<%=(String)session.getAttribute("uid")%>';
		var uid2 = '<%=(String)session.getAttribute("uid2")%>'; --%>
	</script>
    <script src="${contextPath}/resources/js/sale.js"></script>