// 이메일 인증 가입된 회원 검사
$("#inputEmail").on("input", function(){
    const inputEmail = $(this).val();

    $.ajax({
        url : "emailDupCheck",
        type : "GET",
        data : {"inputEmail" : inputEmail},
        success : function(result){
            
            if(result == 0){
                $("#key-Btn").prop("disabled", true);
				//$("#key-btn").attr("disabled");
                $("#checkEmail").text("가입하지 않은 이메일 입니다.").css("color", "red");
            }else{
                $("#key-Btn").prop("disabled", false);
				//$("#key-btn")
                $("#checkEmail").text("가입한 회원 이메일 입니다.").css("color", "green");
            }
            
        },
        error : function(request, status, error){

            if(request.status == 404){
                console.log("ajax 요청 주소가 올바르지 않습니다.");
                
            }else if(request.status == 500){
                console.log("서버 내부 에러 발생");
                console.log(request.responText);
            }

        },
        complete : function(){
            console.log("complete");
        }

    });

})

