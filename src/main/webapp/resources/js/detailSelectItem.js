// 댓글 목록 조회
function selectReplyList() {

    // ajax를 이용해 비동기로 댓글 목록 조회 및 출력
    $.ajax({
        url : contextPath + "/reply/select",
        data : {"itemNo" : itemNo}, // 
        type : "GET",
        dataType : "JSON",  // 반환되는 데이터 형식 지정 -> 응답 받은 후 형변환 진행
        success : function(rList){
            console.log(rList);

            $("#replyListArea").empty();   // 기존 댓글 내용 모두 삭제

            $.each(rList, function(index, reply){   // jQuery 반복문
                // console.log(reply.replyContent);

                // const li = $("<li>").addClass("reply-row");
                const li = $('<li class="reply-row">');
                const div = $("<div>");
                
                const rWriter = $('<p class="rWriter">').text(reply.memberName);
                const rDate = $('<p class="rDate">').text("작성일 : " + reply.replyCreateDate);

                // div에 자식으로 rWriter, rDate 추가
                div.append(rWriter, rDate);

                // 댓글 내용
                const rContent = $('<p class="rContent">').html(reply.replyContent);
                // text로 내용을 작성하게 되면 개행문자 처리에서 html로 인식을 안해서 띄어쓰기와 특정 문자 처리가 되지 않음
                // => html로 작성

                li.append(div, rContent);

                // 댓글 작성자 == 로그인 멤버 -> 버튼 영역 생성
                if(reply.memberNo == loginMemberNo){
                    
                    const replyBtnArea = $('<div class="replyBtnArea">');

                    const showUpdate = $('<button>').addClass("btn btn-primary btn-sm ml-1").text("수정");
                    showUpdate.attr("onclick", "showUpdateReply("+reply.replyNo+", this)");

                    const deleteReply = $('<button>').addClass("btn btn-primary btn-sm ml-1").text("삭제");
                    deleteReply.attr("onclick", "deleteReply("+reply.replyNo+")");

                    replyBtnArea.append(showUpdate, deleteReply);
                    li.append(replyBtnArea);
                }
                $("#replyListArea").append(li);

            });
        },
        error : function(req, status, error){
            console.log("댓글 목록 조회 실패");
            console.log(req.responseText);
        }
    });

}

// -----------------------------------------------------------------------------------------

// 댓글 등록
function addReply(){

    
            $.ajax({
                url : contextPath + "/reply/insert",
                data : {"memberNo" : loginMemberNo, 
                        "itemNo" : itemNo, 
                        "replyContent" : $("#replyContent").val(),
                        "secret" : $("#secret").prop("checked")
                        },
                type : "POST",  // insert는 대부분 post 방식
                // dataType : "JSON",   // 성공 실패만 알면 되므로 JSON 필요 없음
                success : function(result){
                    console.log(result);

                    if(result > 0){
                        alert("댓글이 등록되었습니다.");
                        $("#replyContent").val(""); // 작성한 댓글 내용 삭제
                        selectReplyList();  // 댓글 조회 함수 호출 -> 댓글 화면 다시 만들기
                    }else{
                        alert("댓글 등록 실패.");
                    }
                },
                error : function(req, status, error){
                    console.log("댓글 삽입 실패");
                    console.log(req.responseText);
                }
            });

        
}