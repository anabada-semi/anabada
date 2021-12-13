<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
    <title>아나바다 - 중고거래 웹 사이트</title>
    <link rel="stylesheet" href="/">
    
</head>
<body>
	    <div class="wrapper">
        <header>
            <!-- 맨 위부분 로그인, 로그아웃, 내 상점 -->
            <div class="header-top">
                <div class="header-login">
                    <div id="login"><a href="#">로그인</a></div>
                    <div id="singup" ><a href="#">회원가입</a></div>
                </div>
            </div>
    
            <div class="header-bottom">
                <div class="header-main">
                    <div class="header-main-top">
                        <div id="logo" onclick="location.href='#'">
                            아나바다
                        </div>
    
                        <div id="search">
                            <input type="text" id="search_input" placeholder="검색어 입력">
                            <img src="/img/검색.png" id="search-img" onclick="location.href='#'">
                        </div>
    
                        <div id="logo-right">
                            <div class="sale" onclick="location.href='#'">
                                <img src="/img/판매.png">
                                <p id="sale">판매하기</p>
                                <!-- &nbsp;판매하기 -->
                            </div>
                            <div class="shop" onclick="location.href='#'">
                                <img src="/img/내상점.png">
                                <p id="shop">내상점</p>
                                <!-- &nbsp;내상점 -->
                            </div>
                            <div class="notice" onclick="location.href='#'">
                                <img src="/img/알림.png">
                                <p id="notice">알림</p>
                                <!-- &nbsp;알림 -->
                            </div>
                        </div>
    
                    </div>
                    <!-- <img src="/img/카테고리.png" id="category"> -->
                    <div class="header-main-bottom">
                        <div class="dropdown">
                            <span><img src="/img/카테고리.png" id="category"></span>
                            <div class="dropdown-content">
                                <ul>
                                    <li>여성의류</li>
                                    <li>남성의류</li>
                                    <li>신발</li>
                                    <li>가방</li>
                                    <li>시계/쥬얼리</li>
                                    <li>패션 액세서리</li>
                                    <li>디지털/가전</li>
                                    <li>스포츠/레저</li>
                                    <li">차량/오토바이</option>
                                    <li>스타굿즈</li>
                                    <li>키덜트</li>
                                    <li>예술/희귀/수집품</li>
                                    <li>음반/악기</li>
                                    <li>도서/티켓/문구</li>
                                    <li>뷰티/미용</li>
                                    <li>가구/인테리어</li>
                                    <li>생활/가공식품</li>
                                    <li>유아동/출산</option>
                                    <li>반려동물용품</li>
                                    <li>기타</li>
                                </ul>
                            </div>
                          </div>
                    </div>
    
                </div>
            </div>
        </header>
    
        <main>
            <!-- <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p>
            <p>asdffdshfkajdshfjasdhfkjladhsfkbdsakjfhdskbkjsdjacblkdkj</p> -->
    
        </main>
    
        <footer>
            <div class="footer-left">
                <b>아나바다(주) 사업자정보</b> <br><br>
                
                대표이사 : 아나바다  <br>
                | 개인정보보호담당자 : 아나바다 <br> <br>
                사업자등록번호 : 12345-123456 <br> <br>
                EMAIL : anabada@kh.or.kr<br> <br>
                주소 : 서울시 남대문로 <br> <br>
                사업자정보 확인
                
            </div>
    
            <div class="footer-right">
                <b>고객센터</b> <br><br>
                1234-1234   <br> <br>
                운영시간 9시 ~ 18시 <br> <br>
                (주말/공휴일 휴무, 점심시간 12시 ~13시) <br> <br>
                <u>공지사항</u>    <br> <br>
                <u>1:1문의하기</u> <br> <br>
                <u>자주 묻는 질문</u>  <br> <br>
            </div>
        </footer>
    </div>
</body>
</html>