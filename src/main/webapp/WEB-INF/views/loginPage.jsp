<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>loginPage</title>
    <link rel="stylesheet" type="text/css" href="css/loginPage.css">
</head>
<body>
       <div class="wrapper">
    <header>
        <!-- 맨 위부분 로그인, 로그아웃, 내 상점 -->
        <div class="header-top">
            <div class="header-login">
                <div id="login">로그인</div>
                <div id="singup">회원가입</div>
            </div>
        </div>

        <div class="header-bottom">
            <div class="header-main">
                <div class="header-main-top">
                    <div id="logo">
                        아나바다
                    </div>

                    <div id="search">
                        <input type="text" id="search_input" placeholder="검색어 입력">
                        <img src="img/검색.png">
                    </div>

                    <div id="logo-right">
                        <div class="sale">
                            <img src="img/판매.png">
                            <p id="sale">판매하기</p>
                            <!-- &nbsp;판매하기 -->
                        </div>
                        <div class="shop">
                            <img src="img/내상점.png">
                            <p id="shop">내상점</p>
                            <!-- &nbsp;내상점 -->
                        </div>
                        <div class="notice">
                            <img src="img/알림.png">
                            <p id="notice">알림</p>
                            <!-- &nbsp;알림 -->
                        </div>
                    </div>

                </div>

                <div class="header-main-bottom">
                    <img src="img/카테고리.png">
                </div>
                <img src="/img/" alt="">
            </div>
        </div>
    </header>

    <section id="login-section">
        <div id="login-area">
            <form action="" method="">
                <div id="login-area2">
                    <input type="text" id="id" placeholder="아이디(ID)"> <br>
                    <input type="password" id="pw"> <br>
                    <a href="" id="searchId">아이디</a>|<a href="" id="searchPw">비밀번호 찾기</a>
                </div>
                <div id="login-area3">
                    <button id="login">로그인</button> <br>
                    <button id="signUp">회원가입</button>
                </div>
            </form>
        </div>
    </section>

    <aside>
        <div id="side-bar">
            <div>
                <div id="heart-item">찜한상품</div>
                <div id="heart-count">♥ 0</div>
            </div>
            <div>
                <div id="recently-item">최근본상품</div>
                <div id="recently-count"></div>
                <div id="recently-dotted"></div>
                <div id="recently-img"></div>
            </div>
            <div id="button-top">
                <div>TOP</div>
            </div>
        </div>
    </aside>
    
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