// 내 상점 페이지 
$(".btn").on("click", function(){
	// console.log($(this).index());	
    const len = $(".btn").length;

    $(".btn").removeClass("active");

    $(this).addClass("active");

    $("#changeDiv").empty();
    
    if(len == 4){
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
                }); 
            break;

            case 1: 
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
                }); 
            break;

            case 2: 
                $.ajax({
                    url: contextPath + "/myShop/buyList",
                    success: function(r){
                        $("#changeDiv").html(r);
                        buyPage();
                    },
                    error:function(req,status,er){
                        console.log(req.responseText);
                    }
                }); 
            break;

            case 3: 
                $.ajax({
                    url: contextPath + "/myShop/sellList",
                    success: function(r){
                        $("#changeDiv").html(r);
                        sellPage();
                    },
                    error:function(req,status,er){
                        console.log(req.responseText);
                    }
                }); 
            break;

            default:
        }

    }else{
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
                }); 
            break;

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
                }); 
            break;

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
                }); 
            break;

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
                }); 
            break;

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
                }); 
            break;

            default:
        }
    }
});

let postNo = [];
// 상점 후기 목록 조회
function selectReplyList() {
    const locationPost = $("#userPostTextareaBtn").parent().prev();

    $.ajax({

        url: contextPath + "/myShop/selectPostScript",
        data: { "memberNo": loginMemberNo },
        dataType: "JSON",
        success: function (r) {

            if(r == ""){
                // 상점후기 없을 시
                $("#postScriptTextDiv").text("이 상점에 첫 후기를 작성해 보세요!");
            }else{

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
                    upc.html(post.postScriptCheck);
                    
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
            }
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
    let itemPk = 0;

    $.ajax({
        url: contextPath + "/myShop/selectItemList",
        data: { "shopNo": shopNo },
        dataType: "JSON",
        success: function (r) {
            if(r == ""){
                const div = $("<div>");
                const span = $("<span>등록된 상품이 없습니다.</span>");

                div.append(span);

                $(".addItem").append(div);

            }else{
            
                $.each(r, function (index, item) {

                    // if(itemPk == item.itemNo){
                    //     return;
                    // }
                    // itemPk = item.itemNo;

                    const sel = $('<select class="itemOp">');
                    const selling = $('<option value="onSale">판매중</option>');
                    const soldOut = $('<option value="soldOut">판매 완료</option>');

                    sel.append(selling, soldOut);

                    const tr = $("<tr class='itemTr'>");
                    const td = $("<td class='itemTd' id='" + item.itemNo + "'>");

                    let imgSrc;
                    if(item.itemImgName != null)    imgSrc = contextPath + item.itemPath + item.itemImgName;
                    else                            imgSrc = contextPath + '/resources/images/myShop/profile/바다.jpg';
                    itemImg = $('<a href="' + contextPath + '/detail/select?no=' + item.itemNo + '"><img class="itemImg" src="' + imgSrc + '">');

                    const itD = $('<div class="itemTextDiv">');

                    let itemName = item.itemName;
                    let it1;
                    if(itemName.length > 10){
                        it1 = $('<div class="itemText1">' + itemName.substring(0, 13) + "..." + '<div>');
                    }else{
                        it1 = $('<div class="itemText1">' + itemName + '<div>');
                    }

                    // const it1 = $('<div class="itemText1">' + ssitemName + '<div>');
                    const it2 = $('<div class="itemText2">' + parseInt(item.itemPrice).toLocaleString() + '원<div>');
                    const it3 = $('<div class="itemText3">' + item.uploadDate + '<div>');

                    itD.append(it1, it2, it3);

                    /* 로그인멤버넘버와 아이템에 저장된 멤버넘버와 같으면 상품 정보 변경 가능 */
                    if(item.memberNo == loginMemberNo){
                        td.append(sel, itemImg, itD);
                    } else {
                        td.append(itemImg, itD);
                    }

                    tr.append(td);
                    $(".itemTr").eq(Math.floor(index/4)).append(td);

                    if(index % 4 == 0)
                        $(".addItem").append(tr);

                });
            }
            
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
    let itemPk = 0;
    const abc = $("#wishSpanText").parent().next();

    $.ajax({
        url: contextPath + "/myShop/wishItemList",
        data: { "shopNo": shopNo },
        dataType: "JSON",
        success: function (r) {

            if(r == ""){

                const div = $("<div>");
                const span = $("<span>찜한 상품이 없습니다.</span>");

                div.append(span);

                $("#changeDiv > hr").after(div);

            }else{

                $.each(r, function (index, wish) {
                    console.log(wish.itemName.length);
                    
                    // if(itemPk == wish.itemNo){
                    //     return;
                    // }
                    // itemPk = wish.itemNo;

                    wishNo[index] = wish.itemNo;

                    const wc = $('<div class="wishContainer" id="' + wishNo[index] + '">');

                    let imgSrc;
                    if(wish.imgName != null)    imgSrc = contextPath + wish.imgPath + wish.imgName;
                    else                        imgSrc = contextPath + '/resources/images/myShop/profile/바다.jpg';
                    const wi = $('<a href="' + contextPath + '/detail/select?no=' + wish.itemNo + '"><img class="wishImg" src="' + imgSrc + '">');


                    const wtd = $('<div class="wishTextDiv">');
                    const wTitle = $('<div class="wishTitle">');

                    let itemName = wish.itemName;
                    if(itemName.length > 8){
                        wTitle.text(itemName.substr(0,9) + "...");
                    }else{
                        wTitle.text(itemName);
                    }

                    const wdBtn = $('<button class="wishDeleteBtn">');
                    wdBtn.text('찜 삭제');

                    const wt1 = $('<div class="wishText1">');
                    wt1.text(parseInt(wish.itemPrice).toLocaleString() + "원");
                    

                    const wt2 = $('<div class="wishText2">');
                    wt2.text(wish.uploadDate);

                    wTitle.append(wdBtn);
                    wtd.append(wTitle, wt1, wt2);
                    wc.append(wi, wtd);

                    abc.after(wc);

                });
            }

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
    let itemPk = 0;
    $.ajax({

        url: contextPath + "/myShop/buyItemList",
        data: { "shopNo": shopNo },
        dataType: "JSON",
        success: function (result) {

            if(result == ""){

                const div = $("<div>");
                const span = $("<span>구매한 상품이 없습니다.</span>");

                div.append(span);

                $(".addBuyList").append(div);

            }else{

                $.each(result, function (index, buyList) {

                    // if(itemPk == buyList.itemNo){
                    //     return;
                    // }
                    // itemPk = buyList.itemNo;

                    const tr = $("<tr class='buyTr'>");
                    const td = $("<td class='buyTd'>");
                    const bid = $('<div class="buyImgDiv">');
                    
                    let imgSrc;
                    if(buyList.itemImgName != null)    imgSrc = contextPath + buyList.itemImgPath + buyList.itemImgName;
                    else                            imgSrc = contextPath + '/resources/images/myShop/profile/바다.jpg';
                    itemImg = $('<a href="' + contextPath + '/detail/select?no=' + buyList.itemNo + '"><img class="buyImg" src="' + imgSrc + '">');
                    
                    const bis = $('<span class="buyImgSpan"> 구매 완료 </span>');
                    bid.append(bis, itemImg);

                    const btd = $('<div class="buyTextDiv">');
                    const bt1 = $('<div class="buyText1">');

                    let itemName = buyList.itemName;
                    if(itemName.length > 10){
                        bt1.append(itemName.substring(0, 13) + "...");
                    }else{
                        bt1.append(itemName);
                    }

                    const bt2 = $('<div class="buyText2">');
                    bt2.append(parseInt(buyList.itemPrice).toLocaleString() + "원");
                    

                    const bt3 = $('<div class="buyText3">');
                    bt3.append(buyList.uploadDate);

                    btd.append(bt1, bt2 ,bt3);

                    td.append(bid, btd);

                    tr.append(td);
                    $(".buyTr").eq(Math.floor(index/4)).append(td);

                    if(index % 4 == 0)
                        $(".addBuyList").append(tr);

                });
            }

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

/* 판매 완료 목록 조회 페이지 */
function sellPage(){
    let itemPk = 0;
    $.ajax({
        url: contextPath + "/myShop/sellItemList",
        data: { "shopNo": shopNo },
        dataType: "JSON",
        success: function (result) {

            if(result == ""){

                const div = $("<div>");
                const span = $("<span>판매한 상품이 없습니다.</span>");

                div.append(span);

                $(".addSellList").append(div);

            }else{
                    
                $.each(result, function (index, sellList) {

                    // if(itemPk == sellList.itemNo){
                    //     return;
                    // }
                    // itemPk = sellList.itemNo;

                    const sel = $('<select class="sellOp">');
                    const soldOut = $('<option value="soldOut">판매 완료</option>');
                    const selling = $('<option value="onSale">판매중</option>');
                    sel.append(soldOut, selling);

                    const tr = $("<tr class='sellTr'>");
                    const td = $("<td class='sellTd' id='" + sellList.itemNo + "'>");
                    const sid = $('<div class="sellImgDiv">');
                    
                    let imgSrc;
                    if(sellList.itemImgName != null)    imgSrc = contextPath + sellList.itemPath + sellList.itemImgName;
                    else                            imgSrc = contextPath + '/resources/images/myShop/profile/바다.jpg';
                    itemImg = $('<a href="' + contextPath + '/detail/select?no=' + sellList.itemNo + '"><img class="sellImg" src="' + imgSrc + '">');
                    
                    const sis = $('<span class="sellImgSpan"> 판매 완료 </span>');
                    sid.append(sis, itemImg);

                    const std = $('<div class="sellTextDiv">');
                    const st1 = $('<div class="sellText1">');
                    st1.append(sellList.itemName);

                    const st2 = $('<div class="sellText2">');
                    st2.append(parseInt(sellList.itemPrice).toLocaleString() + "원");
                    

                    const st3 = $('<div class="sellText3">');
                    st3.append(sellList.uploadDate);

                    std.append(st1, st2 ,st3);


                    if(sellList.memberNo == loginMemberNo){
                        td.append(sel, sid, std);
                    } else {
                        td.append(sid, std);
                    }

                    tr.append(td);
                    $(".sellTr").eq(Math.floor(index/4)).append(td);

                    if(index % 4 == 0)
                        $(".addSellList").append(tr);

                });

            }

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



const textCountLimit = 70;

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

    if(inputName.val().trim().length > 1){

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
        alert("2글자 이상");
    }
});

/* 소개글 변경 */
$(document).on("click", "#myShopContent2", function(){

    const parent = $("#myShopContent1");
    parent.empty();
    parent.append("<textarea name='' id='contentTextarea'></textarea>");
    
	let myShopContent = $("#myShopContent").html();
	myShopContent = myShopContent.replace(/&amp;/g, "&");
	myShopContent = myShopContent.replace(/&lt;/g, "<");
	myShopContent = myShopContent.replace(/&gt;/g, ">");
	myShopContent = myShopContent.replace(/&quot;/g, "\"");
	myShopContent = myShopContent.replaceAll(/<br>/g, '\r\n');

    $("#contentTextarea").val( myShopContent );

    const textLength = $("#contentTextarea").val().length;

    $("#myShopContent").text("").css("height", "0px");
    
    parent.append("<button id='myShopContentBtn'>확인<br>" + textLength + "/70</button>");

});

/* 소개글 변경 후 확인 버튼 */
$(document).on("click", "#myShopContentBtn", function(){
	const nowContent = $("#myShopContent").html();
    const contentTextarea = $("#contentTextarea");
    const parent = $("#myShopContent1");

	let main = $("#contentTextarea").val();
	main = main.replace(/&/g, "&amp;");
	main = main.replace(/</g, "&lt;");
	main = main.replace(/>/g, "&gt;");
	main = main.replace(/\"/g, "&quot;");
	main = main.replaceAll(/(\n|\r\n)/g, "<br>");

    $.ajax({
        url: contextPath + "/myShop/shopContentCng",
        data: { "memberNo": loginMemberNo, "inputContent": main },
        success: function(r){
            if(r > 0){
	
                parent.empty();
                parent.append('<div id="myShopContent2">소개글 수정</div>');

                $("#myShopContent").html( main ).css("height", "190px");

            }else{

                parent.empty();
                parent.append('<div id="myShopContent2">소개글 수정</div>');

                $("#myShopContent").text( nowContent ).css("height", "190px");

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
    
    $("#myShopContentBtn").html("확인<br>" + textLength + "/70");

    if(textLength > textCountLimit){
        $(this).val($(this).val().substr(0, textCountLimit));
        $("#myShopContentBtn").html("확인<br>70/70");
    }
});


/* 상점 후기 최대 70글자 */
$(document).on("input", ".userPostArea > .userPostTextarea", function(){
    const textLength = $(this).val().length;
    
    $("#userPostTextareaBtn").html("확인<br>" + textLength + "/70");

    if(textLength > 0)  $("#userPostTextareaBtn").css("background", "antiquewhite");
    else                $("#userPostTextareaBtn").css("background", "rgb(250, 250, 250)");

    if(textLength > textCountLimit){
        $(this).val($(this).val().substr(0, textCountLimit));
        $("#userPostTextareaBtn").html("확인<br>70/70");
    }
});


/* 상점 후기 수정 최대 70글자 */
$(document).on("input", ".userPost > .userPostTextarea", function(){
    const textLength = $(this).val().length;
    
    $("#updateUserPostTextareaBtn").html("확인<br>" + textLength + "/70");

    if(textLength > 0)  $("#updateUserPostTextareaBtn").css("background", "antiquewhite");
    else                $("#updateUserPostTextareaBtn").css("background", "rgb(250, 250, 250)");

    if(textLength > textCountLimit){
        $(this).val($(this).val().substr(0, textCountLimit));
        $("#updateUserPostTextareaBtn").html("확인<br>70/70");
    }
});


/* 상점 후기 등록 이런식으로 추가 다 ajax 해야되네... */
$(document).on("click", "#userPostTextareaBtn", function(){
    const locationPost = $("#userPostTextareaBtn").parent().prev();

    if(shopNo == loginMemberNo){
        alert("자신의 상점에서는 후기 작성이 불가능합니다.");
        $(".userPostTextarea").val("");
        return;
    }

	let main = [];
	main[0] = $(".userPostTextarea").val();
	
	main[0] = main[0].replace(/&/g, "&amp;");
	main[0] = main[0].replace(/</g, "&lt;");
	main[0] = main[0].replace(/>/g, "&gt;");
	main[0] = main[0].replace(/\"/g, "&quot;");
	

    if($(".userPostTextarea").length == 1){
        $.ajax({
            url: contextPath + "/myShop/insertPostScript",
            data: { "memberNo": loginMemberNo, "postScript": main[0] },
            success: function(r){
                if(r > 0){
                    $(".userPost").remove();
                    
                    $("#postScriptTextDiv").html('상점 후기<span id="postScriptText">1</span>');
                    $("#userPostTextareaBtn").html("확인<br>0/70").css("background", "rgb(250, 250, 250)");
                    alert("성공");
                    selectReplyList();
                }else{
                    alert("후기 등록 실패");
                }

            },
            error:function(req, status, er){
                console.log(req.responseText);
            }
        });
    }else{
		main[1] = $(".userPostTextarea").eq(1).val();
		main[1] = main[1].replace(/&/g, "&amp;");
		main[1] = main[1].replace(/</g, "&lt;");
		main[1] = main[1].replace(/>/g, "&gt;");
		main[1] = main[1].replace(/\"/g, "&quot;");
		
        $.ajax({
            url: contextPath + "/myShop/insertPostScript",
            data: { "memberNo": loginMemberNo, "postScript": main[1] },
            success: function(r){
                if(r > 0){
                    $(".userPost").remove();
                    alert("성공");
                    selectReplyList();
                }else{
                    alert("후기 등록 실패");
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
    const btn = $('<button id="updateUserPostTextareaBtn">확인<br>0/70</button>');

    $(".userPost[id=" + j + "]").empty();
    $(".userPost[id=" + j + "]").append(img, ta, btn);
    $(".userPostTextarea").eq(0).val(text);
    $("#updateUserPostTextareaBtn").html('확인<br>' + $(".userPostTextarea").eq(0).val().length + '/70').css("background", "antiquewhite");

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
    Temp[1] = $(".userPost[id=" + nowIndex + "]").children().children().eq(4).html()
    
	Temp[1] = Temp[1].replace(/&amp;/g, "&");
    Temp[1] = Temp[1].replace(/&lt;/g, "<");
    Temp[1] = Temp[1].replace(/&gt;/g, ">");
    Temp[1] = Temp[1].replace(/&quot;/g, "\"");
    /*Temp[1] = Temp[1].replace(/<br>/g, "\n");*/

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

    // console.log(postNum, nowIndex);
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

	let main = [];
	main[0] = $(".userPostTextarea").eq(0).val();
	
	main[0] = main[0].replace(/&/g, "&amp;");
	main[0] = main[0].replace(/</g, "&lt;");
	main[0] = main[0].replace(/>/g, "&gt;");
	main[0] = main[0].replace(/\"/g, "&quot;");

    $.ajax({
        url: contextPath + "/myShop/updatePostScript",
        data: { "postNo": postNum, "postScript": main[0] },
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
            $("#userReportTextareaBtn").html("확인<br>0/70").css("background", "#ccc");

        }
    });

});

/* 신고하기 모달창 확인버튼 120글자 제한 */
$(document).on("input", ".userReportTextarea", function(){
    const textLength = $(this).val().length;

    $("#userReportTextareaBtn").html("확인<br>" + textLength + "/70");

    if(textLength > textCountLimit){
        $(this).val($(this).val().substr(0, textCountLimit));
        $("#userReportTextareaBtn").html("확인<br>70/70");
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
        $("#userReportTextareaBtn").html("확인<br>0/70").css("background", "#ccc");
    } else{
        return;
    }
});


/* 찜 삭제 버튼 클릭 시 */
$(document).on("click", ".wishDeleteBtn", function(){
    const idx = $(".wishDeleteBtn").index($(this));

    if (confirm("찜 목록에서 삭제하시겠습니까?")) {
        
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


/* 판매중인 상품 내역 페이지 판매완료로 변경 시 */
$(document).on("change", ".itemOp", function(){

    const idx = $(".itemOp").index($(this));

    const itemNo = $(this).parent().attr("id");

    if($(this).val() == 'soldOut'){// 판매완료로 변경 시
        
        $.ajax({
            url: contextPath + "/myShop/soldOut",
            data: { "itemNo": itemNo, "shopNo": shopNo },
            success: function(r){
                if(r > 0){
                    $(".itemTd").remove();
                    selectitemList();

                    // $(".itemTd").eq(idx).remove();
                }else{
                    selectitemList();
                }
            },
            error:function(req, status, er){
                console.log(req.responseText);
            }

        });
    }
    
});

/* 판매완료 상품 내역 페이지 판매중으로 변경 시 */
$(document).on("change", ".sellOp", function(){

    const idx = $(".sellOp").index($(this));

    const itemNo = $(this).parent().attr("id");

    if($(this).val() == 'onSale'){// 판매완료로 변경 시

        $.ajax({
            url: contextPath + "/myShop/onSale",
            data: { "itemNo": itemNo, "shopNo": shopNo },
            success: function(r){

                if(r > 0){
                    $(".sellTd").remove();
                    sellPage();

                    // $(".sellTd").eq(idx).remove();
                }else{
                    sellPage();
                }
            },
            error:function(req, status, er){
                console.log(req.responseText);
            }
        });
    }
    
});


let myIdx = 0;
$(document).on("click", ".report", function(){
    const idx = $(".report").index($(this));

    if(myIdx != idx){
        $("#userReportTextareaBtn").html("확인<br>0/70").css("background", "#ccc");
        $(".userReportTextarea").val("");
    }
    myIdx = idx;

    $(".userReportTextarea").css("display", "none");
    $(".userReportTextarea").eq(idx).css("display", "block");
    $(".userReportTextarea").eq(idx).focus();
});