let noticeListSave = []; // 비어있는 배열(리스트)
let imgurl = contextPath+"/resources/images/header+footer/알림.png";

selectNoticeList();

// 알림 조회 함수
function selectNoticeList(){
  $.ajax({
    url : contextPath + "/notice/select",
    dataType : "JSON",
    success : function (selectList){
      
      const selectListJson = JSON.stringify(selectList);

      if(loginMemberNo.length != 0){  // 로그인 한 경우

          // 이전 알림이 없다면 ==> noticeListSave에 알림이 저장되어 있지않다면 => 로그인 했다면
          if(noticeListSave.length == 0){ 
            noticeListSave = selectListJson;  // 조회한 알람 대입

            $.each(selectList, function(index, selectList){   // jQuery 반복문

              if(selectList.status == 1){ // 삽입된 알림이면(보지 않았다면)

                imgurl = contextPath+"/resources/images/header+footer/알림2.png";
                $("#notice-img").attr("src", imgurl).addClass("blink");
                return false;
              }

            });

          }

          // 이전 알림이 있다면 ==> noticeListSave에 알림이 저장되어있다면
          else{
            
            // 조회한 알림과 이전 알림이 다를 때
            if(selectListJson != noticeListSave){
              
                imgurl = contextPath+"/resources/images/header+footer/알림.png";
                $("#notice-img").attr("src", imgurl).removeClass("blink");
            }

            // 조회한 알림과 이전 알림이 같을 때
            if(selectListJson == noticeListSave){
              $.each(selectList, function(index, selectList){   // jQuery 반복문

                if(selectList.status == 1){ // 삽입된 알림이면(보지 않았다면)
                  
                  imgurl = contextPath+"/resources/images/header+footer/알림2.png";
                  $("#notice-img").attr("src", imgurl).addClass("blink");
                  return false;
                }
                else{
                  imgurl = contextPath+"/resources/images/header+footer/알림.png";
                  $("#notice-img").attr("src", imgurl).removeClass("blink");
                }
              });

            }

          } /* end else */
      } /* end if */
    } /* end function */
  });
}

// 10초마다 알림 조회 
window.setInterval(function selectNotice(){ 
  // 알람 테이블 조회 ajax
  selectNoticeList();
}, 10000); // 10초마다 반복

// -----------------------------------------------------------------------------------------
// 알림 클릭시
function clickNotice(){
  
  imgurl = contextPath+"/resources/images/header+footer/알림.png";
  
  $.ajax({
    url : contextPath + "/notice/updateView",
    dataType : "JSON",
    success : function(noticeList){
      
      noticeListSave = JSON.stringify(noticeList);
      $("#notice-img").attr("src", imgurl).removeClass("blink");
      
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
            
            if(noticeList.noticeContent == 1){  // 댓글이 달렸을 경우
              let li = $("<li onclick='goNotice(1, this, "+noticeList.noticeNo+")'>")
              
              li.text(noticeList.itemName + " 상품에 댓글이 달렸습니다.");
              li.val(noticeList.itemNo);
              noticeUl.append(li);
            }
            
            else if(noticeList.noticeContent == 2 && noticeList.replyMemberNo != noticeList.memberNo){ // 대댓글이 달렸을 경우
              let li = $("<li onclick='goNotice(1, this, "+noticeList.noticeNo+")'>")
              
              li.text(noticeList.itemName + "상품에 대댓글이 달렸습니다." );
              li.val(noticeList.itemNo);
              noticeUl.append(li);
            }
            
            else if(noticeList.noticeContent == 3){
              let li = $("<li onclick='goNotice(2, this, "+noticeList.noticeNo+")'>")
              
              li.text("내 상점에 후기가 달렸습니다." );
              li.val(noticeList.shopNo);
              noticeUl.append(li);
            }
          });
          
        }
        
      }
    },
  });
  
};

// -----------------------------------------------------------------------------------------
function goNotice(no, el, noticeNo){
  
  let value = el.value;

  console.log("noticeNo: " + noticeNo);

  // 댓글에 관한 알림이면
  if(no == 1){
    location.href= contextPath+'/detail/select?no='+value;
  } 
  // 후기에 관한 알림이면
  else{
    location.href= contextPath+'/myShop/myShop?no='+value;
  }
  
  $.ajax({
    url : contextPath + "/notice/update",
    data : {"noticeNo" : noticeNo},
    type : "POST",
    success : function(result){

      if(result == 0){
        alert("업데이트 실패");
      }
      else{
        console.log("업데이트 됨");
      }
    }
  });

}

// -----------------------------------------------------------------------------------------
// 알림 영역 벗어나면 div 영역 없어지게
$("#notice-area").mouseleave(function(){
  $(this).css("display", "none");
});

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