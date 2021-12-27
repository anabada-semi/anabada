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

let num = 0;

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
        
/*         if(!emptyList()){
            alert("상품 이미지를 최소 한 장 넣어주세요.");
            return false;
        }
    
        if(num == 3){
            alert("상품 이미지를 최소 한 장 넣어주세요.");
			return false;
        } */
		
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




// 가격 억 단위까지만
$(".input_price").on("input" , function(){

    let count = $(this).val().length;

    if(count >= 9){
        
        $(this).val( $(this).val().substr(0,9) );
        
        count = 9;

    }else if( count < 9){

    }

});

/* function emptyList(){
    
    let num = 0;

    for(let i=0; i < 3; i++){
        if($("#imgList"+i).attr("src")==""){
            num++;
            console.log("if문 들어와?");
        }
    }

    if(num == 3){
        return false;
    } else{
        return true;
    }
} */