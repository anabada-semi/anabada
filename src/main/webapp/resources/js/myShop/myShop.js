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
                },
                error:function(req,status,er){
                    console.log(req.responseText);
                }
            }); break;
        default:
    }
});

// 댓글 목록 조회
function selectReplyList() {
    const locationPost = $("#userPostTextareaBtn").parent().prev();

    $.ajax({
        url: contextPath + "/myShop/selectPostScript",
        data: { "memberNo": loginMemberNo },
        dataType: "JSON",
        success: function (r) {

            $.each(r, function (index, post) {

                const upr = $("<div class='userPost-report'>");
                upr.text("신고하기");
                const upc = $("<div class='userPost-content'>");
                upc.text(post.postScriptCheck).append(upr);
                

                const ups = $("<div class='userPost-shop'>");
                ups.text("이동").append(upc);

                const upst = $("<div class='userPost-star'>");
                upst.text("별사진");

                const upn = $("<div class='userPost-name'>");
                upn.text(post.shopName).append(upst, ups);
                
                const upa = $("<div class='userPost-area'>");
                upa.append(upn);

                const upi = $("<div class='userPostImgDiv'>");
                upi.append('<img class="userPostImg" src="/anabada/resources/images/myShop/profile/캐릭터.png">');

                const up = $("<div class='userPost'>");

                up.append(upi, upa);

                locationPost.after(up);
                
                const upd = $('<button class="userPostDelete">삭제</button>');
                const upu = $('<button class="userPostUpdate">수정</button>');
            
                $("#userPostTextarea").val("");
                
                if (post.memberNo == loginMemberNo) {
                    upr.append(upd, upu);
                }
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
                
                const table = $("<table>");
                const tr = $("<tr class='itemTr'>");
                const td = $("<td class='itemTd'>");
                const itemImg = $('<img class="itemImg" src="/anabada/resources/images/myShop/itemList/신발.jpg">');
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
$(document).on("input", "#userPostTextarea", function(){
    const textLength = $(this).val().length;
    
    $("#userPostTextareaBtn").html("확인<br>" + textLength + "/120");

    if(textLength > textCountLimit){
        $(this).val($(this).val().substr(0, textCountLimit));
        $("#userPostTextareaBtn").html("확인<br>120/120");
    }
});

/* 댓글 등록 이런식으로 추가 다 ajax 해야되네... */
$(document).on("click", "#userPostTextareaBtn", function(){
    const locationPost = $("#userPostTextareaBtn").parent().prev();

    if($("#userPostTextarea").val().trim().length > 4){
        $.ajax({
            url: contextPath + "/myShop/insertPostScript",
            data: { "memberNo": loginMemberNo, "postScript": $("#userPostTextarea").val() },
            success: function(r){
                if(r > 0){
                    $(".userPost").remove();
                    alert("성공");
                    selectReplyList();
                }else{
                    alert("후기 등록 실패  이유는 나도 모름");
                    selectReplyList();
                }
            },
            error:function(req, status, er){
                console.log(req.responseText);
            }
        });

        
    }else{
        alert("최소 5글자 이상 입력해 주십시오.");
    }


});
