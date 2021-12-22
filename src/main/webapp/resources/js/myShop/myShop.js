/* 내 상점 페이지 */
$(".btn").on("click", function(){
	// console.log($(this).index());	
    $(".btn").removeClass("active");
    $(this).addClass("active");

    $("#changeDiv").empty();
    
    switch($(this).index()){
        case 0: 
            $.ajax({
                url: contextPath + "/myShop/itemList",
                success: function(r){
                    $("#changeDiv").append(r);
                    selectitemList();
                },
                error:function(req,status,er){
                    console.log(req.responseText);
                }
            }); break;

        case 1: 
            $.ajax({
                url: contextPath + "/myShop/wishList",
                success: function(r){
                    $("#changeDiv").append(r);
                    wishList();
                },
                error:function(req,status,er){
                    console.log(req.responseText);
                }
            }); break;

        case 2: 
            $.ajax({
                url: contextPath + "/myShop/postScript",
                success: function(r){
                    $("#changeDiv").append(r);
                    selectReplyList();
                    flag = false;
                },
                error:function(req,status,er){
                    console.log(req.responseText);
                }
            }); break;

        case 3: 
            $.ajax({
                url: contextPath + "/myShop/buyList",
                success: function(r){
                    $("#changeDiv").html(r);
                    buyPage();
                },
                error:function(req,status,er){
                    console.log(req.responseText);
                }
            }); break;

        case 4: 
            $.ajax({
                url: contextPath + "/myShop/sellList",
                success: function(r){
                    $("#changeDiv").html(r);
                    sellPage();
                },
                error:function(req,status,er){
                    console.log(req.responseText);
                }
            }); break;
        default:
    }
});

let postNo = [];
// 댓글 목록 조회
function selectReplyList() {
    const locationPost = $("#userPostTextareaBtn").parent().prev();

    $.ajax({
        url: contextPath + "/myShop/selectPostScript",
        data: { "memberNo": loginMemberNo },
        dataType: "JSON",
        success: function (r) {

            $.each(r, function (index, post) {

                postNo[index] = post.postScriptNo;

                const upd = $('<button class="userPostDelete">삭제</button>');
                const upu = $('<button class="userPostUpdate">수정</button>');
                const uprBtn = $('<button class="userPostReport">신고</button>');
                let upr = $("<div class='userPost-report'>");

                if (post.memberNo == loginMemberNo) {
                    upr.append(upd, upu);
                }else{
                    upr.append(uprBtn);
                }
                
                const upc = $("<div class='userPost-content'>");
                upc.text(post.postScriptCheck);

                const ups = $("<div class='userPost-shop'>");
                // ups.text("상점 이동");
                ups.append('<a href="' + contextPath + '/myShop/myShop?no=' + post.memberNo + '">상점 이동</a>');

                const upst = $("<div class='userPost-star'>");
                // upst.text("별사진");
                upst.append('<img class="userPostStarImg" src="/anabada/resources/images/myShop/profile/하트.png"><img class="userPostStarImg" src="/anabada/resources/images/myShop/profile/하트.png"><img class="userPostStarImg" src="/anabada/resources/images/myShop/profile/하트.png"><img class="userPostStarImg" src="/anabada/resources/images/myShop/profile/하트.png"><img class="userPostStarImg" src="/anabada/resources/images/myShop/profile/하트.png">');

                const upn = $("<div class='userPost-name'>");
                // upn.append('<a href="' + contextPath + '/myShop/myShop?no=' + post.memberNo + '">' + post.shopName + '</a>');
                upn.append(post.shopName);
                
                const upa = $("<div class='userPost-area'>");
                upa.append(upn, upst, ups, upc, upr);

                const upi = $("<div class='userPostImgDiv'>");
                upi.append('<img class="userPostImg" src="/anabada/resources/images/myShop/profile/캐릭터.png">');

                const up = $("<div class='userPost' id='" + index + "'>");

                up.append(upi, upa);

                locationPost.after(up);
                
                $(".userPostTextarea").val("");
                
            });
            (function(){
                $("#postScriptText").text($(".userPost").length);
            }());
        },
        error: function (req, status, error) {
            console.log("댓글 목록 조회 실패");
            console.log(req.responseText);
        }
    });
}

// 판매중인 상품 목록 조회
function selectitemList() {
    $.ajax({
        url: contextPath + "/myShop/selectItemList",
        data: { "shopNo": shopNo },
        dataType: "JSON",
        success: function (r) {
            $.each(r, function (index, item) {
                // contextPath/myShop/myShop?no=item.itemNo
                const table = $("<table>");
                const tr = $("<tr class='itemTr'>");
                const td = $("<td class='itemTd'>");

                let imgSrc;
                if(item.itemImgName != null)    imgSrc = contextPath + item.itemPath + item.itemImgName;
                else                            imgSrc = contextPath + '/resources/images/myShop/profile/바다.jpg';
                itemImg = $('<a href="' + contextPath + '/detail/select?itemNo=' + item.itemNo + '"><img class="itemImg" src="' + imgSrc + '">');

                const itD = $('<div class="itemTextDiv">');
                const it1 = $('<div class="itemText1">' + item.itemName + '<div>');
                const it2 = $('<div class="itemText2">' + item.itemPrice + '원<div>');
                const it3 = $('<div class="itemText3">' + item.uploadDate + '<div>');

                itD.append(it1, it2, it3);

                td.append(itemImg, itD);

                tr.append(td);
                $(".itemTr").eq(Math.floor(index/4)).append(td);

                if(index % 4 == 0)
                    $(".addItem").append(tr);

            });
            
            (function(){
                $("#itemText").text($(".itemTd").length);
            }());
        },
        error: function (req, status, error) {
            console.log("댓글 목록 조회 실패");
            console.log(req.responseText);
        }
    });
}

/* 찜 목록 조회 */
let wishNo = [];
function wishList(){

    const abc = $("#wishSpanText").parent().next();

    $.ajax({
        url: contextPath + "/myShop/wishItemList",
        data: { "shopNo": shopNo },
        dataType: "JSON",
        success: function (r) {
            $.each(r, function (index, wish) {

                wishNo[index] = wish.itemNo;

                const wc = $('<div class="wishContainer" id="' + wishNo[index] + '">');

                let imgSrc;
                if(wish.imgName != null)    imgSrc = contextPath + wish.itemPath + wish.imgName;
                else                        imgSrc = contextPath + '/resources/images/myShop/profile/바다.jpg';
                const wi = $('<a href="' + contextPath + '/detail/select?itemNo=' + wish.itemNo + '"><img class="wishImg" src="' + wish.imgSrc + '">');


                const wtd = $('<div class="wishTextDiv">');
                const wTitle = $('<div class="wishTitle">');
                wTitle.text(wish.itemName);

                const wdBtn = $('<button class="wishDeleteBtn">');
                wdBtn.text('찜 삭제');

                const wt1 = $('<div class="wishText1">');
                wt1.text(wish.itemPrice);

                const wt2 = $('<div class="wishText2">');
                wt2.text(wish.uploadDate);

                wTitle.append(wdBtn);
                wtd.append(wTitle, wt1, wt2);
                wc.append(wi, wtd);

                abc.after(wc);

            });

            (function() {
                $("#wishSpanText").text($(".wishContainer").length);
            }());
        },
        error: function (req, status, error) {
            console.log("댓글 목록 조회 실패");
            console.log(req.responseText);
        }
    });
}

/* 구매목록 조회 페이지 */
function buyPage(){
    $.ajax({
        url: contextPath + "/myShop/buyItemList",
        data: { "shopNo": shopNo },
        dataType: "JSON",
        success: function (result) {
            $.each(result, function (index, buyList) {

                const tr = $("<tr class='buyTr'>");
                const td = $("<td class='buyTd'>");
                const bid = $('<div class="buyImgDiv">');
                
                let imgSrc;
                if(buyList.itemImgName != null)    imgSrc = contextPath + buyList.itemImgPath + buyList.itemImgName;
                else                            imgSrc = contextPath + '/resources/images/myShop/profile/바다.jpg';
                itemImg = $('<a href="' + contextPath + '/detail/select?itemNo=' + buyList.itemNo + '"><img class="buyImg" src="' + imgSrc + '">');
                
                const bis = $('<span class="buyImgSpan"> 구매 완료 </span>');
                bid.append(bis, itemImg);

                const btd = $('<div class="buyTextDiv">');
                const bt1 = $('<div class="buyText1">');
                bt1.append(buyList.itemName);

                const bt2 = $('<div class="buyText2">');
                bt2.append(buyList.itemPrice);

                const bt3 = $('<div class="buyText3">');
                bt3.append(buyList.uploadDate);

                btd.append(bt1, bt2 ,bt3);

                td.append(bid, btd);

                tr.append(td);
                $(".buyTr").eq(Math.floor(index/4)).append(td);

                if(index % 4 == 0)
                    $(".addBuyList").append(tr);

            });
            (function(){
                $("#buyText").text($(".buyTd").length);
            }());
        },
        error: function (req, status, error) {
            console.log("구매 목록 조회 실패");
            console.log(req.responseText);
        }
    });
}

/* 판매 목록 조회 페이지 */
function sellPage(){
    $.ajax({
        url: contextPath + "/myShop/sellItemList",
        data: { "shopNo": shopNo },
        dataType: "JSON",
        success: function (result) {
            $.each(result, function (index, sellList) {

                const tr = $("<tr class='sellTr'>");
                const td = $("<td class='sellTd'>");
                const sid = $('<div class="sellImgDiv">');
                
                let imgSrc;
                if(sellList.itemImgName != null)    imgSrc = contextPath + sellList.itemPath + sellList.itemImgName;
                else                            imgSrc = contextPath + '/resources/images/myShop/profile/바다.jpg';
                itemImg = $('<a href="' + contextPath + '/detail/select?itemNo=' + sellList.itemNo + '"><img class="sellImg" src="' + imgSrc + '">');
                
                const sis = $('<span class="sellImgSpan"> 판매 완료 </span>');
                sid.append(sis, itemImg);

                const std = $('<div class="sellTextDiv">');
                const st1 = $('<div class="sellText1">');
                st1.append(sellList.itemName);

                const st2 = $('<div class="sellText2">');
                st2.append(sellList.itemPrice);

                const st3 = $('<div class="sellText3">');
                st3.append(sellList.uploadDate);

                std.append(st1, st2 ,st3);

                td.append(sid, std);

                tr.append(td);
                $(".sellTr").eq(Math.floor(index/4)).append(td);

                if(index % 4 == 0)
                    $(".addSellList").append(tr);

            });
            (function(){
                $("#itemText").text($(".sellTd").length);
            }());

        },
        error: function (req, status, error) {
            console.log("구매 목록 조회 실패");
            console.log(req.responseText);
        }
    });
}



const textCountLimit = 120;

/* 상점명 변경 */
$(document).on("click",".shopNameBtn", function(){
    $("#save").empty();
    $("#save").append("<input type='text' id='userName'>");
    $("#save").append("<button class='userNameBtn'>확인</button>");
});
const nowName = $("#userName").val();
/* 상점명 변경 확인 버튼 */
$(document).on("click",".userNameBtn", function(){
    const inputName = $("#userName");

    const reg = /^[\w\dㄱ-힣][\w\dㄱ-힣-_]{3,12}$/;

    if(reg.test(inputName.val())){

        $.ajax({
            url: contextPath + "/myShop/shopNameCng",
            data: { "memberNo": loginMemberNo, "inputName": inputName.val() },
            success: function(r){
                if(r > 0){
                    $("#userName123").text("");
                    $("#userName123").text(inputName.val());
                    $("#save").empty();
                    $("#save").append("<span id='userNameCng'>" + inputName.val() + "</span>");
                    $("#save").append("<button class='shopNameBtn'>상점명 수정</button>");
                }else{
                    alert("상점명 변경 실패");
                    $("#userName123").text("");
                    $("#userName123").text(nowName);
                    $("#save").empty();
                    $("#save").append("<span id='userNameCng'>" + nowName + "</span>");
                    $("#save").append("<button class='shopNameBtn'>상점명 수정</button>");
                }
            },
            error:function(req, status, er){
                console.log(req.responseText);
            }
        });

    }else{
        alert("4글자 이상");
    }
});

/* 소개글 변경 */
$(document).on("click", "#myShopContent2", function(){

    const parent = $("#myShopContent1");
    parent.empty();
    parent.append("<textarea name='' id='contentTextarea'></textarea>");
    
    $("#contentTextarea").val( $("#myShopContent").text() );

    const textLength = $("#contentTextarea").val().length;

    $("#myShopContent").text("").css("height", "0px");
    
    parent.append("<button id='myShopContentBtn'>확인<br>" + textLength + "/120</button>");

});

const nowContent = $("#myShopContent").val();
/* 소개글 변경 후 확인 버튼 */
$(document).on("click", "#myShopContentBtn", function(){
    const contentTextarea = $("#contentTextarea");
    const parent = $("#myShopContent1");

    $.ajax({
        url: contextPath + "/myShop/shopContentCng",
        data: { "memberNo": loginMemberNo, "inputContent": contentTextarea.val() },
        success: function(r){
            if(r > 0){

                parent.empty();
                parent.append('<div id="myShopContent2">소개글 수정</div>');
                $("#myShopContent").text( contentTextarea.val() ).css("height", "190px");
            }else{
                parent.empty();
                parent.append('<div id="myShopContent2">소개글 수정</div>');

                $("#myShopContent").text(nowContent).css("height", "190px");
            }
        },
        error:function(req, status, er){
            console.log(req.responseText);
        }
    });

    
});

/* 소개글 최대 120글자 */
$(document).on("input", "#contentTextarea", function(){
    const textLength = $(this).val().length;
    
    $("#myShopContentBtn").html("확인<br>" + textLength + "/120");

    if(textLength > textCountLimit){
        $(this).val($(this).val().substr(0, textCountLimit));
        $("#myShopContentBtn").html("확인<br>120/120");
    }
});

/* 상점 후기 최대 120글자 */
$(document).on("input", ".userPostArea > .userPostTextarea", function(){
    const textLength = $(this).val().length;
    
    $("#userPostTextareaBtn").html("확인<br>" + textLength + "/120");

    if(textLength > 0)  $("#userPostTextareaBtn").css("background", "antiquewhite");
    else                $("#userPostTextareaBtn").css("background", "rgb(250, 250, 250)");

    if(textLength > textCountLimit){
        $(this).val($(this).val().substr(0, textCountLimit));
        $("#userPostTextareaBtn").html("확인<br>120/120");
    }

});
/* 상점 후기 수정 최대 120글자 */
$(document).on("input", ".userPost > .userPostTextarea", function(){
    const textLength = $(this).val().length;
    
    $("#updateUserPostTextareaBtn").html("확인<br>" + textLength + "/120");

    if(textLength > 0)  $("#updateUserPostTextareaBtn").css("background", "antiquewhite");
    else                $("#updateUserPostTextareaBtn").css("background", "rgb(250, 250, 250)");

    if(textLength > textCountLimit){
        $(this).val($(this).val().substr(0, textCountLimit));
        $("#updateUserPostTextareaBtn").html("확인<br>120/120");
    }
});

/* 댓글 등록 이런식으로 추가 다 ajax 해야되네... */
$(document).on("click", "#userPostTextareaBtn", function(){
    const locationPost = $("#userPostTextareaBtn").parent().prev();

    if($(".userPostTextarea").length == 1){
        $.ajax({
            url: contextPath + "/myShop/insertPostScript",
            data: { "memberNo": loginMemberNo, "postScript": $(".userPostTextarea").val() },
            success: function(r){
                if(r > 0){
                    $(".userPost").remove();
                    alert("성공");
                    selectReplyList();
                }else{
                    alert("후기 등록 실패");
                    selectReplyList();
                }
            },
            error:function(req, status, er){
                console.log(req.responseText);
            }
        });
    }else{
        $.ajax({
            url: contextPath + "/myShop/insertPostScript",
            data: { "memberNo": loginMemberNo, "postScript": $(".userPostTextarea").eq(1).val() },
            success: function(r){
                if(r > 0){
                    $(".userPost").remove();
                    alert("성공");
                    selectReplyList();
                }else{
                    alert("후기 등록 실패");
                    selectReplyList();
                }
            },
            error:function(req, status, er){
                console.log(req.responseText);
            }
        });
    }
});

let backup;
function createText(j, text){
    backup = $(".userPost[id=" + j + "]").html();

    const img = $('<div class="userPostImgDiv"><img class="userPostImg" src="/anabada/resources/images/myShop/profile/캐릭터.png"></div>');
    const ta = $('<textarea class="userPostTextarea"></textarea>');
    const btn = $('<button id="updateUserPostTextareaBtn">확인<br>0/120</button>');
    $(".userPost[id=" + j + "]").empty();
    $(".userPost[id=" + j + "]").append(img, ta, btn);
    $(".userPostTextarea").eq(0).val(text);
    $("#updateUserPostTextareaBtn").html('확인<br>' + $(".userPostTextarea").eq(0).val().length + '/120').css("background", "antiquewhite");


}

let deleteIndex;
let Temp = [];
let postNum;
/* 상점 후기 수정 요소 만들기 */
$(document).on("click", ".userPostUpdate", function(){
    // $(".userPost").eq(0).parent().parent().parent().parent().parent().parent()
    const upa = $(this).parent().parent().parent(); // 상점 후기 영역 감싸고있는 div
    
    postNum = postNo[upa.attr("id")];
    const nowIndex = upa.attr("id");


    Temp[0] = $(".userPost[id=" + nowIndex + "]").html()
    Temp[1] = $(".userPost[id=" + nowIndex + "]").children().children().eq(4).text()
    
    if(flag){
        if(confirm("고?")){
            $(".userPost[id=" + deleteIndex + "]").empty();
            $(".userPost[id=" + deleteIndex + "]").append(Temp[0]);
            createText(nowIndex, Temp[1]);
            deleteIndex = nowIndex;
        }else{
            return;
        }
    }else{
        createText(nowIndex, Temp[1]);
        deleteIndex = nowIndex;
        flag = true;
    }

    console.log(postNum, nowIndex);
});

/* 상점 후기 삭제 */
$(document).on("click", ".userPostDelete", function(){
    const upa = $(this).parent().parent().parent(); // 상점 후기 영역 감싸고있는 div
    postNum = postNo[upa.attr("id")];
    const nowIndex = upa.attr("id");

    if(confirm("정말 삭제 하시겠습니까?")){

        $.ajax({
            url: contextPath + "/myShop/deletePostScript",
            data: { "postNo": postNum},
            success: function(r){
                if(r > 0){
                    $(".userPost").remove();
                    alert("상점 후기 삭제 성공");
                    selectReplyList();
                }else{
                    alert("후기 삭제 실패");
                    selectReplyList();
                }
            },
            error:function(req, status, er){
                console.log(req.responseText);
            }
        });

    }else{
        return;
    }
});

/* 상점 후기 수정 ajax */
$(document).on("click", "#updateUserPostTextareaBtn", function(){
    const locationPost = $("#updateUserPostTextareaBtn").parent().prev();

    $.ajax({
        url: contextPath + "/myShop/updatePostScript",
        data: { "postNo": postNum, "postScript": $(".userPostTextarea").eq(0).val() },
        success: function(r){
            if(r > 0){
                $(".userPost").remove();
                alert("상점 후기 수정 성공");
                selectReplyList();
            }else{
                alert("후기 수정 실패");
                selectReplyList();
            }
        },
        error:function(req, status, er){
            console.log(req.responseText);
        }
    });

    flag = false;
});


/* 신고하기 버튼 클릭 시 */
$(document).on("click", ".userPostReport", function(){

    $("#popup01").show();   //팝업 오픈
    $("body").append('<div class="backon"></div>'); //뒷배경 생성
    $("body").on("click", function(event) { 

        if(event.target.className == 'close' || event.target.className == 'backon'){

            $("#popup01").hide(); //close버튼 이거나 뒷배경 클릭시 팝업 삭제
            $(".backon").hide();
            $(".userReportTextarea").val("");
            $("#userReportTextareaBtn").html("확인<br>0/120").css("background", "#ccc");

        }
    });

});

/* 신고하기 모달창 확인버튼 120글자 제한 */
$(document).on("input", ".userReportTextarea", function(){
    const textLength = $(this).val().length;

    $("#userReportTextareaBtn").html("확인<br>" + textLength + "/120");

    if(textLength > textCountLimit){
        $(this).val($(this).val().substr(0, textCountLimit));
        $("#userReportTextareaBtn").html("확인<br>120/120");
    }

    if($(this).val().length != 0)
        $("#userReportTextareaBtn").css("background", "antiquewhite");
    else
    $("#userReportTextareaBtn").css("background", "#ccc");
});

/* 신고하기 모달창 신고 완료 */
$(".userReportTextareaBtn").on("click", function(){
    
    if($(".userReportTextarea").val().length != 0){
        alert("신고 완료!");
        $("#popup01").hide(); //close버튼 이거나 뒷배경 클릭시 팝업 삭제
        $(".backon").hide();
        $(".userReportTextarea").val("");
        $("#userReportTextareaBtn").html("확인<br>0/120").css("background", "#ccc");
    } else{
        return;
    }
});


/* 찜 삭제 버튼 클릭 시 */
$(document).on("click", ".wishDeleteBtn", function(){
    const idx = $(".wishDeleteBtn").index($(this));

    if (confirm("삭제할래요?")) {
        
        $.ajax({
            url: contextPath + "/myShop/deleteWish",
            data: { "itemNo": $(".wishContainer").eq(idx).attr("id"), "shopNo": shopNo },
            success: function(r){
                if(r > 0){
                    // $(".wishContainer").eq(idx).remove();
                    $(".wishContainer").remove();
                    alert("찜 목록 삭제 성공");
                    wishList();
                }else{
                    alert("찜 목록 삭제 실패");
                    wishList();
                }
            },
            error:function(req, status, er){
                console.log(req.responseText);
            }
        });


        (function() {
            $("#wishSpanText").text($(".wishDeleteBtn").length);
        }());
    } else {
        return;
    }

});