// 각 입력 값이 유효성 검사를 진행했는지 기록할 객체
const updateCheckObj = {
    "memberNm" : false,
    "memberEmail" : false,
    "pwd1" : false,
    "pwd2" : false,
    "memberPhone3" : false

}


function validate(){

    for(key in updateCheckObj){
        if( !updateCheckObj[key] ){

            let message;
            
            switch(key){
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


// 이메일 유효성 검사 + 기존 이메일 중복 검사 x

const existingEmail = $("#memberEmail").val();

$("#memberEmail").on("change", function(){
    const inputEmail = $(this).val();
    const regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;

	if(inputEmail == existingEmail){
		updateCheckObj.memberEmail = true;

    }else if(inputEmail.length == 0){
        $("#checkEmail").text("");
        updateCheckObj.memberEmail = false;
    }else if(regExp.test(inputEmail)){

        $.ajax({
            url : "emailDupCheck",
            type : "GET",
            data : {"inputEmail" : inputEmail},
            success : function(result){
                
                if(result == 0){
                    $("#checkEmail").text("사용 가능").css("color", "green");
                    updateCheckObj.memberEmail = true;
                }else{
                    $("#checkEmail").text("중복").css("color", "red");
                    updateCheckObj.memberEmail = false;
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
        updateCheckObj.memberEmail = false;
    }
})


// 이름 유효성 검사
$("#memberNm").on("change", function(){

    const inputName = $(this).val();

    const regExp = /^[가-힣]{2,6}$/;

    if(inputName.length == 0){
        $("#checkNm").text("");
        updateCheckObj.memberNm = false;
    }else if(regExp.test(inputName)){
		$("#checkNm").text("");
        updateCheckObj.memberNm = true;
    }else{
        $("#checkNm").text("사용 불가").css("color", "red");
        updateCheckObj.memberNm = false;
    }

})



// 비밀번호 유효성 검사
document.getElementById("pwd1").addEventListener("change", (e)=> {
    const inputPw = e.target.value;
    const regExp = /^[a-zA-z\d\!\@\#\-\_]{6,20}$/;
    const checkPw1 = document.getElementById("checkPw1");

    if(inputPw.length==0){
        checkPw1.innerText = "";
        updateCheckObj.pwd1 = false;
    }else if(regExp.test(inputPw)){
        checkPw1.innerText = "사용 가능";
        checkPw1.style.color = "green";
        updateCheckObj.pwd1 = true;
    }else{
        checkPw1.innerText = "사용 불가";
        checkPw1.style.color = "red";
        updateCheckObj.pwd1 = false;
    }

})


// 비밀번호 확인 유효성 검사
$("#pwd2, #pwd1").on("change", function(e){
    const pwd1 = document.getElementById("pwd1").value;
    const pwd2 = document.getElementById("pwd2").value;

    const checkPw2 = document.getElementById("checkPw2");

    if(pwd2.trim().length == 0){
        checkPw2.innerText = "";
        updateCheckObj.pwd2 = false;
    }else if(pwd1 == pwd2){
        checkPw2.innerText = "일치";
        checkPw2.style.color = "green";
        updateCheckObj.pwd2 = true;
    }else{
        checkPw2.innerText = "불일치";
        checkPw2.style.color = "red";
        updateCheckObj.pwd2 = false;
    }

})


// 전화번호 글자 수 제한 + 유효성 검사
$(".phone-length").on("change", function(){

    if( $(this).val().length > 4){

        const num = $(this).val().slice(0,4);

        $(this).val(num);

    }

    const inputPhone2 = document.getElementById("memberPhone2").value;
    const inputPhone3 = document.getElementById("memberPhone3").value;

    const regExp2 = /^\d{3,4}$/;
    const regExp3 = /^\d{4}$/;

    if(inputPhone2.length == 0 && inputPhone3.length == 0 ){
        updateCheckObj.memberPhone3 = false;
    }else if(regExp2.test(inputPhone2) && regExp3.test(inputPhone3)){
        updateCheckObj.memberPhone3 = true;
    }else{
        updateCheckObj.memberPhone3 = false;
    }

})