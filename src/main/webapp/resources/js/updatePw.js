// 각 입력 값이 유효성 검사를 진행했는지 기록할 객체
const updateCheckObj = {
    "pwd1" : false,
    "pwd2" : false
}


function validate(){

    for(key in updateCheckObj){
        if( !updateCheckObj[key] ){

            let message;
            
            switch(key){
            case "pwd1" : message = "비밀번호가 유효하지 않습니다."; break;
            case "pwd2" : message = "비밀번호가 일치하지 않습니다."; break;
            }

            alert(message);

            document.getElementById(key).focus();

            return false;
        }

    }

}


// 비밀번호 유효성 검사
document.getElementById("pwd1").addEventListener("change", (e)=> {
    const inputPw = e.target.value;
    const regExp = /^[a-zA-z\d\!\@\#\-\_]{6,20}$/;
    const checkPw1 = document.getElementById("checkPw1");

    if(inputPw.length==0){
        checkPw1.innerHTML = "";
        updateCheckObj.pwd1 = false;
    }else if(regExp.test(inputPw)){
        checkPw1.innerHTML = "&#8730;";
        checkPw1.style.color = "green";
        updateCheckObj.pwd1 = true;
    }else{
        checkPw1.innerHTML = "&#215;";
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
        checkPw2.innerHTML = "";
        updateCheckObj.pwd2 = false;
    }else if(pwd1 == pwd2){
        checkPw2.innerHTML = "&#8730;";
        checkPw2.style.color = "green";
        updateCheckObj.pwd2 = true;
    }else{
        checkPw2.innerHTML = "&#215;";
        checkPw2.style.color = "red";
        updateCheckObj.pwd2 = false;
    }

})

