<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<title>물품 상세 조회</title>
	<link rel="stylesheet" href="${contextPath}/resources/css/detailSelectItem.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

	<!-- header include -->
	<jsp:include page="header.jsp" />

		<main>
            <div class="category">
                <img src="${contextPath}/resources/images/itemIcon/home.png"> 홈 >
               
               	<label>카테고리</label>

                <select class="item-category-list">
                    <c:forEach items="${categoryList}" var="c">

                        <c:choose>
                            <c:when test="${c.categoryCode == item.categoryCode}">
                                <option value="${c.categoryCode}" selected>${c.categoryName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${c.categoryCode}">${c.categoryName}</option>
                            </c:otherwise>
                        </c:choose>

                	</c:forEach>	
                </select>
                
            </div>
            <div class="main-top">

                <div id="myCarousel" class="carousel slide product-img">

                    <div class="carousel-inner">
                        
                        <div class="carousel-item active">
                            <img src="${contextPath}${itemImg[0].imgPath}${itemImg[0].imgName}" onclick="showImg(this);">
                        </div>
                        <div class="carousel-item">
                            <img src="${contextPath}${itemImg[1].imgPath}${itemImg[1].imgName}" onclick="showImg(this);">
                        </div>
                        <div class="carousel-item">
                            <img src="${contextPath}${itemImg[2].imgPath}${itemImg[2].imgName}" onclick="showImg(this);">
                        </div>
                    </div>

                    <a class="carousel-control-prev" href="#myCarousel" data-slide="prev" style="left: 30px;">
                        <span class="carousel-control-prev-icon"></span>
                    </a>
                    <a class="carousel-control-next" href="#myCarousel" data-slide="next" style="right: 30px;">
                        <span class="carousel-control-next-icon"></span>
                    </a>

                </div>

                    <div class="product-intro">
                    <div class="product-intro-top">
                        <h4 style="font-weight: bold;">${item.itemName}</h4>
                        <h2 style="font-weight: bold;">${item.itemPrice}원</h2>
                    </div>
                    <div class="product-intro-bottom">
                        <div class="product-inform">
                            <span><img src="${contextPath}/resources/images/itemIcon/heart.png"><p id="wish-count"> ${item.wish}</p></span>
                            <span><img src="${contextPath}/resources/images/itemIcon/viewer.png"><p id="read-count"> ${item.readCount}</p></span>
                            <span><img src="${contextPath}/resources/images/itemIcon/clock.png"> ${date}</span>
                        </div>
                        <div class="product-btn">
                            <button onclick = "wish(${item.itemNo}, this)">찜</button>
                            <button id="question">문의하기</button>
                            <c:if test="${item.memberNo == loginMember.memberNo}">
                                <button onclick="location.href='${contextPath}/item/updateForm?no=${item.itemNo}'">수정하기</button>
                            </c:if>
                        </div>
    
                    </div>
                </div>
            </div>
    
            <div class="main-bottom">
                <div class="main-bottom-left">
                    <div class="product-infrom-detail">
                        <div class="detail-top">
                            <h5 style="font-weight: bold;">상품 정보</h5>
                            <span>
                                ${item.itemInfo}
                            </span>
                        </div>
    
                        <div class="detail-bottom">
    
                            <h5 style="font-weight: bold;"><img src="${contextPath}/resources/images/itemIcon/category.png"> 카테고리</h5>
                            <span>${item.categoryName}</span>
                        </div>
                    </div>
                    <div class="product-question">
                        <h5 id="item-question" style="font-weight: bold;">상품 문의</h5>
                        <textarea id="replyContent" cols="30" rows="5" placeholder="내용을 입력해주세요."></textarea>
    
                        <div class="submit">
                            <label for="secret">비밀글</label> <input type="checkbox" id="secret">
                            <button class="reply-submit" onclick="addReply();">등록</button>
                        </div>

                        <div class="reply-div">
                            <ul id="replyListArea">
                                <c:forEach items="${rList}" var="reply">
                                    <c:choose>
                                        <c:when test="${reply.replyNestedCode != 2 }">
                                                <li class="reply-row">
                                                    <div class="reply-padding">
                                                        <p class="rWriter">${reply.memberName}</p>
                                                        <fmt:formatDate var="replyDate" value="${reply.replyDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                                                        <p class="rDate">작성일 : ${replyDate}</p>
                                                    </div>

                                                    <!-- 비밀 댓글이면(replySecret == 1) -->
                                                    <!-- 일반 댓글이면(replySecret == 2) -->
                                                    <c:choose>

                                                        <c:when test="${reply.replySecret == 1}">
                                                            <c:choose>
                                                                <c:when test = "${reply.memberNo == loginMember.memberNo || item.memberNo == loginMember.memberNo}">
                                                                    <p class="rContent">${reply.replyContent }</p>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <p class="rContent">비밀글 입니다.</p>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:when>

                                                        <c:otherwise>
                                                            <p class="rContent">${reply.replyContent }</p>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    
                                                    <!-- 버튼 -->
                                                    <!--             상품 판매자 == 로그인 한 회원      ||   댓글 단 사람 == 로그인 한 회원 -->
                                                    <c:if test="${item.memberNo == loginMember.memberNo || reply.memberNo == loginMember.memberNo}">
                                                        <!-- 수정, 삭제, 답글 -->
                                                        <c:choose>
                                                            <c:when test="${reply.memberNo == loginMember.memberNo}">
                                                                <div class="replyBtnArea">
                                                                    <button id="deleteReply" onclick="deleteReply(${reply.replyNo})">삭제</button>
                                                                    <button id="updateReply" onclick="showUpdateReply(${reply.replyNo}, this)">수정</button>
                                                                    <button id="updateAnswer" onclick="answerReply(${reply.replyNo}, ${loginMember.memberNo}, this)">답글</button>
                                                                </div>
                                                            </c:when>
                                                            
                                                            <c:otherwise>
                                                                <div class="replyBtnArea">
                                                                    <button id="updateAnswer" onclick="answerReply(${reply.replyNo}, ${loginMember.memberNo}, this)">답글</button>
                                                                </div>
                                                            </c:otherwise>
                                                        </c:choose>
                                                            
                                                    </c:if>

                                                    <!-- 대댓글 -->
                                                    
                                                    <div class="answerArea">
                                                        <!-- textarea -->
                                                        <ul class="answerListArea">
                                                            
                                                            <!-- 대댓글이고 && 댓글 번호와 대댓글 번호가 일치하면 -->
                                                            <c:forEach items="${answer}" var="answer">
                                                            <c:choose>
                                                            <c:when test="${answer.replyNestedCode == 2 && answer.replyNestedNo == reply.replyNo}">
                                                            
                                                            <li class="answer-row">
                                                                <!-- beforeReplyRow -->
                                                                <p class="answer-sign">⤷</p>
                                                                <div class="answer-padding">
                                                                    <p class="rWriter">${answer.memberName}</p>
                                                                    <fmt:formatDate var="answerDate" value="${answer.replyDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                                                                    <p class="rDate">${answerDate}</p>
                                                                    
                                                                    <!-- 상품 판매자 == 로그인한 사람 || 댓글 단 사람 == 로그인 한 사람 -->
                                                                    <c:choose>
                                                                        <c:when test="${item.memberNo == loginMember.memberNo || reply.memberNo == loginMember.memberNo}">
                                                                            <p class="rContent">${answer.replyContent }</p>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <p class="rContent">비밀글 입니다.</p>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </div>

                                                                <!-- 대댓글 단 사람 == 로그인 한 사람 -->
                                                                <c:choose>
                                                                    <c:when test="${answer.memberNo == loginMember.memberNo}">
                                                                        <div class="replyBtnArea">
                                                                            <button id="deleteReply" onclick="deleteReply(${answer.replyNo})">삭제</button>
                                                                            <button id="updateReply" onclick="updateAnswerReply(${answer.replyNo}, ${loginMember.memberNo}, this)">수정</button>
                                                                        </div>
                                                                    </c:when>
                                                                </c:choose>
                                                                  
                                                            </li>
                                                            </c:when>
                                                            </c:choose>
                                                            </c:forEach>

                                                        </ul>
                                                    </div>
                                                </li>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                </div>
                <div class="main-bottom-rigth">
                    <h5 style="font-weight: bold;">상점 이름</h5>
                    <h6 style="font-weight: bold;">${shop.shopName}</h6>
                    <h5 style="font-weight: bold;">상점 후기 <span class="reply-count">${fn:length(postScriptList)}</span></h5>
                    <div class="reply">

                        <c:forEach var="i" begin="0" end="1">
                            <div class="review">
                                <span class="user-name">${postScriptList[i].memberName}</span>
                                <span class="user-reply">
                                    ${postScriptList[i].postScriptCheck}
                                </span>
                            </div>
                        </c:forEach>

                        <button class="more-review" onclick="location.href='${contextPath}/myShop/myShop?no=${shop.memberNo}'">후기 더보기 > </button>
                    </div>
                </div>
            </div>
        </main>
    
      <script>
        // const contextPath = "${contextPath}";

        // 로그인한 회원의 회원 번호, 비로그인 시 "" (빈문자열)
        // const loginMemberNo = "${loginMember.memberNo}";
        
        // 현재 게시글 번호
        // const itemNo = ${item.itemNo};
        
        // 현재 게시글 작성자 번호
        // const itemMemberNo = ${item.memberNo};

        // 수정 전 댓글 요소를 저장할 변수 (댓글 수정 시 사용)
        let beforeReplyRow;

        // 수정 전 답변글 요소를 저장할 변수 (답변글 수정 시 사용)
        let beforeAnswerRow;
        let beforeAnswerBtn1;
        let beforeAnswerBtn2;
      </script>  

      <script src="${contextPath}/resources/js/detailSelectItem.js"></script>
    <!-- footer include -->
	<jsp:include page="footer.jsp" />