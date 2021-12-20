// 각 입력 값이 유효성 검사를 진행했는지 기록할 객체
const signUpCheckObj = {
    "memberId" : false,
    "memberNm" : false,
    "memberEmail" : false,
    "pwd1" : false,
    "pwd2" : false,
    "memberPhone3" : false

}


function validate(){

    for(key in signUpCheckObj){
        if( !signUpCheckObj[key] ){

            let message;
            
            switch(key){
            case "memberId" : message = "아이디가 유효하지 않습니다."; break;
            case "memberNm" : message = "이름이 유효하지 않습니다."; break;
            case "memberEmail" : message = "이메일이 유효하지 않습니다."; break;
            case "pwd1" : message = "비밀번호가 유효하지 않습니다."; break;
            case "pwd2" : message = "비밀번호가 일치하지 않습니다."; break;
            case "memberPhone3" : message = "전화번호가 유효하지 않습니다."; break;
            }

            alert(message);

            document.getElementById(key).focus();

            return false;
        }

    }

}

// ID 유효성 검사
document.getElementById("memberId").addEventListener("input", function(e){

    const inputId = this.value;
    const regExp = /^[a-zA-Z\d]{5,20}$/;
    
    const checkId = document.getElementById("checkId");

    // 유효성 검사
    if(inputId.length == 0){
        $(checkId).text("");
        signUpCheckObj.memberId = false;

    }else if( regExp.test(inputId)){

        $.ajax({
            url : "idDupCheck",
            data : {"inputId" : inputId},
            type : "GET",                
            success : function(result){

                if(result == 0){
                    checkId.innerText = "사용 가능";
                    checkId.style.color = "green";
                    signUpCheckObj.memberId = true;

                }else{
                    checkId.innerText = "중복";
                    checkId.style.color = "red";
                    signUpCheckObj.memberId = false;

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

    }else{
        $(checkId).text("5글자 이상").css("color", "red");
        signUpCheckObj.memberId = false;
    }

})


// 이메일 유효성 검사
$("#memberEmail").on("input", function(){
    const inputEmail = $(this).val();
    const regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;

    if(inputEmail.length == 0){
        $("#checkEmail").text("");
        signUpCheckObj.memberEmail = false;
    }else if(regExp.test(inputEmail)){

        $.ajax({
            url : "emailDupCheck",
            type : "GET",
            data : {"inputEmail" : inputEmail},
            success : function(result){
                
                if(result == 0){
                    $("#checkEmail").text("사용 가능").css("color", "green");
                    signUpCheckObj.memberEmail = true;
                }else{
                    $("#checkEmail").text("중복").css("color", "red");
                    signUpCheckObj.memberEmail = false;
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

    }else{
        $("#checkEmail").text("");
        signUpCheckObj.memberEmail = false;
    }
})


// 이름 유효성 검사
$("#memberNm").on("input", function(){

    const inputName = $(this).val();

    const regExp = /^[가-힣]{2,6}$/;

    if(inputName.length == 0){
        $("#checkNm").text("");
        signUpCheckObj.memberNm = false;
    }else if(regExp.test(inputName)){
		$("#checkNm").text("");
        signUpCheckObj.memberNm = true;
    }else{
        $("#checkNm").text("사용 불가").css("color", "red");
        signUpCheckObj.memberNm = false;
    }

})



// 비밀번호 유효성 검사
document.getElementById("pwd1").addEventListener("input", (e)=> {
    const inputPw = e.target.value;
    const regExp = /^[a-zA-z\d\!\@\#\-\_]{6,20}$/;
    const checkPw1 = document.getElementById("checkPw1");

    if(inputPw.length==0){
        checkPw1.innerText = "";
        signUpCheckObj.pwd1 = false;
    }else if(regExp.test(inputPw)){
        checkPw1.innerText = "사용 가능";
        checkPw1.style.color = "green";
        signUpCheckObj.pwd1 = true;
    }else{
        checkPw1.innerText = "사용 불가";
        checkPw1.style.color = "red";
        signUpCheckObj.pwd1 = false;
    }

})


// 비밀번호 확인 유효성 검사
$("#pwd2, #pwd1").on("input", function(e){
    const pwd1 = document.getElementById("pwd1").value;
    const pwd2 = document.getElementById("pwd2").value;

    const checkPw2 = document.getElementById("checkPw2");

    if(pwd2.trim().length == 0){
        checkPw2.innerText = "";
        signUpCheckObj.pwd2 = false;
    }else if(pwd1 == pwd2){
        checkPw2.innerText = "일치";
        checkPw2.style.color = "green";
        signUpCheckObj.pwd2 = true;
    }else{
        checkPw2.innerText = "불일치";
        checkPw2.style.color = "red";
        signUpCheckObj.pwd2 = false;
    }

})


// 전화번호 글자 수 제한 + 유효성 검사
$(".phone-length").on("input", function(){

    if( $(this).val().length > 4){

        const num = $(this).val().slice(0,4);

        $(this).val(num);

    }

    const inputPhone2 = document.getElementById("memberPhone2").value;
    const inputPhone3 = document.getElementById("memberPhone3").value;

    const regExp2 = /^\d{3,4}$/;
    const regExp3 = /^\d{4}$/;

    if(inputPhone2.length == 0 && inputPhone3.length == 0 ){
        signUpCheckObj.memberPhone3 = false;
    }else if(regExp2.test(inputPhone2) && regExp3.test(inputPhone3)){
        signUpCheckObj.memberPhone3 = true;
    }else{
        signUpCheckObj.memberPhone3 = false;
    }

})