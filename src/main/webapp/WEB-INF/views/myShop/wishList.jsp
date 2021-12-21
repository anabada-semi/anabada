<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	찜 <span id="wishSpanText">0</span> (삭제 하려면 이미지를 클릭해주세요.)
</div>

<hr>
<div class="wishContainer">
	<img class="wishImg"
		src="${contextPath}/resources/images/myShop/wishList/운동화.jpg">
	<div class="wishTextDiv">
		<div class="wishTitle">
			운동화 팔아요~
			<button class="wishDeleteBtn">찜 삭제</button>
		</div>
		<div class="wishText1">40,000원</div>
		<div class="wishText2">10분 전</div>
	</div>
</div>

<div class="wishContainer">
	<img class="wishImg"
		src="${contextPath}/resources/images/myShop/wishList/핸드폰.jpg">
	<div class="wishTextDiv">
		<div class="wishTitle">
			핸드폰 팔아요
			<button class="wishDeleteBtn">찜 삭제</button>
		</div>
		<div class="wishText1">200,000원</div>
		<div class="wishText2">3일 전</div>
	</div>
</div>

<div class="wishContainer">
	<img class="wishImg"
		src="${contextPath}/resources/images/myShop/wishList/책.jpg">
	<div class="wishTextDiv">
		<div class="wishTitle">
			JS 책팜
			<button class="wishDeleteBtn">찜 삭제</button>
		</div>
		<div class="wishText1">2,000원</div>
		<div class="wishText2">7일 전</div>
	</div>
</div>


<script>
	(function() {
		//console.log($(".wishContainer").length);
		$("#wishSpanText").text($(".wishContainer").length);
	}());

	$(".wishDeleteBtn").on("click", function() {
		const idx = $(".wishDeleteBtn").index($(this));

		if (confirm("삭제할래요?")) {
			$(".wishContainer").eq(idx).remove();
		} else {
			return;
		}

		// 즉시 실행 함수
		(function() {
			//console.log($(".wishDeleteBtn").length);
			$("#wishSpanText").text($(".wishDeleteBtn").length);
		}());

	});
</script>



