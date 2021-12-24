let noticeList = []; // 비어있는 배열(리스트)

window.setInterval(function(){ 
  // 알람 테이블 조회 ajax
  
  $.ajax({
    url : contextPath + "/notice/select",
    
    success : function(selectList){
      
      if(loginMemberNo != null){  // 로그인 한 경우
        
        let imgurl = contextPath+"/resources/images/header+footer/알림.png";

          if(noticeList.length == 0){ // 이전 알람이 없다면
            noticeList = selectList;  // 조회한 알람 대입
            
          } else{ // 이전 알람이 있다면
            
            if(noticeList != selectList){ // 이전 알림과 조회한 알람이 다를 때

              imgurl = contextPath+"/resources/images/header+footer/알림2.png";
              $("#notice-img").attr("src", imgurl).addClass("blink");

            } 
            /* else{ // 이전 알림과 조회한 알림이 같을 때

              $("#notice-img").attr("src", imgurl).removeClass("blink");
            } */
          }

      }
  
    } /* end function */

  }); /* end ajax */

}, 10000); // 10초마다 반복

// -----------------------------------------------------------------------------------------
// 카테고리 불러오기
$(document).ready(function() {

    $.ajax({
        url : contextPath + "/detail/category",
        dataType : "JSON",
        success : function(rList){
            $.each(rList, function(index, category){   // jQuery 반복문

                // let li = ("<li class='category_item' value="+category[i].categoryCode+" onclick='categoryClick(this)'>")
                let li = $("<li class='category_item'>");
                
                li.val(category.categoryCode);
                li.attr("onClick", "categoryClick(this)");
                li.text(category.categoryName);
                
                // $("#replyListArea").append(replyRow);
                $("#category-ul").append(li);
            });
        },
        error : function(req, status, error){
            console.log("카테고리 목록 조회 실패");
            console.log(req.responseText);
        }
    });

});

// -----------------------------------------------------------------------------------------
// 카테고리 클릭시 이동
function categoryClick(el){
  // console.log(el.value);
  let value = el.value;
  location.href= contextPath+'/categoryItem/list?category-tag='+value;
}

// -----------------------------------------------------------------------------------------
// 알림 클릭시
function clickNotice(){

  $.ajax({
    url : contextPath + "/notice/select",
    dataType : "JSON",
    success : function(noticeList){
      
      const noticeArea = $("#notice-area");
      const noticeUl = $(".notice-ul");
      
      noticeArea.css("display", "block");
      
      noticeUl.empty();
      
      if(loginMemberNo == ""){    // 로그인이 되어 있지 않은 경우
        alert("로그인 후 이용해 주세요.");
      }else{
        
        if(noticeList.length == 0){ // 알림이 없는 경우

          let li = $("<li>")
          li.text("알림이 없습니다.");
          noticeUl.append(li);

        }else{
          
          $.each(noticeList, function(index, noticeList){   // jQuery 반복문
            
            let li = $("<li>")
            // let reply = $('<span class="span-reply">댓글</span>')
            // let reply2 = $('<span class="span-reply">대댓글</span>')
  
            if(noticeList.noticeContent == 1){  // 댓글이 달렸을 경우
              // li.append(reply);
              li.text(noticeList.itemName + " 상품에 댓글이 달렸습니다.");
              li.val(noticeList.itemNo);
              noticeUl.append(li);
            }
            
            else if(noticeList.noticeContent == 2 && noticeList.replyMemberNo != noticeList.memberNo){ // 대댓글이 달렸을 경우
              // li.append(reply2);
              li.text(noticeList.itemName + "상품에 대댓글이 달렸습니다." );
              li.val(noticeList.itemNo);
              noticeUl.append(li);
            }
          });

        }

      }
    },
  });
  
};


// 알림 영역 벗어나면 div 영역 없어지게
$("#notice-area").mouseleave(function(){
    $(this).css("display", "none");
});
