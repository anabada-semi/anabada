<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <link rel="stylesheet" href="${contextPath}/resources/css/salePage.css">
		<!-- header include -->
	<jsp:include page="header.jsp" />
	
    <main>
     <div id="title"><h3>상품수정</h3></div>
        <form action="update" method="post" enctype="multipart/form-data"  role="form" onsubmit="return saleValidate();">
            <section>
            <h2>기본정보</h2>

				<c:forEach items="${item.imgList}" var="img">
					<c:choose>
						<c:when test="${img.imgLevel == 0 }">
							<c:set var="img0" value="${contextPath}${img.imgPath}${img.imgName}"/>
						</c:when>
						<c:when test="${img.imgLevel == 1 }">
							<c:set var="img1" value="${contextPath}${img.imgPath}${img.imgName}"/>
						</c:when>
						<c:when test="${img.imgLevel == 2 }">
							<c:set var="img2" value="${contextPath}${img.imgPath}${img.imgName}"/>
						</c:when>
					</c:choose>
				</c:forEach>

                <ul>
                <li class="line">
                    <div class="content_title">상품이미지<br><small>(최대 3개)</small></div>
                    <div class="content_photo">
                        <div class="itemImg"><img src="${img0}">클릭하여<br> 이미지<br>업로드
                            <c:choose>
                            	<c:when test="${empty img0}">
                            		<button type="button" class="deleteBtn" id="delete0" disabled>x</button>
                            	</c:when>
                            	<c:otherwise>
		                            <button type="button" class="deleteBtn" id="delete0">x</button>                            	
                            	</c:otherwise>
                            </c:choose>
                        </div>
                        <div class="itemImg"><img src="${img1}">클릭하여<br> 이미지<br>업로드
                            <c:choose>
                            	<c:when test="${empty img1}">
                            		<button type="button" class="deleteBtn" id="delete1" disabled>x</button>
                            	</c:when>
                            	<c:otherwise>
		                            <button type="button" class="deleteBtn" id="delete1">x</button>                            	
                            	</c:otherwise>
                            </c:choose>
                        </div>
                        <div class="itemImg"><img src="${img2}">클릭하여<br> 이미지<br>업로드
                            <c:choose>
                            	<c:when test="${empty img2}">
                            		<button type="button" class="deleteBtn" id="delete2" disabled>x</button>
                            	</c:when>
                            	<c:otherwise>
		                            <button type="button" class="deleteBtn" id="delete2">x</button>                            	
                            	</c:otherwise>
                            </c:choose>
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
                    <input class ="input_title" type="text" name="itemName" placeholder="상품 제목을 입력해주세요" value ="${item.itemName}">
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
                            		<c:when test="${c.categoryCode == item.categoryCode}">
                            			<c:set var="sel" value="selected"/>
                            		</c:when>
                            		<c:otherwise>
                            			<c:remove var="sel"/>
                            		</c:otherwise>
                            	</c:choose>
                           		 <option value="${c.categoryCode}"${sel}>${c.categoryName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </li>

                <li class="line"> <div class="content_title">가격</div> 
                    <div id = "price">
                    <input class="input_price"  type="text"  name="itemPrice" placeholder="숫자만 입력해주세요"  value="${item.itemPrice}"> 
                    </div>
                    <p id="won">원</p>

                </li>
                <li class="line"> <div class="content_title">설명<br><small>최대 200글자</small></div> 
                    <div>
                        <textarea class="input_content" name="itemInfo" rows="10" cols="100" style="resize:none">${item.itemInfo}</textarea>
                    </div>
                    <div id ="content_counter">
                        <p><span id="content_count">0</span>/200</p>
                    </div>
                </li>
                </ul>
        
            </section>
                 <div id="footer_register">
                    <button type="submit" id="update">수정하기</button>
                </div>
                
                <input type="hidden" name="no" value="${item.itemNo}">
        </form>
        
          </main>  
          
            <script>
                // const loginMemberNo = "${loginMember.memberNo}";
                const itemImgList = "${item.imgList}";
                const ms = "${ms}";
            </script>
          	<jsp:include page="sideBar.jsp" />
          
            <!-- footer include -->
            <jsp:include page="footer.jsp" />
        
        <script src="${contextPath}/resources/js/sale.js"></script>