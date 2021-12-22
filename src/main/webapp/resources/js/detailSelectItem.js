// 댓글 목록 조회
function selectReplyList() {

    // ajax를 이용해 비동기로 댓글 목록 조회 및 출력
    $.ajax({
        url : contextPath + "/reply/select",
        data : {"itemNo" : itemNo}, // 
        type : "GET",
        dataType : "JSON",  // 반환되는 데이터 형식 지정 -> 응답 받은 후 형변환 진행
        success : function(rList){

            $("#replyListArea").empty();   // 기존 댓글 내용 모두 삭제
            
            const answer = rList;
            // console.log("? ",rList.replyDate);
            $.each(rList, function(index, reply){   // jQuery 반복문
                
                if(reply.replyNestedCode == 1){ // 기본 댓글(대댓글이 아니면)
                    
                    var date = new Date(reply.replyDate).toISOString().replace("T", " ").replace(/\..*/, '');

                    const replyRow = $('<li class="reply-row">');
                    const replyPadding = $("<div>").addClass("reply-padding");
                    
                    const rWriter = $('<p class="rWriter">').text(reply.memberName);
                    const rDate = $('<p class="rDate">').text("작성일 : " + date);

                    const answerArea = $("<div>").addClass("answerArea");
                    const answerListArea = $("<ul>").addClass("answerListArea");

                    // div에 자식으로 rWriter, rDate 추가
                    replyPadding.append(rWriter, rDate);
    
                    // 댓글 내용
                    const rContent = $('<p class="rContent">').html(reply.replyContent);
                    // text로 내용을 작성하게 되면 개행문자 처리에서 html로 인식을 안해서 띄어쓰기와 특정 문자 처리가 되지 않음
                    // => html로 작성
    
                    replyRow.append(replyPadding, rContent);
                    
                    // 판매자 == 로그인 멤버 || 댓글 작성자 == 로그인 멤버-> 답글 버튼 생성
                    if(itemMemberNo == loginMemberNo || reply.memberNo == loginMemberNo){
                        
                        const answerReply = $('<button>').addClass("reply-submit").text("답글");
                        answerReply.attr("onclick", "answerReply("+reply.replyNo+", loginMemberNo, this)");
                        
                        const replyBtnArea = $('<div class="replyBtnArea">');

                        // 댓글 작성자 == 로그인 멤버 -> 수정, 삭제 버튼 영역 생성
                        if(reply.memberNo == loginMemberNo){
                            const showUpdate = $('<button>').addClass("reply-submit").text("수정");
                            showUpdate.attr("onclick", "showUpdateReply("+reply.replyNo+", this)");
        
                            const deleteReply = $('<button>').addClass("reply-submit").text("삭제");
                            deleteReply.attr("onclick", "deleteReply("+reply.replyNo+")");
                            
                            replyBtnArea.append(deleteReply, showUpdate);
                        }
                        
                        replyBtnArea.append(answerReply);
                        replyRow.append(replyBtnArea);
                        // $("#replyListArea").append(li);
                    }

                    $.each(answer, function(index, answer){   // jQuery 반복문

                        var answerDate =new Date(answer.replyDate).toISOString().replace("T", " ").replace(/\..*/, '');

                        if(answer.replyNestedNo == reply.replyNo){
        
                            const answerRow = $("<li>").addClass("answer-row");
                            const answerSign = $("<p>").addClass("answer-sign").text("⤷");
                            const answerPadding = $("<div>").addClass("answer-padding");
                            const rWriter = $("<p>").addClass("rWriter").text(answer.memberName);
                            const rDate = $("<p>").addClass("rDate").text(answerDate);
                            const rContent = $("<p>").addClass("rContent").text(answer.replyContent);
                            const replyBtnArea = $("<div>").addClass("replyBtnArea");

                            answerPadding.append(rWriter,rDate,rContent);

                            answerRow.append(answerSign, answerPadding);

                            if(reply.memberNo == loginMemberNo){
                                
                                const deleteReplyAnswer = $('<button>').attr("id","deleteReply").text("삭제");
                                deleteReplyAnswer.attr("onclick", "deleteReply("+answer.replyNo+")");

                                const updateAnswerReply = $('<button>').attr("id","updateReply").text("수정");
                                updateAnswerReply.attr("onclick", "updateAnswerReply("+answer.replyNo+", loginMemberNo, this)");

                                replyBtnArea.append(deleteReplyAnswer, updateAnswerReply);
                                answerRow.append(replyBtnArea);
                            }

                            answerListArea.prepend(answerRow);
                        }
                        answerArea.append(answerListArea);
                        replyRow.append(answerArea);
                    });

                        $("#replyListArea").append(replyRow);
                }
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

    if(loginMemberNo == ""){    // 로그인이 되어 있지 않은 경우
        alert("로그인 후 이용해 주세요.");

    }else{  // 로그인한 경우

        // 댓글 미작성한 경우
        if( $("#replyContent").val().trim().length == 0 ){
            alert("댓글을 작성한 후 버튼을 클릭해주세요.");
            $("#replyContent").focus();

        } else{ // 댓글을 작성한 경우
    
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
    }

        
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
// 답변 폼으로 전환
function answerReply(replyNo, memberNo, el) {

    // 이미 열려있는 댓글 수정 창이 있을 경우 닫아주기
    if ($(".answerContent").length > 0) {
        
        if(confirm("확인 클릭 시 입력한 내용이 사라지게 됩니다.")){
            $(".answerContent").eq(0).parent().html(beforeReplyRow);
        }else{
            return;
        }
    }
    
    const replyBtnArea1 = $(el).parent();

    beforeAnswerBtn1 = replyBtnArea1.html();
    
    const ul = $(el).parent().next().find("ul");

    const div = $("<div>").addClass("replyBtnArea");

    replyBtnArea1.remove();

    // textarea를 추가 
    const textarea = $("<textarea>").addClass("answerContent").attr("rows", "3").attr("placeholder", "답글을 입력해주세요.");
    
    // 답변 등록 버튼
    const updateReply = $("<button>").addClass("reply-submit").text("답변 등록").attr("onclick", "insertAnswer(" + replyNo + ", this)");
    
    // 취소 버튼
    const cancelBtn = $("<button>").addClass("reply-submit").text("취소").attr("onclick", "Cancel(this)");
    
    div.append(updateReply, cancelBtn);
    
    ul.parent().prepend(textarea, div);
}

//-----------------------------------------------------------------------------------------
// 대댓글 수정 폼 취소
function Cancel(el) {
    // el : 클릭된 취소 버튼
    const div = $("<div>").addClass("replyBtnArea").html(beforeAnswerBtn1);
    
    $(el).parent().parent().before(div);

    $(el).parent().prev().remove();
    $(el).parent().remove();
}

//-----------------------------------------------------------------------------------------
// 대댓글 삽입
function insertAnswer(replyNo, el){

    if(loginMemberNo == ""){    // 로그인이 되어 있지 않은 경우
        alert("로그인 후 이용해 주세요.");

    }else{  // 로그인한 경우
    
        $.ajax({
            url : contextPath + "/answer/insert",
            data : {"memberNo" : loginMemberNo, 
                    "itemNo" : itemNo, 
                    "replyNo" : replyNo,
                    "replyContent" : $(el).parent().prev().val()
                    },
            type : "POST",  // insert는 대부분 post 방식
            // dataType : "JSON",   // 성공 실패만 알면 되므로 JSON 필요 없음
            success : function(result){

                console.log("result:" + result);

                if(result > 0){
                    alert("대댓글이 등록되었습니다.");
                    $(el).parent().prev().val(""); // 작성한 대댓글 내용 삭제
                    selectReplyList();  // 댓글 조회 함수 호출 -> 댓글 화면 다시 만들기
                }else{
                    alert("대댓글 등록 실패.");
                }
            },
            error : function(req, status, error){
                console.log("대댓글 삽입 실패");
                console.log(req.responseText);
            }
        });
    }

}

//-----------------------------------------------------------------------------------------
// 대댓글 수정
function updateAnswerReply(replyNo, memberNo, el){
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
    let beforeContent = $(el).parent().prev().find(".rContent").html();
    console.log("전:" + beforeContent);

    // 이전 댓글 내용의 크로스사이트 스크립트 처리 해제, 개행문자 변경
    // -> 자바스크립트에는 replaceAll() 메소드가 없으므로 정규 표현식을 이용하여 변경 -> 'g'
    beforeContent = beforeContent.replace(/&amp;/g, "&");
    beforeContent = beforeContent.replace(/&lt;/g, "<");
    beforeContent = beforeContent.replace(/&gt;/g, ">");
    beforeContent = beforeContent.replace(/&quot;/g, "\"");

    beforeContent = beforeContent.replace(/<br>/g, "\n");


    // 기존 댓글 영역을 삭제하고 textarea를 추가 
    $(el).parent().prev().find(".rContent").remove();
    const textarea = $("<textarea>").addClass("replyUpdateContent").attr("rows", "3").val(beforeContent);
    $(el).parent().before(textarea);

    // 수정 버튼
    const updateReply = $("<button>").addClass("reply-submit").text("수정 완료").attr("onclick", "updateReply(" + replyNo + ", this)");

    // 취소 버튼
    const cancelBtn = $("<button>").addClass("reply-submit").text("취소").attr("onclick", "updateCancel(this)");

    const replyBtnArea = $(el).parent();

    $(replyBtnArea).empty();
    $(replyBtnArea).append(updateReply);
    $(replyBtnArea).append(cancelBtn);
}

//-----------------------------------------------------------------------------------------
//문의하기 버튼 클릭시 이동
$(document).ready(function() {

    $("#question").click(function(event){         
            event.preventDefault();
            $('html,body').animate({scrollTop:$("#item-question").offset().top}, 500);
    });

});

//-----------------------------------------------------------------------------------------
// 찜 버튼 클릭시
function wish(replyNo, el){
    
    if(loginMemberNo == ""){    // 로그인이 되어 있지 않은 경우
        alert("로그인 후 이용해 주세요.");

    }else{  // 로그인한 경우
        $.ajax({
            url : contextPath + "/wish/select",
            data : {"memberNo" : loginMemberNo, 
                    "itemNo" : itemNo, 
                    },
            type : "POST",  // insert는 대부분 post 방식
            success : function(result){

                // (0: 삽입 실패, 1: 삽입됨, -1: 있음, -2: 삭제됨)
                if(result > 0){ // 찜목록에 없는경우
                    alert("찜 목록에 추가되었습니다.");
                    updateWishCount();

                }else if(result == -1){ // 이미 찜한 경우
                    if(confirm("이미 찜 목록에 추가되어 있습니다. 찜 목록에서 삭제하시겠습니까?")){
                        deleteWish(itemNo);
                    }

                } else{ // 찜 내역에 있었지만 삭제된 경우
                    updateWish(itemNo);   // 찜 테이블에 추가
                }
            },
            error : function(req, status, error){
                console.log("찜 목록 추가 실패");
                console.log(req.responseText);
            } 
        });
    }
}

//-----------------------------------------------------------------------------------------
// 찜 추가(update)
function updateWish(itemNo){

    $.ajax({
        url : contextPath + "/wish/update",
        data : {"memberNo" : loginMemberNo, 
                "itemNo" : itemNo, 
                },
        type : "POST",  // insert는 대부분 post 방식
        success : function(result){

            if(result > 0){ // 찜 목록에 WISH_STATUS_CD 값이 1로 바뀌었을 경우
                alert("찜 목록에 추가되었습니다.");
                updateWishCount();
                
            } else{ // 바뀌지 않았을 경우
                alert("찜 목록 추가 실패");
            }
        },
        error : function(req, status, error){
            console.log("찜 목록 추가 실패");
            console.log(req.responseText);
        } 
    });
}

//-----------------------------------------------------------------------------------------
// 찜 삭제
function deleteWish(itemNo){

    $.ajax({
        url : contextPath + "/wish/delete",
        data : {"memberNo" : loginMemberNo, 
                "itemNo" : itemNo, 
                },
        type : "POST",  // insert는 대부분 post 방식
        success : function(result){

            if(result > 0){ // 찜목록에 없는경우
                alert("찜 목록에서 제거되었습니다.");
                updateWishCount();

            } else{ 
                console.log("찜 목록 삭제 실패");
            }
        },
        error : function(req, status, error){
            console.log("찜 목록 삭제 실패");
            console.log(req.responseText);
        } 
    });
}

//-----------------------------------------------------------------------------------------
// 찜 갯수 업데이트
function updateWishCount(){

    const wishCount = $("#wish-count");

    $.ajax({
        url : contextPath + "/wish/count",
        data : {"itemNo" : itemNo},
        type : "POST",  // insert는 대부분 post 방식
        success : function(count){
            // console.log("개수: " + count);
            wishCount.text(count);
        },
        error : function(req, status, error){
            console.log("찜 목록 추가 실패");
            console.log(req.responseText);
        } 
    });

}

//-----------------------------------------------------------------------------------------
// 조회수 증가
$(document).ready(function() {
    const readCount = $("#read-count");

    $.ajax({
        url : contextPath + "/detail/view",
        data : {"itemNo" : itemNo},
        type : "POST",  // insert는 대부분 post 방식
        success : function(view){
            readCount.text(view);
        },
        error : function(req, status, error){
            console.log("조회수 증가 실패");
            console.log(req.responseText);
        } 
    });
});