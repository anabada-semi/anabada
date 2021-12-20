/* 내 상점 페이지 */
$(".btn").on("click", function(){
		
    $(".btn").removeClass("active");
    $(this).addClass("active");

    $("#changeDiv").empty();
    
    switch($(this).index()){
        case 0: 
            $.ajax({
                url: "myShop/itemList",
                success: function(r){
                    $("#changeDiv").append(r);
                },
                error:function(req,status,er){
                    console.log(req.responseText);
                }
            }); break;

        case 1: 
            $.ajax({
                url: "myShop/wishList",
                success: function(r){
                    $("#changeDiv").append(r);
                },
                error:function(req,status,er){
                    console.log(req.responseText);
                }
            }); break;

        case 2: 
            $.ajax({
                url: "myShop/postScript",
                success: function(r){
                    $("#changeDiv").append(r);
                },
                error:function(req,status,er){
                    console.log(req.responseText);
                }
            }); break;

        case 3: 
            $.ajax({
                url: "myShop/buyList",
                success: function(r){
                    $("#changeDiv").html(r);
                },
                error:function(req,status,er){
                    console.log(req.responseText);
                }
            }); break;

        case 4: 
            $.ajax({
                url: "myShop/sellList",
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

    // ajax를 이용해 비동기로 댓글 목록 조회 및 출력
    $.ajax({
        url: contextPath + "/myShop/postScript",
        data: { "postScriptNo": boardNo },
        dataType: "JSON",
        success: function (r) {
            console.log(r);

            $("#replyListArea").empty();

            $.each(r, function (index, reply) {
                console.log(reply.replyContent);

                // const li = $("<li>").addClass("reply-row");
                const li = $('<li class="reply-row">');
                const div = $('<div>');
                const rWriter = $('<p class="rWriter">').text(reply.memberName);
                const rDate = $('<p class="rDate">').text(reply.replyCreateDate);

                // div에 자식으로 rWriter, rDate 추가
                div.append(rWriter, rDate);

                // 댓글 내용
                const rContent = $('<p class="rContent">').html(reply.replyContent);

                li.append(div, rContent);

                if (reply.memberNo == loginMemberNo) {
                    const replyBtnArea = $('<div class="replyBtnArea">');
                    const showUpdate = $("<button>").addClass("btn btn-primary btn-sm ml-1").text("수정");
                    showUpdate.attr("onclick", "showUpdateReply(" + reply.replyNo + ", this)");

                    const deleteReply = $("<button>").addClass("btn btn-primary btn-sm ml-1").text('삭제');
                    deleteReply.attr("onclick", "deleteReply(" + reply.replyNo + ")");

                    replyBtnArea.append(showUpdate, deleteReply);

                    li.append(replyBtnArea);
                }

                $("#replyListArea").append(li);
            });

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
            url:"myShop/shopNameCng",
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

    $("#myShopContent").text("");
    
    parent.append("<button id='myShopContentBtn'>확인<br>" + textLength + "/120</button>");

});

const nowContent = $("#myShopContent").val();
/* 소개글 변경 후 확인 버튼 */
$(document).on("click", "#myShopContentBtn", function(){
    const contentTextarea = $("#contentTextarea");
    const parent = $("#myShopContent1");

    $.ajax({
        url:"myShop/shopContentCng",
        data: { "memberNo": loginMemberNo, "inputContent": contentTextarea.val() },
        success: function(r){
            if(r > 0){
                parent.empty();
                parent.append('<div id="myShopContent2">소개글 수정</div>');
                $("#myShopContent").text(contentTextarea.val() );
            }else{
                parent.empty();
                parent.append('<div id="myShopContent2">소개글 수정</div>');

                $("#myShopContent").text(nowContent);
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
    const locationPost = $(".userPost").eq($(".userPost").length - 2).next();

    locationPost.after('<div class="userPost"><div class="userPostImgDiv"><img class="userPostImg" src="/anabada/resources/images/myShop/profile/캐릭터.png">');
	$(".userPost").eq($(".userPost").length - 2).append('<div class="userPost-area"><div class="userPost-name">유저사<div class="userPost-star">별사진');
	$(".userPost-star").eq($(".userPost-star").length - 1).after('<div class="userPost-shop">이동<div class="userPost-content">' + $("#userPostTextarea").val() + '<div class="userPost-report">신고하기')
	$(".userPost").eq($(".userPost").length - 2).after("<hr>");

    $("#userPostTextarea").val("");

});