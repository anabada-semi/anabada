// 댓글 목록 조회
function selectReplyList() {

    // ajax를 이용해 비동기로 댓글 목록 조회 및 출력
    $.ajax({
        url : contextPath + "/reply/select",
        data : {"itemNo" : itemNo}, // 
        type : "GET",
        dataType : "JSON",  // 반환되는 데이터 형식 지정 -> 응답 받은 후 형변환 진행
        success : function(rList){
            // console.log(rList);

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

// -----------------------------------------------------------------------------------------
// 댓글 수정 폼으로 전환
function showUpdateReply(replyNo, el) {

    //console.log($(".replyUpdateContent").length);

    // 이미 열려있는 댓글 수정 창이 있을 경우 닫아주기
    if ($(".replyUpdateContent").length > 0) {
        
        if(confirm("확인 클릭 시 수정된 내용이 사라지게 됩니다.")){
            $(".replyUpdateContent").eq(0).parent().html(beforeReplyRow);
        }else{
            return;
        }
    }

    // 댓글 수정화면 출력 전 요소를 저장해둠.
    beforeReplyRow = $(el).parent().parent().html();
    // console.log(beforeReplyRow);

    // 작성되어있던 내용(수정 전 댓글 내용) 
    let beforeContent = $(el).parent().prev().html();

    // 이전 댓글 내용의 크로스사이트 스크립트 처리 해제, 개행문자 변경
    // -> 자바스크립트에는 replaceAll() 메소드가 없으므로 정규 표현식을 이용하여 변경 -> 'g'
    beforeContent = beforeContent.replace(/&amp;/g, "&");
    beforeContent = beforeContent.replace(/&lt;/g, "<");
    beforeContent = beforeContent.replace(/&gt;/g, ">");
    beforeContent = beforeContent.replace(/&quot;/g, "\"");

    beforeContent = beforeContent.replace(/<br>/g, "\n");


    // 기존 댓글 영역을 삭제하고 textarea를 추가 
    $(el).parent().prev().remove();
    const textarea = $("<textarea>").addClass("replyUpdateContent").attr("rows", "3").val(beforeContent);
    $(el).parent().before(textarea);


    // 수정 버튼
    const updateReply = $("<button>").addClass("btn btn-primary btn-sm ml-1 mb-4").text("댓글 수정").attr("onclick", "updateReply(" + replyNo + ", this)");

    // 취소 버튼
    const cancelBtn = $("<button>").addClass("btn btn-primary btn-sm ml-1 mb-4").text("취소").attr("onclick", "updateCancel(this)");

    const replyBtnArea = $(el).parent();

    $(replyBtnArea).empty();
    $(replyBtnArea).append(updateReply);
    $(replyBtnArea).append(cancelBtn);
}

//-----------------------------------------------------------------------------------------
//댓글 수정폼에서 취소 시 원래대로 돌아가기

function updateCancel(el) {
    // el : 클릭된 취소 버튼
    $(el).parent().parent().html(beforeReplyRow);
}

//-----------------------------------------------------------------------------------------
// 댓글 수정

function updateReply(replyNo, el) {
    // replyNo : 수정할 댓글의 번호

    // el : 댓글 수정 버튼
    // 댓글 수정 버튼의 부모의 이전요소의 값
    const replyContent = $(el).parent().prev().val();

    $.ajax({
        url : contextPath + "/reply/update",
        data : {"replyNo" : replyNo, "replyContent" : replyContent},
        type : "POST",
        success : function(result){
            if(result > 0){
                alert("댓글이 수정되었습니다.");
                selectReplyList();  // 댓글 조회 함수 호출 -> 댓글 화면 다시 만들기
            }else{
                alert("댓글 수정 실패.");
            }
        },

        error : function(req, status, error){
            console.log("댓글 수정 실패");
            console.log(req.responseText);
        }

    });
}

//-----------------------------------------------------------------------------------------
//댓글 삭제
function deleteReply(replyNo) {

    if(confirm("정말로 삭제하시겠습니까?")){
        
        $.ajax({
            url : contextPath + "/reply/delete",
            data : {"replyNo" : replyNo},
            type : "POST",
            success : function(result){
    
                if(result > 0){
                    alert("댓글이 삭제되었습니다.");
                    selectReplyList();  // 댓글 조회 함수 호출 -> 댓글 화면 다시 만들기
                }else{
                    alert("댓글 삭제 실패.");
                }
            },
    
            error : function(req, status, error){
                console.log("댓글 삭제 실패");
                console.log(req.responseText);
            }
    
        });
    }

}

//-----------------------------------------------------------------------------------------
// 댓글 수정 폼으로 전환
function answerReply(replyNo, memberNo, el) {

    //console.log($(".replyUpdateContent").length);

    // 이미 열려있는 댓글 수정 창이 있을 경우 닫아주기
    if ($(".answerContent").length > 0) {
        
        if(confirm("확인 클릭 시 입력한 내용이 사라지게 됩니다.")){
            $(".answerContent").eq(0).parent().html(beforeReplyRow);
        }else{
            return;
        }
    }

    // 댓글 수정화면 출력 전 요소를 저장해둠.
    beforeAnswerRow = $(el).parent().parent().html();
    // console.log(beforeReplyRow);

    // 작성되어있던 내용(수정 전 댓글 내용) 
    let beforeAnswerContent = $(el).parent().prev().html();

    // 이전 댓글 내용의 크로스사이트 스크립트 처리 해제, 개행문자 변경
    // -> 자바스크립트에는 replaceAll() 메소드가 없으므로 정규 표현식을 이용하여 변경 -> 'g'
    beforeAnswerContent = beforeAnswerContent.replace(/&amp;/g, "&");
    beforeAnswerContent = beforeAnswerContent.replace(/&lt;/g, "<");
    beforeAnswerContent = beforeAnswerContent.replace(/&gt;/g, ">");
    beforeAnswerContent = beforeAnswerContent.replace(/&quot;/g, "\"");

    beforeAnswerContent = beforeAnswerContent.replace(/<br>/g, "\n");


    // 기존 댓글 영역을 삭제하고 textarea를 추가 
    $(el).parent().prev().remove();
    const textarea = $("<textarea>").addClass("answerContent").attr("rows", "3").val(beforeContent);
    $(el).parent().before(textarea);


    // 수정 버튼
    const updateReply = $("<button>").addClass("btn btn-primary btn-sm ml-1 mb-4").text("답변 수정").attr("onclick", "updateReply(" + replyNo + ", this)");

    // 취소 버튼
    const cancelBtn = $("<button>").addClass("btn btn-primary btn-sm ml-1 mb-4").text("취소").attr("onclick", "updateCancel(this)");

    const replyBtnArea = $(el).parent();

    $(replyBtnArea).empty();
    $(replyBtnArea).append(updateReply);
    $(replyBtnArea).append(cancelBtn);
}