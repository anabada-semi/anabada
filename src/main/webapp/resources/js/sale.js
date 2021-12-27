// 이미지 등록 유무 검사용 변수
let imgInputCount = 0;

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

		/*상품 이미지 최소 1장 검사
		for(let i = 0; i < 3; i++){
			let flag = false;
		    let count = $(".itemImg > img").eq(i).attr("src").length;

		   if(count != 0)	flag = true;
		}
		
		if(!flag){
			alert("상품 이미지를 최소 한 장 넣어주세요.");
			return false;
		}*/
		
    
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
			
			
			
			// 상품 이미지 추가 Count + 1
			imgInputCount = imgInputCount + 1;
            
        }
    }
}



$(".deleteBtn").on("click", function(e){
    e.stopPropagation();
    $(this).siblings("img").attr("src", "");

    const index = $(".deleteBtn").index($(this));

    $("[name=img"+index+"]").val("");

	// 삭제된 이미의 인덱스를 저장하는 input type="hidden" 태그 추가
	const input = $("<input type='hidden' name='deleteNo'>").val(index);
	$("#guide").append(input);
	
	// 상품 이미지 삭제 Count - 1
	imgInputCount = imgInputCount - 1;
	
});




// 가격 백만 단위까지만
$(".input_price").on("input" , function(){

    let count = $(this).val().length;

    if(count >= 7){
        
        $(this).val( $(this).val().substr(0,7) );
        
        count = 7;

    }else if( count < 7){

    }

});