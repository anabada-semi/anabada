<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/sideBar.css">

    <aside>
        <div id="side-bar">
            <div>
                <div id="heart-item" style="font-family: 'GmarketSansMedium';">찜한상품</div>
                <div class="heart" style="font-family: 'GmarketSansMedium';">♥ <span class="heart" id="heart">0</span></div>
            </div>
            <div>
                <div id="recently-item" style="font-family: 'GmarketSansMedium';">최근본상품</div>
                <div id="recently-count"></div>
                <div id="recently-dotted"></div>
                <div class="box-area"></div>
                <div id="box-img">
                	<c:forEach items="${recentItemList}" var="itemImg"> 
                		<div class="recently-img" onclick="location.href='${contextPath}/detail/select?no=${itemImg.itemNo}'">
               				<img src="${contextPath}${itemImg.imgPath}${itemImg.imgName}">
                		</div>
                	<!-- 중복제거 , 개수제한-->
                	</c:forEach>
                
               	<%-- <div class="recently-img" onclick="location.href='${contextPath}/detail/select?no=${item.itemNo}&cp=${pagination.currentPage}'">
                		<img src="${contextPath}${item.imgList[0].imgPath}${item.imgList[0].imgName}">
                	</div>  --%>
                </div>
                <div class="box-area"></div>
            </div>
            <div id="button-top">
                <div><a href="#body-top" id="top-btn" style="font-family: 'GmarketSansMedium';">TOP</a></div>
            </div>
        </div>
    </aside>
    
    <script src="${contextPath}/resources/js/sideBar.js"></script>