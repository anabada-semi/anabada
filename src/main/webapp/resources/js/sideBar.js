
const heart = document.getElementById("heart");

 $.ajax({
        url : contextPath + "/sideBar/wish",
        type : "GET",
        success : function(result){
			
			if(result > 0){
				heart.innerText = result;
				$(".heart").css("color", "crimson");
				
			}else{
				heart.innerText = result;
				$(".heart").css("color", "rgb(205, 205, 205)");
			}

        },

        error : function(request, status, error){
            console.log("ajax 통신중 오류 발생");
            console.log(request.responseText);
        },

        complete : function(){
			
        }
    });


document.getElementById
