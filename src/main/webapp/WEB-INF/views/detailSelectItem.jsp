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
                    <%-- <img src="${contextPath}${itemImg.imgPath}${itemImg.img_name}"> --%>
                </div>
                <div class="product-intro">
                    <div class="product-intro-top">
                        <h3>${item.itemName}</h3>
                        <h1>${item.itemPrice}원</h1>
                    </div>
                    <div class="product-intro-bottom">
                        <div class="product-inform">
                            <span><img src="${contextPath}/resources/images/itemIcon/heart.png"> ${item.wish}</span>
                            <span><img src="${contextPath}/resources/images/itemIcon/viewer.png"> ${item.readCount}</span>
                            <span><img src="${contextPath}/resources/images/itemIcon/clock.png"> ${date}</span>
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
                            <span>${item.categoryName}</span>
                        </div>
                    </div>
                    <div class="product-question">
                        <h3>상품 문의</h3>
                        <textarea id="replyContent" cols="30" rows="5" placeholder="내용을 입력해주세요."></textarea>
    
                        <div class="submit">
                            <label for="secret">비밀글</label> <input type="checkbox" id="secret">
                            <button id="reply-submit" onclick="addReply();">등록</button>
                        </div>

                        <div class="reply-div">
                            <ul>

                                
                                <div>
                                    <li class="reply-row">
                                        <div>
                                            <p class="rWriter">유저1</p><p class="rDate">2021-12-20</p>
                                        </div>
                                        <p class="rContent">댓글입니다.</p>
                                    </li>
                                </div>

                                <div>
                                    <li class="reply-row">
                                        <div>
                                            <p class="rWriter">유저1</p><p class="rDate">2021-12-20</p>
                                        </div>
                                        <p class="rContent">댓글입니다.</p>
                                    </li>
                                </div>

                                <div>
                                    <li class="reply-row">
                                        <div>
                                            <p class="rWriter">유저1</p><p class="rDate">2021-12-20</p>
                                        </div>
                                        <p class="rContent">댓글입니다.</p>
                                    </li>
                                </div>



                            </ul>
                        </div>
                        
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
    
    <script>

	// 전역 변수로 댓글 관련 기능에 사용될 변수를 미리 선언
	// -> 이 때 JSP에서만 사용 가능한 EL 값을 전역 변수로 선언하면
	//    아래 쪽에 추가된 js파일에서 사용 가능
	
	const contextPath = "${contextPath}";
	
	// 로그인한 회원의 회원 번호, 비로그인 시 "" (빈문자열)
	const loginMemberNo = "${loginMember.memberNo}";
	
	// 현재 게시글 번호
	const boardNo = ${board.boardNo};
	
	// 수정 전 댓글 요소를 저장할 변수 (댓글 수정 시 사용)
	let beforeReplyRow;
	
	</script>
    
    <!-- footer include -->
	<jsp:include page="footer.jsp" />