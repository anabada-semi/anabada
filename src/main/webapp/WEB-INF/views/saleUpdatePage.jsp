<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
		<!-- header include -->
	<jsp:include page="header.jsp" />

  <div id="title"><h3>상품수정</h3></div>
    <section>
        <h2>기본정보</h2>
        
        <ul>
            <li class="line">
                <div class="content_title">상품이미지<br><small>(최대 5개)</small></div>
                <div class="content_photo">
                    <label for="photo">클릭하여<br> 이미지<br>업로드</label>
                    <input type="file" id="photo">
                    <div id="guide">
                        <b>* 상품 이미지는 640x640에 최적화 되어 있습니다.</b>
                        <br>
                        - 이미지는 상품등록 시 정사각형으로 짤려서 등록됩니다.
                        <br>
                        - 이미지를 클릭 할 경우 원본이미지를 확인할 수 있습니다.
                        <br>
                        - 이미지를 클릭 후 이동하여 등록순서를 변경할 수 있습니다.
                        <br>
                        - 큰 이미지일경우 이미지가 깨지는 경우가 발생할 수 있습니다.
                        <br>
                        최대 지원 사이즈인 640 X 640 으로 리사이즈 해서 올려주세요.(개당 이미지 최대 10M)

                    </div>
                </div>
            </li>
            <li class="line">
               <div class="content_title">제목 <br><small>최대 40글자</small></div> 
               <div>
                <input class = "input_title" type="text" placeholder="상품 제목을 입력해주세요">
               </div>
            
            </li>
            <li class="line"> <div class="content_title">카테고리</div> 
                <div>
                    <ul class="category_list">
                        <li>의류</li>
                        <li>신발</li>
                        <li>가방</li>
                        <li>디지털/가전</li>
                        <li>차량/오토바이</li>
                    </ul>
                </div>
            </li>
            <li class="line"> <div class="content_title">가격</div> 
                <div>
                 <input class="input_price"  type="number" placeholder="숫자만 입력해주세요"> 
                
                </div>
            </li>
            <li class="line"> <div class="content_title">설명<br><small>최대 200글자</small></div> 
                <div>
                    <textarea rows="10" cols="100" style="resize:none"></textarea>
                </div>
            </li>
        </ul>

    </section>
    <div id="footer_update">
        <button id="update">수정하기</button>
    </div>
    
    
    <!-- footer include -->
	<jsp:include page="footer.jsp" />
	
	