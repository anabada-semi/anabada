<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
                <div id="recently-img"></div>
            </div>
            <div id="button-top">
                <div><a href="#body-top" id="top-btn" style="font-family: 'GmarketSansMedium';">TOP</a></div>
            </div>
        </div>
    </aside>
    
    <script src="${contextPath}/resources/js/sideBar.js"></script>