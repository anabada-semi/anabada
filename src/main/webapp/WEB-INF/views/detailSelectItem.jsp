<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>물품 상세 조회</title>
	<link rel="stylesheet" href="${contextPath}/resources/css/detailSelectItem.css">
	
	<!-- header include -->
	<jsp:include page="header.jsp" />

		<main>
            <div class="category">
                <img src="${contextPath}/resources/images/itemIcon/home.png"> 홈 >
               
               	<label>카테고리</label>
                <select class="item-category-list">
                	<c:forEach items="${categoryList}" var="c">
                		<option value="${c.categoryCode}">${c.categoryName}</option>
                	</c:forEach>	
                </select>
                
            </div>
            <div class="main-top">
                <div class="product-img">
                    <img src="https://via.placeholder.com/450">
                    <!-- <img src="https://via.placeholder.com/450"> -->
                </div>
                <div class="product-intro">
                    <div class="product-intro-top">
                        <h3>${item.itemName}</h3>
                        <h1>${item.itemPrice}</h1>
                    </div>
                    <div class="product-intro-bottom">
                        <div class="product-inform">
                            <span><img src="${contextPath}/resources/images/itemIcon/heart.png"> ${item.wish}</span>
                            <span><img src="${contextPath}/resources/images/itemIcon/viewer.png"> ${item.readCount}</span>
                            <span><img src="${contextPath}/resources/images/itemIcon/clock.png"> ${item.itemDate}</span>
                        </div>
                        <div class="product-btn">
                            <button>찜</button>
                            <button onclick="">문의하기</button>
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
                                ${item.itemInfo}
                            </span>
                        </div>
    
                        <div class="detail-bottom">
    
                            <h4><img src="${contextPath}/resources/images/itemIcon/category.png"> 카테고리</h4>
                            <span>dfs</span>
                        </div>
                    </div>
                    <div class="product-question">
                        <h3>상품 문의</h3>
                        <textarea cols="30" rows="5" placeholder="내용을 입력해주세요."></textarea>
    
                        <div class="submit">
                            <label for="secret">비밀글</label> <input type="checkbox" id="secret">
                            <button>등록</button>
                        </div>
                        <div class="">

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