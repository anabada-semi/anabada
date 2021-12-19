<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	구매내역 <span id="buyText">0</span>
</div>

<hr>

<table>
	<tr><td></td><td></td><td></td><td></td></tr>
	<tr class="buyTr">
		<td class="buyTd">
			<div class="buyImgDiv">
				<span class="buyImgSpan"> 구매 완료 </span>
				<img class="buyImg" src="${contextPath}/resources/images/myShop/buyList/신발.jpg">
			</div>
			
			<div class="buyTextDiv">
				<div class="buyText1">운동화 팔아요~</div>
				<div class="buyText2">40,000원</div>
				<div class="buyText3">10분 전</div>
			</div>
		</td>
		<td class="buyTd">
			<div class="buyImgDiv">
				<span class="buyImgSpan"> 구매 완료 </span>
				<img class="buyImg"src="${contextPath}/resources/images/myShop/buyList/핸드폰.jpg">
			</div>
			<div class="buyTextDiv">
				<div class="buyText1">핸드폰 팔아요</div>
				<div class="buyText2">200,000원</div>
				<div class="buyText3">3일 전</div>
			</div>
		</td>
		<td class="buyTd">
			<div class="buyImgDiv">
				<span class="buyImgSpan"> 구매 완료 </span>
				<img class="buyImg" src="${contextPath}/resources/images/myShop/buyList/셔츠_여.jpg">
			</div>
			<div class="buyTextDiv">
				<div class="buyText1">셔츠</div>
				<div class="buyText2">20,000원</div>
				<div class="buyText3">4달 전</div>
			</div>
		</td>
	</tr>
</table>


<script>
	(function(){
		$("#buyText").text($(".buyTd").length);
	}());
	
	$(".buyTd").on("click", function(){
		(function(){
			$("#buyText").text($(".buyTd").length);
		}());
	});
</script>
