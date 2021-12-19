// 각 입력 값이 유효성 검사를 진행했는지 기록할 객체
const signUpCheckObj = {
    "id" : false,
    "name" : false,
    "email" : false,
    "pwd1" : false,
    "pwd2" : false,
    "phone3" : false

}


function validate(){
	/*
    for(key in signUpCheckObj){
        if( !signUpCheckObj[key] ){

            let message;
            
            switch(key){
            case "id" : message = "아이디가 유효하지 않습니다."; break;
            case "name" : message = "이름이 유효하지 않습니다."; break;
            case "email" : message = "이메일이 유효하지 않습니다."; break;
            case "pwd1" : message = "비밀번호가 유효하지 않습니다."; break;
            case "pwd2" : message = "비밀번호가 일치하지 않습니다."; break;
            case "phone3" : message = "전화번호가 유효하지 않습니다."; break;
            }

            alert(message);

            document.getElementById(key).focus();

            return false;
        }

    }
	*/
}


// 이름 유효성 검사
$("#memberNm").on("input", function(){

    const inputName = $(this).val();

    const regExp = /^[가-힣]{2,6}$/;

    if(inputName.length == 0){
        $("#checkNm").text("");
        signUpCheckObj.name = false;
    }else if(regExp.test(inputName)){
		$("#checkNm").text("");
        signUpCheckObj.name = true;
    }else{
        $("#checkNm").text("사용 불가").css("color", "red");
        signUpCheckObj.name = false;
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
        signUpCheckObj.phone3 = false;
    }else if(regExp2.test(inputPhone2) && regExp3.test(inputPhone3)){
        signUpCheckObj.phone3 = true;
    }else{
        signUpCheckObj.phone3 = false;
    }

})