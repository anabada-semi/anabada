/* let noticeList = []; // 비어있는 배열(리스트)

window.setInterval(function(){ 
  // 알람 테이블 조회 ajax
  
  $.ajax({
    url : contextPath + "/notice/select",
    
    success : function(selectList){
      
      if(noticeList.length == 0){ // 이전 알람이 없다면 
        noticeList = selectList;  // 조회한 알람 대입
      }

    }
  
  })
 
}, 10000); // 10초마다 반복 */


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

function categoryClick(el){
  console.log(el.value);
}