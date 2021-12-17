$(document).on("click",".shopNameBtn", function(){
    $("#save").empty();
    $("#save").append("<input type='text' id='userName'>");
    $("#save").append("<button class='userNameBtn'>확인</button>");
});

$(document).on("click",".userNameBtn", function(){
    const inputName = $("#userName");

    const reg = /^[\w\dㄱ-힣][\w\dㄱ-힣-_]{3,12}$/;

    if(reg.test(inputName.val())){
        $("#userName123").text("");
        $("#userName123").text(inputName.val());
        $("#save").empty();
        $("#save").append("<span id='userNameCng'>" + inputName.val() + "</span>");
        $("#save").append("<button class='shopNameBtn'>상점명 수정</button>");
    }else{
        alert("4글자 이상");
    }
});

$(document).on("click", "#myShopContent2", function(){

    
    const parent = $("#myShopContent1");
    parent.empty();
    parent.append("<textarea name='' id='contentTextarea' cols='30' rows='10' placeholder='소개글을 입력해 주세요.' style='resize: none; border:0.3px solid #ccc; width: 82%; height: 149px;'></textarea>");
    
    $("#contentTextarea").val( $("#myShopContent").text() );
    $("#myShopContent").text("");
    
    parent.append("<button id='myShopContentBtn' style='float: right;'>확인</button>");

});

$(document).on("click", "#myShopContentBtn", function(){
    const contentTextarea = $("#contentTextarea");

    const parent = $("#myShopContent1");
    parent.empty();
    parent.append('<div id="myShopContent2" style="padding: 0px 10px 0px 10px; font-weight: lighter; border: 0.3px solid #ccc; font-size: 12px; display: inline-block;">소개글 수정</div>');

    $("#myShopContent").text(contentTextarea.val() );
});
