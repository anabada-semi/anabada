

// 제목 40글자
$(".input_title").on("input" , function(){

    let count = $(this).val().length;

    if(count >= 40){
        $("#title_count").css("color", "red");
        
        $(this).val( $(this).val().substr(0,40) );
        
        count = 40;

    }else if( count < 40){
        $("#title_count").css("color", "black");

    }
    $("#title_count").text(count);

});


// 설명 200글자
$(".input_content").on("input" , function(){

    let count = $(this).val().length;

    if(count >= 200){
        $("#content_count").css("color", "red");
        
        $(this).val( $(this).val().substr(0,200) );
        
        count = 200;

    }else if( count < 200){
        $("#content_count").css("color", "black");

    }
    $("#content_count").text(count);

});


// 가격 숫자만
$(".input_price").keyup(function(event){
    var inputVal = $(this).val();
    $(this).val(inputVal.replace(/[^0-9]/gi,''));
});


// 유효성 검사 
function saleValidate() {
        if ($(".input_title").val().trim().length == 0) {
            alert("제목을 입력해 주세요.");
            $(".input_title").focus();
            return false;
        }

        if ($(".input_content").val().trim().length == 0) {
            alert("설명을 입력해 주세요.");
            $(".input_content").focus();
            return false;
        }

        if ($(".input_price").val().trim().length == 0) {
            alert("가격을 입력해 주세요.");
            $(".input_price").focus();
            return false;

        }
    
    }

$(function() {
    $(".itemImg").on("click", function(){
        var index = $(".itemImg").index(this);

        $("[type=file").eq(index).click();

    });

});


function loadImg(value, num){

    if(value.files && value.files[0]){

        var reader = new FileReader();

        reader.readAsDataURL(value.files[0]);

        reader.onload = function(e){

           

            $(".itemImg").eq(num).children("img").attr("src",e.target.result);
            
        }
    }



}



$(".deleteBtn").on("click", function(e){
    e.stopPropagation();
    $(this).siblings("img").attr("src", "");

    const index = $(".deleteBtn").index($(this));

    $("[name=img"+index+"]").val("");
});

