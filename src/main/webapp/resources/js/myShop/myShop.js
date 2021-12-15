$(".btn").on("click", function(){
    $(".btn").removeClass("active");
    $(this).addClass("active");

    $("#changeDiv").empty();

    // switch($(this).index()){
    //     case 0: 
    //         const div1 = document.createElement("div");
    //         div1.setAttribute("id", "div");

    //         const div2 = document.createElement("div");
    //         div2.setAttribute("style", "width:50%");
    //         div2.innerText = "상품";

    //         const span = document.createElement("span");
    //         span.innerText = " 0";

    //         const div3 = document.createElement("div");
    //         div3.setAttribute("style", "width:50%");

    //         const sel = document.createElement("select");
    //         sel.setAttribute("style", "width: 150px; text-align-last: center; float:right; height: 25px; border: 0.3px solid #ccc");
    //         const opt = document.createElement("option");
    //         opt.innerText = "전체";

    //         const hr = document.createElement("hr");



    //         const div4 = document.createElement("div");
    //         div4.innerHTML = "<span>등록된 상품이 없습니다.</span>";


    //         div2.append(span);
    //         sel.append(opt);
    //         div3.append(sel);
    //         div1.append(div2);
    //         div1.append(div3);

    //         $("#changeDiv").append(div1);
    //         $("#changeDiv").append(hr);
    //         $("#changeDiv").append(div4);

    //         break;

    //     case 1: 
    //         break;

    //     case 2: 
    //         break;

    //     case 3: 
    //         break;

    //     case 4: 
    //         break;

    //     default:
    // }

});

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

