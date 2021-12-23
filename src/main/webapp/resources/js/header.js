let noticeList = []; // 비어있는 배열(리스트)

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
 
}, 10000); // 10초마다 반복