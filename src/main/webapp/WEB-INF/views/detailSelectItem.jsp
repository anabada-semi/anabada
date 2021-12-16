<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
	<link rel="stylesheet" href="${contextPath}/resources/css/detailSelectItem.css">
	
	<!-- header include -->
	<jsp:include page="header.jsp" />

	<main>
            <div class="category">
                <img src="${contextPath}/resources/images/itemIcon/home.png"> 홈 >
                <select>
                    <option value ="">여성의류</option>
                    <option value ="">남성의류</option>
                    <option value ="">신발</option>
                    <option value ="">가방</option>
                    <option value ="">시계/쥬얼리</option>
                    <option value ="">패션 액세서리</option>
                    <option value ="">디지털/가전</option>
                    <option value ="">스포츠/레저</option>
                    <option value ="">차량/오토바이</option>
                    <option value ="">스타굿즈</option>
                    <option value ="">키덜트</option>
                    <option value ="">예술/희귀/수집품</option>
                    <option value ="">음반/악기</option>
                    <option value ="">도서/티켓/문구</option>
                    <option value ="">뷰티/미용</option>
                    <option value ="">가구/인테리어</option>
                    <option value ="">생활/가공식품</option>
                    <option value ="">유아동/출산</option>
                    <option value ="">반려동물용품</option>
                    <option value ="">기타</option>
                </select>
            </div>
            <div class="main-top">
                <div class="product-img">
                    <img src="https://via.placeholder.com/450">
                </div>
                <div class="product-intro">
                    <div class="product-intro-top">
                        <h3>후드티</h3>
                        <h1>30,000</h1>
                    </div>
                    <div class="product-intro-bottom">
                        <div class="product-inform">
                            <span><img src="${contextPath}/resources/images/itemIcon/heart.png"> 100</span>
                            <span><img src="${contextPath}/resources/images/itemIcon/viewer.png"> 12</span>
                            <span><img src="${contextPath}/resources/images/itemIcon/clock.png"> 1시간 전</span>
                        </div>
                        <div class="product-btn">
                            <button>찜</button>
                            <button>문의하기</button>
                            <button>수정하기</button>
                        </div>
    
                    </div>
                </div>
            </div>
    
            <div class="main-bottom">
                <div class="main-bottom-left">
                    <div class="product-infrom-detail">
                        <div class="detail-top">
                            <h3>상품 정보</h3>
                            <span>
                                생명을 불어 넣는 것은 따뜻한 봄바람이다 풀밭에 속잎나고 가지에 싹이 트고 꽃 피고 새 우는 봄날의 천지는 얼마나 기쁘며 얼마나 아름다우냐? 이것을 얼음
                                속에서 불러 내는 것이 따뜻한 봄바람이다 인생에 따뜻한 봄바람을
                            </span>
                        </div>
    
                        <div class="detail-bottom">
    
                            <h4><img src="${contextPath}/resources/images/itemIcon/category.png"> 카테고리</h4>
                            <span>의류</span>
                        </div>
                    </div>
                    <div class="product-question">
                        <h3>상품 문의</h3>
                        <textarea cols="30" rows="5" placeholder="내용을 입력해주세요."></textarea>
    
                        <div class="submit">
                            <label for="secret">비밀글</label> <input type="checkbox" id="secret">
                            <button>등록</button>
                        </div>
                        <p>fdsafdsfadsf</p>
                        <p>fdsafdsfadsf</p>
                        <p>fdsafdsfadsf</p>
                        <p>fdsafdsfadsf</p>
                        <p>fdsafdsfadsf</p>
                        <p>fdsafdsfadsf</p>
                        <p>fdsafdsfadsf</p>
                        <p>fdsafdsfadsf</p>
                        <p>fdsafdsfadsf</p>
                        <p>fdsafdsfadsf</p>
                        <p>fdsafdsfadsf</p>
                        <p>fdsafdsfadsf</p>
                    </div>
                </div>
                <div class="main-bottom-rigth">
                    <h3>상점 정보</h3>
                    <h4>상점 이름</h4>
                    <h4>상점 후기 <span class="reply-count">후기개수</span></h4>
                    <div class="reply">
                        <div class="reply-">
                            <span class="user-name">유저 네임</span>
                            <span class="user-reply">
                                안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.
                            </span>
                        </div>
                            <div class="reply-">
                            <span class="user-name">유저 네임</span>
                            <span class="user-reply">
                                안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.안녕하세요.
                            </span>
                        </div>


                        <button class="btn-more">후기 더보기 > </button>
                    </div>
                </div>
            </div>
        </main>
    
    <!-- footer include -->
	<jsp:include page="footer.jsp" />