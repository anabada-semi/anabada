<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	   <title>아나바다 - 중고거래 웹 사이트</title>
    <link rel="stylesheet" href="/css/header+footer.css">
    <link rel="stylesheet" href="/css/salePage.css">
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
                            <img src="/img/검색.png">
                        </div>
    
                        <div id="logo-right">
                            <div class="sale">
                                <img src="/img/판매.png">
                                <p id="sale">판매하기</p>
                                <!-- &nbsp;판매하기 -->
                            </div>
                            <div class="shop">
                                <img src="/img/내상점.png">
                                <p id="shop">내상점</p>
                                <!-- &nbsp;내상점 -->
                            </div>
                            <div class="notice">
                                <img src="/img/알림.png">
                                <p id="notice">알림</p>
                                <!-- &nbsp;알림 -->
                            </div>
                        </div>
    
                    </div>
    
                    <div class="header-main-bottom">
                        <img src="/img/카테고리.png">
                    </div>
    
                </div>
            </div>
        </header>
    
        <main>
            <div id="title"><h3>상품등록</h3></div>
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
    <div id="footer_register">
        <button id="register">등록하기</button>
    </div>
    
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